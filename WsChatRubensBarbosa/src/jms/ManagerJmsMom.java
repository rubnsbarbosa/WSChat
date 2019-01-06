package jms;

import interfaces.ManagerMOM;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import org.exolab.jms.administration.JmsAdminServerIfc;
import org.exolab.jms.administration.AdminConnectionFactory;

/**
 * Created by Rubens Santos Barbosa. Web Services and MOM - WSChat December 2018
 */
public class ManagerJmsMom implements ManagerMOM {

    private JmsAdminServerIfc manager = null;
    private QueueConnectionFactory qfactory = null;
    private Context context = null;

    public ManagerJmsMom() {

        try {
            String url = "tcp://localhost:3035/";
            String user = "admin";
            String password = "openjms";
            manager = AdminConnectionFactory.create(url, user, password);

            Hashtable properties = new Hashtable();
            properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.exolab.jms.jndi.InitialContextFactory");
            properties.put(Context.PROVIDER_URL, "tcp://localhost:3035/");

            context = new InitialContext(properties);

            qfactory = (QueueConnectionFactory) context.lookup("ConnectionFactory");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void createUserQueue(String queue) {
        Boolean isQueue = Boolean.TRUE;
        try {
            if (!manager.destinationExists(queue)) {
                if (!manager.addDestination(queue, isQueue)) {
                    System.err.println("Cannot create queue " + queue);
                }
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<String> getUserQueues() {

        ArrayList<String> queues = new ArrayList<String>();
        Vector destinations = null;
        try {
            destinations = manager.getAllDestinations();
            Iterator i = destinations.iterator();
            while (i.hasNext()) {
                Destination destination = (Destination) i.next();
                if (destination instanceof Queue) {
                    Queue queue = (Queue) destination;
                    queues.add(queue.getQueueName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return queues;
    }

    @Override
    public void removeUserQueue(String queue) {
        try {
            if (!manager.removeDestination(queue)) {
                System.err.println("Cannot remove destination " + queue);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendMessageToQueue(String msg, String queue) {
        try {
            QueueConnection connection = qfactory.createQueueConnection();
            QueueSession session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

            javax.jms.Queue dest = (javax.jms.Queue) context.lookup(queue);
            QueueSender sender = session.createSender(dest);

            TextMessage message = session.createTextMessage();
            message.setText(msg);

            sender.send(message);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String receiveMessageFromQueue(String queue) {
        try {
            QueueConnection connection = qfactory.createQueueConnection();
            QueueSession session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

            connection.start();

            javax.jms.Queue dest = (javax.jms.Queue) context.lookup(queue);
            QueueReceiver receiver = session.createReceiver(dest);

            TextMessage msg = (TextMessage) receiver.receiveNoWait();

            connection.close();
            if (msg != null) {
                return msg.getText();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}

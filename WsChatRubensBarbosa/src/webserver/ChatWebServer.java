package webserver;

import interfaces.ChatWebService;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import jms.ManagerJmsMom;

/**
 * Created by Rubens Santos Barbosa. 
 * Web Services and MOM - WSChat December 2018
 */
@WebService(endpointInterface = "interfaces.ChatWebService")
public class ChatWebServer implements ChatWebService {
    
    private ManagerJmsMom manager = new ManagerJmsMom();

    @Override
    public void addUser(String user) {
        manager.createUserQueue(user);
    }

    @Override
    public ArrayList<String> getUser() {
       return manager.getUserQueues();
    }
    
    @Override
    public void removeUser(String user) {
        manager.removeUserQueue(user);
    }

    @Override
    public void sendMessage(String user, String msg) {
        manager.sendMessageToQueue(msg, user);
    }

    @Override
    public String receiveMessage(String user) {
        return manager.receiveMessageFromQueue(user);
    }
    
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9998/chat", new ChatWebServer());
        System.out.println("Chat server on air...");
    }
    
}

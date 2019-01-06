package interfaces;

import java.util.ArrayList;

/**
 * Created by Rubens Santos Barbosa. 
 * Web Services and MOM - WSChat December 2018
 */
public interface ManagerMOM {
    void createUserQueue(String queue);
    ArrayList getUserQueues();
    void removeUserQueue(String queue);
    void sendMessageToQueue(String msg, String queue);
    String receiveMessageFromQueue(String queue);
}

package interfaces;

import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Rubens Santos Barbosa. 
 * Web Services and MOM - WSChat December 2018
 */
@WebService
public interface ChatWebService {
    @WebMethod void addUser(String user);
    @WebMethod ArrayList<String> getUser();
    @WebMethod void removeUser(String user);
    @WebMethod void sendMessage(String user, String msg);
    @WebMethod String receiveMessage(String user);    
}

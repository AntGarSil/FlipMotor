/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jms;

/**
 *
 * @author root
 */

import java.util.Enumeration;
import javax.jms.*;

public class MessageReceiver {
    private JMSConnectionFactory messageConnection;


public MessageReceiver() {
}

private JMSConnectionFactory getMessageConnection(){
  if (messageConnection == null) {
    messageConnection = new JMSConnectionFactory();
  }
  return messageConnection;
}


public Message receive(){    
  return getMessageConnection().receive(1);
}

public Message browseMessagesById(int id){    
  return getMessageConnection().findByIntProperty("SenderId", id);
}

public Enumeration<Message> getBrowseMessages(){    
  return getMessageConnection().getMessageEnumeration();
}

public void connect() {
  getMessageConnection().getConsumerSync();
}

public void connect(String selector) {
  getMessageConnection().getConsumerSync(selector);
}

public void disconnect()  {
  if (messageConnection != null) {

      messageConnection.disconnect();
      messageConnection = null;

  }
}
}


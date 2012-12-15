/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jms;

/**
 *
 * @author root
 */

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

public void connect() {
  getMessageConnection().getConsumer();
}

public void disconnect()  {
  if (messageConnection != null) {

      messageConnection.disconnect();
      messageConnection = null;

  }
}
}


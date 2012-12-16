/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jms;

import javax.jms.*;
/**
 *
 * @author root
 */
public class MessageSender {
    private JMSConnectionFactory JMSConnectionFactory;


public MessageSender() {
}


private JMSConnectionFactory getJMSConnectionFactory(){
  if (JMSConnectionFactory == null) {
    JMSConnectionFactory = new JMSConnectionFactory();
  }
  return JMSConnectionFactory;
}


private Session getSession(){
  if (getJMSConnectionFactory() != null) {
    return getJMSConnectionFactory().getSession();
  }
  return null;
}


public void send(Message message){
  if (message != null) {
    getJMSConnectionFactory().send(message);
  }
}


public void connect(){
  getJMSConnectionFactory().getProducerSync();
}


public void disconnect(){
  if (JMSConnectionFactory != null) {
    try {
      JMSConnectionFactory.disconnect();
      JMSConnectionFactory = null;
    } catch (Exception e) {
      JMSConnectionFactory = null;
      e.printStackTrace();
    }
  }
}


public TextMessage createTextMessage(){
  TextMessage message = null;

  try {
    message = getSession().createTextMessage();
  } catch (JMSException e) {
    e.printStackTrace();
  }
  return message;
}


public BytesMessage createBytesMessage(){
  BytesMessage message = null;

  try {
    message = getSession().createBytesMessage();
  } catch (JMSException e) {
    e.printStackTrace();
  }
  return message;
}


public ObjectMessage createObjectMessage(){
  ObjectMessage message = null;

  try {
    message = getSession().createObjectMessage();
  } catch (JMSException e) {
    e.printStackTrace();
  }

  return message;
}


public MapMessage createMapMessage(){
  MapMessage message = null;

  try {
    message = getSession().createMapMessage();
  } catch (JMSException e) {
      e.printStackTrace();
  }

  return message;
}


public StreamMessage createStreamMessage(){
  StreamMessage message = null;

  try {
    message = getSession().createStreamMessage();
  } catch (JMSException e) {
    e.printStackTrace();
  }

  return message;
}
}

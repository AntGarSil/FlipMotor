
package jms;

/**
 *
 * @author root
 */

import javax.jms.*;
import javax.naming.*;

public class JMSConnectionFactory {

    private String destinationName = "jms/MotorSales";
    private String factoryName = "jms/MotorSalesCF";
    private Context context;
    private ConnectionFactory connectionFactory;
    private Connection connection;
    private Session session;
    private Destination destination;
    private MessageConsumer messageConsumer;
    private MessageProducer messageProducer;
    private boolean connected = false;
    
    public JMSConnectionFactory(){}
    

public Context getContext() {
  if (context == null) {
    try {
      //-------------------------------------
      // Initialize JNDI.
      //-------------------------------------
      context = new InitialContext();
    } catch (NamingException e) {
      disconnect();
      e.printStackTrace();      
    }
  }
  return context;
}


public MessageConsumer getConsumer(){
  if (messageConsumer == null) {
    try {
    //-------------------------------------
    // Create a message sender.
    //-------------------------------------
      messageConsumer = getSession().createConsumer(getDestination());
      if (!connected) {
        getConnection().start();
        connected = true;
      }
    } catch (JMSException e) {
      disconnect();
      e.printStackTrace();
    }
   }
   return messageConsumer;
}

public MessageProducer getProducer(){
  if (messageProducer == null) {
    try {
      //-------------------------------------
      // Create a message sender.
      //-------------------------------------
      messageProducer = getSession().createProducer(getDestination());
      
      if (!connected) {
        getConnection().start();
        connected = true;
      }
    } catch (JMSException e) {
      disconnect();
      e.printStackTrace();
    }
  }
  return messageProducer;
}


public ConnectionFactory getConnectionFactory(){
  if (connectionFactory == null) {
    try {
      //------------------------------------------
      // Lookup the connection factory using JNDI.
      //------------------------------------------
      connectionFactory = (ConnectionFactory) getContext().lookup(factoryName);
    } catch (NamingException e) {
      disconnect();
      e.printStackTrace();
    }
  }
  return connectionFactory;
}


public Connection getConnection(){
  if (connection == null) {
    try {
      //-------------------------------------
      // Use the connection factory to create
      // a JMS connection.
      //-------------------------------------
      connection = getConnectionFactory().createConnection();
    } catch (JMSException e) {
      disconnect();
      e.printStackTrace();
    }
   }
   return connection;
}



public Session getSession(){
  if (session == null) {
    try {
      //-------------------------------------
      // Use the connection to create a
      // session.
      //-------------------------------------
      session = getConnection().createSession(false, Session.AUTO_ACKNOWLEDGE);
    } catch (JMSException e) {
      disconnect();
      e.printStackTrace();
    }
  }
  return session;
}


public Destination getDestination(){
  if (destination == null) {
    try {
      //-------------------------------------
      // Lookup the destination (queue) using
      // JNDI. Note that the designated
      // destination (destinationName) must be
      // administered within the JMS service
      // environment.
      //-------------------------------------
      destination = (Destination) getContext().lookup(destinationName);
     } catch (NamingException e) {
       disconnect();
       e.printStackTrace();
     }
   }
   return destination;
}


public void connect(){
  // make sure a connection and a session established.
  getSession();
  if (!connected) {
    try {
      getConnection().start();
      connected = true;
    } catch (JMSException e) {
      e.printStackTrace();
      connected = false;
      disconnect();
    }
  }
}


public void disconnect(){
  if (connection != null) {
    try {
      connection.close();
   } catch (JMSException e) {
      e.printStackTrace();
   }
  }

  connection = null;
  session = null;
  messageProducer = null;
  messageConsumer = null;

  connected = false;
}


public boolean isConnected() {
   return connected;
}


public void send(Message message){
  try {
    getProducer().send(message);
  } catch (JMSException e) {
    e.printStackTrace();
  }
}


public Message receive(int n){
  Message message = null;

  try {
    message = getConsumer().receive(n);
  } catch (JMSException e) {
    e.printStackTrace();
  }
  return message;
}  
    
}

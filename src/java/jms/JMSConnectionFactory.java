
package jms;

/**
 *
 * @author root
 */

import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.*;
import javax.naming.*;

public class JMSConnectionFactory implements MessageListener{

    private String destinationName = "jms/MotorSales";
    private String factoryName = "jms/MotorSalesCF";
    private Context context;
    private QueueConnectionFactory connectionFactory;
    private QueueConnection connection;
    private QueueSession session;
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

public MessageConsumer getConsumerSync(){
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

public MessageConsumer getConsumerSync(String selector){
  if (messageConsumer == null) {
    try {
    //-------------------------------------
    // Create a message sender.
    //-------------------------------------
      
      getSession();
      Queue queue = (Queue) context.lookup(destinationName);
      messageConsumer = session.createReceiver(queue,selector);      
      
      if (!connected) {
        getConnection().start();
        connected = true;
      }
    }       catch (NamingException ex) {
                Logger.getLogger(JMSConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JMSException e) {
      disconnect();
      e.printStackTrace();
    }
   }
   return messageConsumer;
}

public MessageProducer getProducerSync(){
  if (messageProducer == null) {
    try {
      //-------------------------------------
      // Create a message producer.
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

public MessageConsumer getConsumerAsync(){
  if (messageConsumer == null) {
    try {
    //-------------------------------------
    // Create a message sender.
    //-------------------------------------
      messageConsumer = getSession().createConsumer(getDestination());
      messageConsumer.setMessageListener(this);
      
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

public MessageProducer getProducerAsync(){
  if (messageProducer == null) {
    try {
      //-------------------------------------
      // Create a message producer.
      //-------------------------------------
      messageProducer = getSession().createProducer(getDestination());
      messageConsumer.setMessageListener(this);
      
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


public QueueConnectionFactory getConnectionFactory(){
  if (connectionFactory == null) {
    try {
      //------------------------------------------
      // Lookup the connection factory using JNDI.
      //------------------------------------------
      connectionFactory = (QueueConnectionFactory) getContext().lookup(factoryName);
    } catch (NamingException e) {
      disconnect();
      e.printStackTrace();
    }
  }
  return connectionFactory;
}


public QueueConnection getConnection(){
  if (connection == null) {
    try {
      //-------------------------------------
      // Use the connection factory to create
      // a JMS connection.
      //-------------------------------------
      connection = getConnectionFactory().createQueueConnection();
    } catch (JMSException e) {
      disconnect();
      e.printStackTrace();
    }
   }
   return connection;
}



public QueueSession getSession(){
  if (session == null) {
    try {
      //-------------------------------------
      // Use the connection to create a
      // session.
      //-------------------------------------
      session = getConnection().createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
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
      session.close();
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
    getProducerSync().send(message);
  } catch (JMSException e) {
    e.printStackTrace();
  }
}


public Message receive(int n){
  Message message = null;

  try {
    message = getConsumerSync().receive(n);
  } catch (JMSException e) {
    e.printStackTrace();
  }
  return message;
}

public Message findByIntProperty(String property, int value){
        Message message = null;    
        try {            
            Queue queue = (Queue) context.lookup(destinationName);
            QueueBrowser qb = session.createBrowser(queue);
            Enumeration elements = qb.getEnumeration();
            while(elements.hasMoreElements())
            {
                Message msg = (Message) elements.nextElement();
                if(msg.getIntProperty(property) == value)
                {
                    message = msg;
                    break;
                }
            }
            
        } catch (JMSException ex) {
            Logger.getLogger(JMSConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(JMSConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
}

public Enumeration<Message> getMessageEnumeration(){
        Enumeration<Message> message = null;    
        try {            
            Queue queue = (Queue) context.lookup(destinationName);
            
            QueueBrowser qb = session.createBrowser(queue);
            message = qb.getEnumeration();            
            
        } catch (JMSException ex) {
            Logger.getLogger(JMSConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(JMSConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
}

    @Override
    public void onMessage(Message message) {
        throw new UnsupportedOperationException("Not supported yet.");
        
    }
    
}

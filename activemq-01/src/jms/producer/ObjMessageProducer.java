package jms.producer;

import java.io.Serializable;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ObjMessageProducer {

	public void recieveMessageFromMq(Serializable obj,String name) {
		ConnectionFactory factory =null;
		Connection connection =null;
		Session session = null;
		Destination dest = null;
		MessageProducer producer = null;
		Message message = null;
		try {
			factory = new ActiveMQConnectionFactory("admin", "admin", "tcp://192.168.186.6:61616");
			connection = factory.createConnection();
			connection.start();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			dest = session.createQueue(name);
			producer = session.createProducer(dest);
			message = session.createObjectMessage(obj);
			producer.send(message);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭资源
			if(null!=producer){
				try {
					producer.close();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(null!=session){
				try {
					session.close();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(null!=connection){
				try {
					connection.close();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	
}

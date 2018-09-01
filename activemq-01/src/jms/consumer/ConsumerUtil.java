package jms.consumer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ConsumerUtil {

	public Message recieveMessageFromMq(String name) {
		ConnectionFactory factory =null;
		Connection connection =null;
		Session session = null;
		Destination dest = null;
		MessageConsumer consumer = null;
		Message message = null;
		try {
			factory = new ActiveMQConnectionFactory("admin", "admin", "tcp://192.168.186.6:61616");
			connection = factory.createConnection();
			connection.start();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			dest = session.createQueue(name);
			consumer = session.createConsumer(dest);
			message = consumer.receive();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭资源
			if(null!=consumer){
				try {
					consumer.close();
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

		return message;
	}

}

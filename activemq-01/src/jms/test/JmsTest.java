package jms.test;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;

import org.junit.Test;

import jms.consumer.ConsumerUtil;
import jms.pojo.Item;
import jms.pojo.SearchItem;
import jms.producer.ObjMessageProducer;

public class JmsTest {
	
	
	@Test
	public void objProducer() {
		ObjMessageProducer producer = new ObjMessageProducer();
		Item item = new Item();
		item.setId(2L);
		item.setPrice(168L);
		item.setTitle("小米手环3");
		producer.recieveMessageFromMq(item, "obj-mq");
		System.out.println("发送消息");
	}

	@Test
	public void objConsumer() {
		ConsumerUtil c = new ConsumerUtil();
		Message message = c.recieveMessageFromMq("obj-mq");
		ObjectMessage obj = (ObjectMessage) message;
		Item item = null;
		try {
			item = (Item) obj.getObject();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("商品的id:"+item.getId()+",商品的名称:"+item.getTitle()+",商品的价格:"+item.getPrice());
		
	}

	public static void main(String[] args) {
		

		ConsumerUtil c = new ConsumerUtil();
		Message message = c.recieveMessageFromMq("ego-item");
		ObjectMessage obj = (ObjectMessage) message;
		SearchItem item = null;
		try {
			item = (SearchItem) obj.getObject();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("商品的id:"+item.getId()+",商品的名称:"+item.getTitle()+",商品的价格:"+item.getPrice());
		
	}
}

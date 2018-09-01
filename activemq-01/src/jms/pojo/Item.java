package jms.pojo;

import java.io.Serializable;

/**
 * 自定义item类型
 * 
 *     activemq发送对象类型消息的时候，对象必须实现序列化
 *     
 *        哪些场景需要对象实现序列化？
 *           1、网络传输
 *           2、缓存
 *    
 * @author lyq
 *
 */
public class Item implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 679172879329550237L;

	private Long id;
	
	private String title;
	
	private Long price;

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}
	
}

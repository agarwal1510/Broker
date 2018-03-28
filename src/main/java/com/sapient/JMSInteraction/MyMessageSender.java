package com.sapient.JMSInteraction;

import javax.jms.*;


import org.apache.log4j.BasicConfigurator;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component("messageSender")
public class MyMessageSender {
	/*@Autowired
	private JmsTemplate jmsTemplate;*/
	public void sendMessage(final String message) {
		BasicConfigurator.configure();
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:beans.xml");
		ctx.refresh();
		JmsTemplate jmsTemplate=ctx.getBean("jmsTemplate", JmsTemplate.class);
		jmsTemplate.send(new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				System.out.println(message);
				return session.createTextMessage(message);
			}
		});
	}

	public MyMessageSender() {	
	}
	
}

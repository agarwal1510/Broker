package com.sapient.JMSInteraction;

import org.apache.log4j.BasicConfigurator;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class JmsMessageListener{
	public void queueListener(){
		BasicConfigurator.configure();
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:beans.xml");
		ctx.refresh();
		while (true) {
		} 
	}
	/*public void run(){
		System.out.println("Listener thread started....");
		queueListener();
	}*/
}

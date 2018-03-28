package com.sapient.JMSInteraction;

import java.io.File;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.log4j.BasicConfigurator;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sapient.entity.Fill;


@Component
public class JmsMessageSender {

	/*@Autowired
	private MyMessageSender myMessageSender;*/
	/*@Autowired
	private JmsTemplate jmsTemplate;*/
	
	public void queueSender(Fill fill){
		BasicConfigurator.configure();
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:beans.xml");
		ctx.refresh();
		
		MyMessageSender sender = ctx.getBean("messageSender",
				MyMessageSender.class);
		final String xmlString = createXMLFromBlocks(fill);
		sender.sendMessage(xmlString);
		/*JmsTemplate jmsTemplate=ctx.getBean("jmsTemplate", JmsTemplate.class);
		jmsTemplate.send(new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(xmlString);
			}
		});
		System.out.println(xmlString);*/
	}
	
	private static String createXMLFromBlocks(Fill fill) {
		String xmlString = null;
		try {
			File file = new File("Fill.xml");
			System.out.println(file.getAbsolutePath());
			//File file = new File("\\res\\Fill.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Fill.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(fill, file);
			//jaxbMarshaller.marshal(fillMessage, System.out);

			StringWriter sw = new StringWriter();
			jaxbMarshaller.marshal(fill, sw);
			xmlString = sw.toString();
			//System.out.println("=====SW=====");
			//System.out.println(xmlString);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return xmlString;
	}

	public JmsMessageSender() {
	
	}
	
	
}

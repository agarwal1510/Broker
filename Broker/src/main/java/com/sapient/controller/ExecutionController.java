package com.sapient.controller;
 
import org.apache.log4j.BasicConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jms.listener.AbstractJmsListeningContainer;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sapient.JMSInteraction.JmsMessageListener;
import com.sapient.manager.BlockManager;

@Controller
@SessionAttributes("UserName")
public class ExecutionController {
	
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Autowired
	private BlockManager blockManager;
	@RequestMapping("Exchange")
	public String getExchange(Model model) {
		if(!model.containsAttribute("UserName"))
			model.addAttribute("notLoggedIn", "Please Login to start/stop Exchange");
		return "Exchange";
	}
	
	@RequestMapping(value = "startExecutionSystem", method = RequestMethod.GET)
	public String startExecutionSystem(Model model){
		JmsMessageListener listener= new JmsMessageListener();
		model.addAttribute("successMsg", "Exchange Started");
		listener.queueListener();
		//listener.start();	
		return getExchange(model);
		
	}
	
	@RequestMapping(value = "stopExecutionSystem", method = RequestMethod.GET)
	public String stopExecutionSystem(Model model){
		BasicConfigurator.configure();
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:beans.xml");
		ctx.refresh();
		try {
			AbstractJmsListeningContainer abstractJmsListeningContainer= (DefaultMessageListenerContainer)ctx.getBean("listenerContainer");
			blockManager.updateBlockStatusOnExchangeStop();
			abstractJmsListeningContainer.stop();
		}catch(ClassCastException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		model.addAttribute("successMsg", "Exchange Stopped");
		return getExchange(model);
		
	}

}

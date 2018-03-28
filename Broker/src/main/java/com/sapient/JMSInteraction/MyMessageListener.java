package com.sapient.JMSInteraction;

import java.io.StringReader;
import java.math.BigInteger;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import com.sapient.entity.Block;
import com.sapient.entity.BlockListContainer;
import com.sapient.manager.BlockManager;
import com.sapient.manager.ExecuteBlockList;

public class MyMessageListener implements MessageListener {
	@Autowired
	private BlockManager blockManager;
	@Autowired 
	private ExecuteBlockList exeBlockList;

	@Override
	public void onMessage(Message msg) {
		TextMessage message = (TextMessage) msg;
		try {
			System.out.println("inside on message");
			String s = message.getText();
			JAXBContext jaxbcontext = JAXBContext
					.newInstance(BlockListContainer.class);
			Unmarshaller um = jaxbcontext.createUnmarshaller();
			StringReader reader = new StringReader(s);
			//System.out.println("StringReaderwA"+reader);
			BlockListContainer blockListContainer = (BlockListContainer) um
					.unmarshal(reader);
			setBlockListToDB(blockListContainer);
			message.acknowledge();
			//starting of threads for execution of Block list
			exeBlockList.startBlockExecution(blockListContainer.getBlockList());
		} catch (Exception e) {
			System.out.println("Could not be persisted" + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Message could not be persisted so don't acknowledge");
		}
	}

	private void setBlockListToDB(BlockListContainer blockListContainer)
			throws Exception {
		for (Block itr : blockListContainer.getBlockList())
			setNewBlockToDB(itr);		
	}

	private void setNewBlockToDB(Block block) throws Exception {
		block.setStatus("new");
		block.setOpenQuantity(block.getTotalQuantity());
		block.setExecutedQuantity(new BigInteger(Integer.toString(0)));
		//System.out.println(block);
		blockManager.setBlock(block);
		
		//System.out.println("anand"+blockManager.getBlock(block.getBlockId()));
	}
}

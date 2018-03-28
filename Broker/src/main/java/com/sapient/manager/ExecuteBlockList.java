package com.sapient.manager;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sapient.entity.Block;
@Component
public class ExecuteBlockList {
	/*private static ExecutorService executorService = Executors
			.newFixedThreadPool(10);*/
	
	@Autowired
	private ExecuteBlockRunnable  executeBlockRunnable;
	public void startBlockExecution(List<Block> blockList){
		System.out.println("block execution started.....");
		if(blockList.isEmpty() || blockList==null) return;
		for(Block block:blockList){
			System.out.println("thread....");
			executeBlockRunnable.setBlock(block);
			executeBlockRunnable.run();
		}
		
	}
}

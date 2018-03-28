package com.sapient.manager;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.dao.BlockDao;
import com.sapient.entity.Block;
@Service
public class BlockManager {
	@Autowired
	private BlockDao blockDao;
	
	
	
	public BlockDao getBlockDao() {
		return blockDao;
	}
	public void setBlockDao(BlockDao blockDao) {
		this.blockDao = blockDao;
	}
	public void setBlock(Block block) throws Exception{
		blockDao.setBlock(block);
	}
	public Block getBlock(BigInteger blockId) {
		return blockDao.getBlock(blockId);
	}
	public void updateBlock(BigInteger blockId, BigInteger randomFillExecution) throws RuntimeException {
		blockDao.updateBlock(blockId,randomFillExecution);
	}
	public void updateBlockStatusOnExchangeStop(){
		blockDao.updateBlockStatusOnExchangeStop();
		return;
	}
}

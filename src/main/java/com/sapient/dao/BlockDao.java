package com.sapient.dao;

import java.math.BigInteger;

import org.springframework.transaction.annotation.Transactional;

import com.sapient.entity.Block;


public interface BlockDao {
	
	
	public Block getBlock(BigInteger blockId);
	@Transactional(rollbackFor=Exception.class)
	public void setBlock(Block block) throws Exception;
	
	@Transactional(rollbackFor=RuntimeException.class)
	public void updateBlock(BigInteger blockId, BigInteger randomFillExecution) throws RuntimeException;
	
	@Transactional
	public void updateBlockStatusOnExchangeStop();
	
}

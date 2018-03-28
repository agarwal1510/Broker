package com.sapient.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sapient.entity.Fill;



public interface FillDao {
	
	
	@Transactional
	public void setFill(Fill fill);
	
	public Fill getFill(BigInteger fillID);
	public List<Fill> getFillList();
	public List<Fill> getFillList(int offset,int limit);
}

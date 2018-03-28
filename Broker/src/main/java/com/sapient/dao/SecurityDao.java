package com.sapient.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.entity.SecurityEntity;

@Repository
public interface SecurityDao {
	
	
	
	public SecurityEntity getSecurity(String symbol);
	
	public List<SecurityEntity> getSecurityList();
	
	@Transactional(rollbackFor=RuntimeException.class)
	public void setSecurity(SecurityEntity security) throws RuntimeException,Exception;
	
	@Transactional(rollbackFor=RuntimeException.class)
	public void updateLastTradedPrice(String secSymbol,double lastTradedPrice) throws RuntimeException;
	
}

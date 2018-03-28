package com.sapient.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.dao.SecurityDao;
import com.sapient.entity.SecurityEntity;

@Service
public class SecurityManager {
	
	@Autowired
	private SecurityDao securityDao;
	
	
	
	public SecurityDao getSecurityDao() {
		return securityDao;
	}
	public void setSecurityDao(SecurityDao securityDao) {
		this.securityDao = securityDao;
	}
	public SecurityEntity getSecurity(String symbol){
		//System.out.println("manager");
		return securityDao.getSecurity(symbol);
	}
	public void setSecurity(SecurityEntity security) throws RuntimeException, Exception{
		securityDao.setSecurity(security);
	}
	
	public List<SecurityEntity> getSecurityList(){
		return securityDao.getSecurityList();
	}
	
	public void updateLastTradedPrice(String secSymbol,double lastTradedPrice) throws RuntimeException {
		securityDao.updateLastTradedPrice(secSymbol, lastTradedPrice);
	}
}

package com.sapient.manager;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.sapient.dao.SecurityDao;
import com.sapient.entity.SecurityEntity;
import static org.junit.Assert.*;


public class TestSecurityManager {

	private static SecurityDao mockedSecurityDao = Mockito.mock(SecurityDao.class);
	private static 	SecurityManager securityManager = new SecurityManager();

	
	@Before
	public void setup(){
	
	securityManager.setSecurityDao(mockedSecurityDao);
	}
	
	@Test
	public void shouldTestGettingOfSecurities(){
		SecurityEntity security = new SecurityEntity("tcs", "tata", 908.0, 5.6, 9, 7, 43.8);
		Mockito.when(mockedSecurityDao.getSecurity("tcs")).thenReturn(security);
		assertEquals(security, securityManager.getSecurity("tcs"));
		Mockito.verify(mockedSecurityDao).getSecurity("tcs");
		
		
	}
	@Test
	public void shouldTestGettingListOfSecurities(){
		SecurityEntity security = new SecurityEntity("tcs", "tata", 908.0, 5.6, 9, 7, 43.8);
		SecurityEntity security1 = new SecurityEntity("bhel", "bhel", 898.0, 6.6, 11, 9, 23.8);
		SecurityEntity security2 = new SecurityEntity("ongc", "ongc", 778.0, 7.6, 10, 5, 13.8);
		List<SecurityEntity> securityList = new ArrayList<>();
		securityList.add(security);
		securityList.add(security1);
		securityList.add(security2);
		Mockito.when(mockedSecurityDao.getSecurityList()).thenReturn(securityList);
		assertEquals(securityList, securityManager.getSecurityList());
		Mockito.verify(mockedSecurityDao).getSecurityList();
		
		
	}

}

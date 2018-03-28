package com.sapient.manager;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.sapient.dao.FillDao;
import com.sapient.entity.Fill;

public class TestFillManager {
	private static FillDao mockedFillDao = Mockito.mock(FillDao.class);
	FillManager fillManager = new FillManager();
	@Before
	public void setup(){
		
		fillManager.setFillDao(mockedFillDao);
	}
	
	@Test
	public void shouldTestGettingOfFill(){
		Fill fill = new Fill(BigInteger.valueOf(2), BigInteger.valueOf(3), 67.9, new Date()) ;
		Mockito.when(mockedFillDao.getFill(BigInteger.valueOf(2))).thenReturn(fill);
		assertEquals(fill, fillManager.getFill(BigInteger.valueOf(2)));
Mockito.verify(mockedFillDao).getFill(BigInteger.valueOf(2));

	}
	@Test
	public void shouldTestGettingOfFillList(){
		Fill fill = new Fill(BigInteger.valueOf(2), BigInteger.valueOf(3), 67.9, new Date()) ;
		Fill fill1 = new Fill(BigInteger.valueOf(4), BigInteger.valueOf(7), 89.2, new Date());
		Fill fill2 =  new Fill(BigInteger.valueOf(7), BigInteger.valueOf(9), 49.2, new Date());
		java.util.List<Fill> fillList= new ArrayList<>();
		fillList.add(fill);
		fillList.add(fill1);
		fillList.add(fill2);
		Mockito.when(mockedFillDao.getFillList()).thenReturn(fillList);
		assertEquals(fillList, fillManager.viewListOfFills());
		Mockito.verify(mockedFillDao).getFillList();
		
		
		
		
	}
	

}

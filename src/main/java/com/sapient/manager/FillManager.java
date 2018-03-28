package com.sapient.manager;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.dao.FillDao;
import com.sapient.entity.Fill;

@Service
public class FillManager {
	
	@Autowired 
	private FillDao fillDao;
	
	
	public FillDao getFillDao() {
		return fillDao;
	}

	public void setFillDao(FillDao fillDao) {
		this.fillDao = fillDao;
	}

	public void setFill(Fill fill){
		fillDao.setFill(fill);
	}
	
	public Fill getFill(BigInteger fillID){
		return fillDao.getFill(fillID);
	}
	public List<Fill> viewListOfFills(){
		return fillDao.getFillList();	
	}
	
	public List<Fill> viewListOfFills(int offset,int limit){
		return fillDao.getFillList(offset,limit);	
	}
	
}

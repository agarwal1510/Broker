package com.sapient.jpaImplementation;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.dao.FillDao;
import com.sapient.entity.Fill;
@Repository
public class FillDaoJPAImplementation implements FillDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	public void setEntityManager(EntityManager entityManager){
		this.entityManager=entityManager;
	}
	
	@Transactional
	public void setFill(Fill fill){
		entityManager.persist(fill);
	}
	
	public Fill getFill(BigInteger fillID){
		return entityManager.find(Fill.class, fillID);
	}
	public List<Fill> getFillList(){
		List<Fill> fillList=new ArrayList<>();
		TypedQuery<Fill> query=entityManager.createNamedQuery("Fill.findAll", Fill.class);
		fillList = query.getResultList();
		return fillList;	
	}

	@Override
	public List<Fill> getFillList(int offset, int limit) {
		List<Fill> fillList=new ArrayList<>();
		TypedQuery<Fill> query=entityManager.createNamedQuery("Fill.findAll", Fill.class);
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		fillList = query.getResultList();
		return fillList;	
	}
}

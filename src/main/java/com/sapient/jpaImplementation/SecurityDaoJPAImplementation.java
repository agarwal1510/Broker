package com.sapient.jpaImplementation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.dao.SecurityDao;
import com.sapient.entity.SecurityEntity;

@Repository
public class SecurityDaoJPAImplementation implements SecurityDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	public void setEntityManager(EntityManager entityManager){
		this.entityManager=entityManager;
	}
	
	public SecurityEntity getSecurity(String symbol){
		//System.out.println("dao");
		return entityManager.find(SecurityEntity.class,symbol);
	}
	
	public List<SecurityEntity> getSecurityList(){
		List<SecurityEntity> securityList=new ArrayList<>();
		TypedQuery<SecurityEntity> query=entityManager.createNamedQuery("SecurityEntity.findAll", SecurityEntity.class);
		securityList=query.getResultList();
		return securityList;	
	}
	
	@Transactional(rollbackFor=RuntimeException.class)
	public void setSecurity(SecurityEntity security) throws RuntimeException,Exception{
		entityManager.persist(security);
	}
	
	@Transactional(rollbackFor=RuntimeException.class)
	public void updateLastTradedPrice(String secSymbol,double lastTradedPrice) throws RuntimeException{
		SecurityEntity security=entityManager.find(SecurityEntity.class, secSymbol);
		security.setLastTradedPrice(lastTradedPrice);
		System.out.println(security);
	}
	
}

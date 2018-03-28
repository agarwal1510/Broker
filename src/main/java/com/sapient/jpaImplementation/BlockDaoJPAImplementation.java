package com.sapient.jpaImplementation;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.dao.BlockDao;
import com.sapient.entity.Block;

@Repository
public class BlockDaoJPAImplementation implements BlockDao {
	@PersistenceContext
	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Block getBlock(BigInteger blockId) {
		return entityManager.find(Block.class, blockId);
	}

	@Transactional(rollbackFor = Exception.class)
	public void setBlock(Block block) throws Exception {
		entityManager.persist(block);
	}

	@Transactional(rollbackFor = RuntimeException.class)
	public void updateBlock(BigInteger blockId, BigInteger randomFillExecution)
			throws RuntimeException {
		Block block = entityManager.find(Block.class, blockId);
		block.setExecutedQuantity(block.getExecutedQuantity().add(
				randomFillExecution));
		block.setOpenQuantity(block.getOpenQuantity().subtract(
				randomFillExecution));
		// entityManager.getTransaction().commit();
		return;
	}

	@Transactional
	public void updateBlockStatusOnExchangeStop() {
		List<Block> blockList = new ArrayList<>();
		TypedQuery<Block> query = entityManager.createNamedQuery(
				"Block.selectNotExecuted", Block.class);
		blockList = query.setParameter("executedQuantity",
				BigInteger.valueOf(0)).getResultList();
		for (Block block : blockList)
			block.setStatus("expired");
		return;
	}

}

package com.sapient.manager;

import java.math.BigInteger;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sapient.JMSInteraction.JmsMessageSender;
import com.sapient.entity.Block;
import com.sapient.entity.Fill;
import com.sapient.entity.SecurityEntity;

@Component
public class ExecuteBlockRunnable {

	public ExecuteBlockRunnable() {

	}

	private Block block;
	@Autowired
	private FillManager fillManager;
	@Autowired
	private SecurityManager securityManager;
	@Autowired
	private BlockManager blockManager;
	@Autowired
	private JmsMessageSender messageSender;

	public ExecuteBlockRunnable(Block block) {
		this.block = block;
		this.block.setExecutedQuantity(BigInteger.valueOf(0));
		this.block.setOpenQuantity(block.getTotalQuantity());

	}

	public void run() {
		System.out.println("inside run....");
		exchangeBlockExecutionAlgo();
	}

	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

	private void exchangeBlockExecutionAlgo() {

		SecurityEntity security = getSecurity(block.getSymbol());
		double secTradePrice = security.getLastTradedPrice().doubleValue();
		BigInteger quantity = block.getTotalQuantity();
		int randomFillExecution;
		double randomFillPrice = genRandomNumber(Integer.valueOf(1),
				security.getMaxExecution());
		System.out.println("randomFillPrice" + randomFillPrice);
		while (quantity.signum() == 1) {
			if ((BigInteger.valueOf(security.getMaxExecution()).compareTo(
					quantity) < 0)) {
				randomFillExecution = genRandomNumber(Integer.valueOf(1),
						security.getMaxExecution());
			} else {
				randomFillExecution = genRandomNumber(Integer.valueOf(1),
						Integer.valueOf(quantity.intValue()));
			}
			double randomPriceSpread = genRandomNumber(0, security
					.getPriceSpread().intValue());

			secTradePrice = security.getLastTradedPrice().doubleValue();
			switch (block.getType().toLowerCase()) {
			case "marketprice":

				randomFillPrice = genRandomNumber(secTradePrice
						- randomPriceSpread, secTradePrice + randomPriceSpread);
				break;
			case "limitprice":
				if (block.getSide().equalsIgnoreCase("buy")) {
					randomFillPrice = genRandomNumber(secTradePrice
							- randomPriceSpread, secTradePrice);
				} else {
					randomFillPrice = genRandomNumber(secTradePrice,
							secTradePrice + randomPriceSpread);
				}
				break;
			case "stopprice":
				if (block.getSide().equalsIgnoreCase("buy")) {
					randomFillPrice = genRandomNumber(secTradePrice,
							secTradePrice + randomPriceSpread);
				} else {
					randomFillPrice = genRandomNumber(secTradePrice
							- randomPriceSpread, secTradePrice);
				}
				break;
			case "limitstop":
				randomFillPrice = genRandomNumber(secTradePrice
						- randomPriceSpread, secTradePrice + randomPriceSpread);
				break;
			}

			Fill fill = new Fill(block.getBlockId(),
					BigInteger.valueOf(randomFillExecution), randomFillPrice,
					new Date());
			generateFill(fill); // storing the fills to DB
			messageSender.queueSender(fill); // sending the fills to QUEUE.
			updateSecurityLastTradedPrice(security.getSymbol(), randomFillPrice);
			updateBlock(block.getBlockId(), randomFillExecution);
			block.setOpenQuantity(quantity = quantity.subtract(BigInteger
					.valueOf(randomFillExecution)));
			// call send fill method
			int randomNumber = genRandomNumber(Integer.valueOf(0),
					Integer.valueOf(100));
			if (randomNumber < (100 - security.getProbablePercentable())) {
				System.out.println("randomNumber " + randomNumber);
				break;
			}
		}
	}

	private void updateBlock(BigInteger blockId, int randomFillExecution) {
		blockManager.updateBlock(blockId,
				BigInteger.valueOf(randomFillExecution));

	}

	private void updateSecurityLastTradedPrice(String secSymbol,
			double lastTradedPrice) {
		System.out.println("inside updateSecurityLastTradedPrice");
		securityManager.updateLastTradedPrice(secSymbol, lastTradedPrice);
	}

	private void generateFill(Fill fill) {
		fillManager.setFill(fill);
	}

	private Integer genRandomNumber(Integer lowLimit, Integer highLimit) {
		Random rand = new Random();
		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt((highLimit - lowLimit) + 1) + lowLimit;

		return randomNum;
	}

	private Double genRandomNumber(double lowLimit, double highLimit) {
		Random r = new Random();
		double randomValue = lowLimit + (highLimit - lowLimit) * r.nextDouble();
		return randomValue;
	}

	public SecurityEntity getSecurity(String symbol) {

		SecurityEntity sec = securityManager.getSecurity(symbol);

		return sec;
	}
}

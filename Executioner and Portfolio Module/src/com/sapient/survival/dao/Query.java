package com.sapient.survival.dao;

public interface Query {

	String fetchTrader = "select name,user_id from user where role='trader'";
	String addOrder = "insert into orders(symbol,portfolio_id,side,total_quantity,allocated_quantity,order_type,limit_price,stop_price,trader_id,status) values(?,?,?,?,?,?,?,?,?,?)";
	String quantityValidator = "select volume from securities where symbol=? ";
	String symbolValidator = "select symbol from securities ";
	String viewAllOrder = "select * from orders where status NOT LIKE 'deleted'";
	String viewOrderByside = "select * from orders where side = ? AND status NOT LIKE 'deleted'";
	String viewOrderBySymbol = "select * from orders where symbol = ? AND status NOT LIKE 'deleted'";
	String viewOrderBySymbolSide = "select * from orders where symbol = ? AND side = ? AND status NOT LIKE 'deleted'";
	String deleteOrder = "update orders set status=? where Order_id = ? ";
	String getBlock = "Select * From blocks Where Block_id=?";
	String getMarketPrice = "Select market_price From securities Where symbol=?";
	String addFill = "Insert Into fills(block_id,executed_quantity,price) Values(?,?,?)";
	String changeStatus1 = "Update blocks set status='partial executed' allocated_quantity=500 where Block_id=50001";
	String changeStatus2 = "Update blocks set status='fully executed' allocated_quantity=200 where Block_id=50002";
	String changeOrderStatus = "Update orders set allocated_quantity=? , status=? where Order_id=?";
	String fetchTraderName = "select name from user where role='trader'";
	String fetchPortfolioForTrader = "select * from portfolio where user_id=?";
	String fetchPositionForPortfolio = "select * from positions where portfolio_id=?";
	String fetchPositionForPositionId = "select * from positions where position_id=?";
	String fetchPositionForPortfolioIdnSymbol = "select * from positions where portfolio_id=? and symbol=?";
	String updatePositionQuantity = "update positions set quantity=? where position_id=?";
	String deleteEmptyPosition = "delete from positions where position_id=? and quantity=0";
	String updatePositionQuantityBysymbolandPortfolio = "update positions set quantity=? where portfolio_id=? and symbol=?";
	String fetchSecurity="select symbol from securities";
	String fetchTraderNamae="Select name from user where user_id = ?";
	String fetchTraderDetails="select distinct(u.name),u.user_id from user u, orders o where u.user_id=o.trader_id and u.role='trader'";
	String fetchTraderAndBoth = "select name,user_id from user where role='trader' or role='both'";
	
}

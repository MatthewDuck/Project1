package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Order> {
	
	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public List<Order> readAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Order readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public Order readLatestItem() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM order_items ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Order read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order create(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("INSERT INTO orders(customer_id) VALUES (?)");){
			statement.setLong(1, order.getCustomerId());
			statement.executeUpdate();
			return readLatest();
		}catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	@Override
	public Order update(Order t) {
		// TODO Auto-generated method stub
		return null;
	}

	public Order addItem(Order order, Item item) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO order_items (item_id, order_id) VALUES (?, ?)");) {
			statement.setLong(1,  item.getId());
			statement.setLong(2, order.getId());
			statement.executeUpdate();
			return readLatestItem();
		}catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public int removeItem(Order order, Item item) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("DELETE FROM order_items  WHERE item_id = ? AND order_id = ?)");) {
			statement.setLong(1,  item.getId());
			statement.setLong(2, order.getId());
			return statement.executeUpdate();
		}catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
		
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	

}

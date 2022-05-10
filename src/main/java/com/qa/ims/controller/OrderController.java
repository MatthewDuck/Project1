package com.qa.ims.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, Utils utils) {
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	@Override
	public Order create() {
		LOGGER.info("Please enter a customer id");
		Long customerId = utils.getLong();
		Order order = orderDAO.create(new Order(customerId));
		LOGGER.info("Order created");
		return order;
	}

	@Override
	public Order update() {
		ItemDAO itemDAO = new ItemDAO();
		LOGGER.info("Please enter an Order ID to edit");
		Long orderId = utils.getLong();
		LOGGER.info("Please enter an Item ID");
		Long itemId = utils.getLong();
		List<Item> items = new ArrayList<>();
		LOGGER.info("Would you like to a)add or b)remove an item from an order");
		String choice = utils.getString();
		switch (choice) {
		case "a":
			items.add(itemDAO.read(itemId));
			LOGGER.info("Order Updated");
			break;
		case "b":
			items.remove(itemDAO.read(itemId));
			LOGGER.info("Order Updated");
			break;
		}
		Order order = orderDAO.update(new Order(orderId, items));
		return order;
	}

	public void addItem() {
		ItemDAO itemDAO = new ItemDAO();
		LOGGER.info("Please enter an Order ID to edit");
		Long orderId = utils.getLong();
		LOGGER.info("Please enter an Item ID");
		Long itemId = utils.getLong();
		orderDAO.addItem(orderDAO.read(orderId), itemDAO.read(itemId));
	}

	public void deleteItem() {
		ItemDAO itemDAO = new ItemDAO();
		LOGGER.info("Please enter an Order ID to edit");
		Long orderId = utils.getLong();
		LOGGER.info("Please enter an Item ID");
		Long itemId = utils.getLong();
		orderDAO.removeItem(orderDAO.read(orderId), itemDAO.read(itemId));
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = utils.getLong();
		return orderDAO.delete(id);
	}
	
	public Double costOrder() {
		LOGGER.info("Please enter the id of the order you would like to calculate the total cost of");
		Long id = utils.getLong();
		return orderDAO.costOrder(id);
	}

}

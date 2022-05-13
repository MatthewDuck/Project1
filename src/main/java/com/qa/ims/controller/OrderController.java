package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
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
		LOGGER.info(order);
		return order;
	}

	@Override
	public Order update() {

		LOGGER.info("Please enter an Order ID to edit");
		Long orderId = utils.getLong();
		LOGGER.info("How would you like to update the order");
		LOGGER.info("Add Item");
		LOGGER.info("Delete Item");
		LOGGER.info("Check Cost");
		LOGGER.info("Change Customer ID");
		String choice = utils.getString();
		switch (choice) {
		case "Change Customer ID":
			LOGGER.info("Please enter a new Customer ID");
			Long customerId = utils.getLong();
			Order order = orderDAO.update(new Order(orderId, customerId));
			return order;
		case "Add Item":
			LOGGER.info("Please enter an Item ID");
			Long addId = utils.getLong();
			Order add = orderDAO.addItem(orderId, addId);
			return add;
		case "Delete Item":
			LOGGER.info("Please enter an Item ID");
			Long removeId = utils.getLong();
			deleteItem(orderId, removeId);
			break;
		case "Check Cost":
			costOrder(orderId);
			break;
		default:
			LOGGER.info("Incorrect Input");
			choice = utils.getString();
		}
		return null;

	}


	public int deleteItem(Long orderId, Long removeId) {
		return orderDAO.removeItem(orderId, removeId);
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = utils.getLong();
		return orderDAO.delete(id);
	}

	public Double costOrder(Long orderId) {
		return orderDAO.costOrder(orderId);
	}

}

package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private OrderDAO dao;
	
	@Mock
	private ItemDAO itemdao;

	@InjectMocks
	private OrderController controller;

	@Test
	public void testCreate() {
		final Long customerId = 1L;
		final Order created = new Order(customerId);

		Mockito.when(utils.getLong()).thenReturn(customerId);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}

	@Test
	public void testReadAll() {
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(1L, 2L));

		Mockito.when(dao.readAll()).thenReturn(orders);

		assertEquals(orders, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {
		Order updated = new Order(1L, 1L);
		Mockito.when(this.utils.getLong()).thenReturn(updated.getId(), updated.getCustomerId());
		Mockito.when(this.utils.getString()).thenReturn("Change Customer ID");
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, controller.update());

		Mockito.verify(this.utils, Mockito.times(2)).getLong();
		Mockito.verify(this.utils, Mockito.times(1)).getString();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}

	@Test
	public void testAddItem() {
		final Long itemId = 1L;
		final String itemName = "Hammer";
		final Double price = 20.00;
		Item add = new Item(itemId, itemName, price);
		final Long orderId = 1L;
		Order order = new Order(orderId, add);
		Mockito.when(this.utils.getLong()).thenReturn(order.getId(), add.getId());
		Mockito.when(this.utils.getString()).thenReturn("Add Item");
		Mockito.when(this.dao.addItem(orderId, itemId)).thenReturn(order);
		
		assertEquals(order, controller.update());
		
		Mockito.verify(this.utils, Mockito.times(2)).getLong();
		Mockito.verify(this.dao, Mockito.times(1)).addItem(orderId, itemId);

	}

	@Test
	public void testDeleteItem() {
		final Long itemId = 1L;
		final Long orderId = 1L;
		Mockito.when(dao.removeItem(orderId, itemId)).thenReturn(1);
		
		assertEquals(1, controller.deleteItem(orderId, itemId));
		
		Mockito.verify(dao, Mockito.times(1)).removeItem(orderId, itemId);
	}

	@Test
	public void testCostOrder() {
		Order cost = new Order(1L, 1L);
		final Double price = 20.00;
		Mockito.when(dao.costOrder(cost.getId())).thenReturn(price);
		
		assertEquals(price, controller.costOrder(cost.getId()), 0.01);
		
		Mockito.verify(dao, Mockito.times(1)).costOrder(cost.getId());
			

	}

	@Test
	public void testDelete() {
		final long ID = 2L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}
}

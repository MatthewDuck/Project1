package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {

	private final OrderDAO DAO = new OrderDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Order created = new Order(3L, 1L);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testAddItem() {
		final Item createdI = new Item(1L, "Hammer", 20.00);	
		final Order createdO = new Order(1L, createdI);
		assertEquals(createdO, DAO.addItem(createdO.getId(), createdI.getId()));
	}
	
	@Test
	public void testCostOrder() {
		final Order created = new Order(1L, 1L);
		assertEquals(40.00, DAO.costOrder(created.getId()), 0.01);

	}

	@Test
	public void testRemoveItem() {
		final Order createdO = new Order(1L, 1L);
		final Item createdI = new Item(1L, "Hammer", 20.00);
		assertEquals(1, DAO.removeItem(createdO.getId(), createdI.getId()));
	}

	@Test
	public void testReadAll() {
		List<Order> expected = new ArrayList<>();
		Item hammer = new Item(1L, "Hammer", 20.00);
		Item bike = new Item(2L, "Bike", 20.00);
		expected.add(new Order(1L, hammer));
		expected.add(new Order(1L, hammer));
		expected.add(new Order(1L, hammer));
		expected.add(new Order(1L, bike));
		expected.add(new Order(2L, bike));
		assertEquals(expected, DAO.readAll());

	}

	@Test
	public void testReadLatest() {
		assertEquals(new Order(2L, 2L), DAO.readLatest());
	}

	@Test
	public void testReadLatestItem() {
		Item item = new Item(2L, "Bike", 20.00);
		assertEquals(new Order(2L, item), DAO.readLatestItem());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Order(ID, 1L), DAO.read(ID));

	}

	@Test
	public void testUpdate() {
		final Order updated = new Order(1L, 2L);
		assertEquals(updated, DAO.update(updated));
	}

	@Test
	public void testDelete() {
		assertEquals(4, DAO.delete(1));

	}

}

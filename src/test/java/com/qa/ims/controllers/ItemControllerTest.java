package com.qa.ims.controllers;

import org.junit.Test;

import com.qa.ims.persistence.domain.Item;


public class ItemControllerTest {
	
	@Test
	public void testCreate() {
		final String itemName = "Hammer";
		final Double price = 20.00;
		final Item created = new Item(itemName, price);
	}

}

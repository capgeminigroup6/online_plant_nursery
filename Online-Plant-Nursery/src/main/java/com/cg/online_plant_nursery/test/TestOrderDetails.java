package com.cg.online_plant_nursery.test;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.cg.online_plant_nursery.dao.OrderDetailsDAO;
import com.cg.online_plant_nursery.services.OrderDetailsServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TestOrderDetails {
	@InjectMocks
	OrderDetailsServiceImpl service;
	
	@Mock
	OrderDetailsDAO dao;
	
	@Before
	public void init() {
		System.out.println("** before method ***");
		MockitoAnnotations.initMocks(this); 
	}
	
	@Test
	public void testGetOrderDetails() {
		
	}
}

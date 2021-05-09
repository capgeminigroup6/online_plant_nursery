package com.cg.online_plant_nursery.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.cg.online_plant_nursery.dao.CartDAO;
import com.cg.online_plant_nursery.entity.Cart;
import com.cg.online_plant_nursery.entity.Customer;
import com.cg.online_plant_nursery.entity.Plant;
import com.cg.online_plant_nursery.services.CartServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TestCart {
	
	@InjectMocks
	CartServiceImpl service;
	
	@Mock
	CartDAO dao;
	
	@Before
	public void init() {
		System.out.println("** before method ***");
		MockitoAnnotations.initMocks(this); 
	}
	
	@Test
	public void testGetAllCart() {
		List<Cart> cartlist = new ArrayList<>();
		Customer customer1 = new Customer(306, "Kaushik", "kaushik@gmail.com", "kashi123", 912712812, 3383.00);
		Customer customer2 = new Customer(310, "Genghis Khan", "khan@gmail.com", "ruler123", 999699999, 33414.00);
		Plant plant1 = new Plant(15, "Buxus Bonsai", "Bonsai Plant", 4899.00, "Boxwood is a very hardy plant and grows rapidly as well. This is mostly used as an ornamental plant and is grown and shaped into a variety of designs.", "https://cdn.shopify.com/s/files/1/0047/9730/0847/products/nurserylive-plants-buxus-bonsai-plant-16968671363212_600x600.jpg?v=1601351186");
		Plant plant2 = new Plant(14, "Banyan tree Bonsai", "Bonsai Plant", 3299.00, "Ficus trees are a common plant in the home and office, mainly due to the fact that they look like a typical tree with a single trunk and a spreading canopy.", "https://cdn.shopify.com/s/files/1/0047/9730/0847/products/nurserylive-plants-banyan-tree-bonsai-plant-16968612642956_400x400.jpg?v=1601348353");
		cartlist.add(new Cart(17, customer1, plant1, 6, null, null, null, null, null, null, null, null, 29394));
		cartlist.add(new Cart(22, customer2, plant2, 3, null, null, null, null, null, null, null, null, 9897));
		Mockito.when(dao.findAll()).thenReturn(cartlist);
		List<Cart> list = service.viewCart();
		Assertions.assertEquals(2, list.size());
		Mockito.verify(dao,Mockito.times(2)).findAll();
	}
	
	
	@Test
	public void testGetCartByID() {
		Customer customer = new Customer(306, "Kaushik", "kaushik@gmail.com", "kashi123", 912712812, 3383.00);
		Plant plant = new Plant(15, "Buxus Bonsai", "Bonsai Plant", 4899.00, "Boxwood is a very hardy plant and grows rapidly as well. This is mostly used as an ornamental plant and is grown and shaped into a variety of designs.", "https://cdn.shopify.com/s/files/1/0047/9730/0847/products/nurserylive-plants-buxus-bonsai-plant-16968671363212_600x600.jpg?v=1601351186");
		Mockito.when(dao.getCartById((long)17)).thenReturn(new Cart(17, customer, plant, 6, null, null, null, null, null, null, null, null, 29394));
		Cart cart = service.getOneCart1(17);
		assertEquals(plant, cart.getPlant());
		Assertions.assertEquals(6, (int)cart.getPlant_quantity());
		Mockito.verify(dao, Mockito.times(2)).getCartById((long)17);
	}
	
	@Test
	public void testAddPlantToCart() {
		Customer customer2 = new Customer(310, "Genghis Khan", "khan@gmail.com", "ruler123", 999699999, 33414.00);
		Plant plant2 = new Plant(14, "Banyan tree Bonsai", "Bonsai Plant", 3299.00, "Ficus trees are a common plant in the home and office, mainly due to the fact that they look like a typical tree with a single trunk and a spreading canopy.", "https://cdn.shopify.com/s/files/1/0047/9730/0847/products/nurserylive-plants-banyan-tree-bonsai-plant-16968612642956_400x400.jpg?v=1601348353");
		
		Cart cart = new Cart(22, customer2, plant2, 3, null, null, null, null, null, null, null, null, 9897);
		service.addPlantToCart(cart);
		Assert.assertNotNull(cart.getCartid()); 
		Mockito.verify(dao, Mockito.times(1)).save(cart);
	}
	
	@Test
	public void removePlantFromCart() {
		Customer customer2 = new Customer(310, "Genghis Khan", "khan@gmail.com", "ruler123", 999699999, 33414.00);
		Plant plant2 = new Plant(0, null, null, 0, null, null);
				
		Cart cart = new Cart(22, customer2, plant2, 0, null, null, null, null, null, null, null, null, 0);
		service.removePlantFromCart(cart);
		Assert.assertNotNull(cart.getCartid()); 
		Mockito.verify(dao, Mockito.times(1)).save(cart);
	}
	
	@Test
	public void updatePlantInCart() {
		Customer customer2 = new Customer(310, "Genghis Khan", "khan@gmail.com", "ruler123", 999699999, 33414.00);
		Plant plant2 = new Plant(14, "Banyan tree Bonsai", "Bonsai Plant", 3299.00, "Ficus trees are a common plant in the home and office, mainly due to the fact that they look like a typical tree with a single trunk and a spreading canopy.", "https://cdn.shopify.com/s/files/1/0047/9730/0847/products/nurserylive-plants-banyan-tree-bonsai-plant-16968612642956_400x400.jpg?v=1601348353");
		
		Cart cart = new Cart(22, customer2, plant2, 8, null, null, null, null, null, null, null, null, 9897);
		service.updatePlantInCart(cart);
		Assert.assertNotNull(cart.getCartid()); 
		Mockito.verify(dao, Mockito.times(1)).save(cart);
	}
}
















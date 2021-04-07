package com.cg.online_plant_nursery.test;

import org.junit.jupiter.api.Assertions;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.cg.online_plant_nursery.dao.FertilizerDAO;
import com.cg.online_plant_nursery.entity.Fertilizer;
import com.cg.online_plant_nursery.services.FertilizerServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TestManager {
	@InjectMocks
	FertilizerServiceImpl service;
	
	@Mock
	FertilizerDAO dao;
	
	@Before
	public void init() {
		System.out.println("** before method ***");
		MockitoAnnotations.initMocks(this); 
	}
	
	@Test
	public void testGetAllFertilizer() {
		List<Fertilizer> fertilizerList = new ArrayList<>();
		fertilizerList.add(new Fertilizer(888, "Ammonium Sulphate", "Nitrogen Fertilizers", 250, "Ammonium Sulphate Fertilizer is a fertilizer for all Plants and Garden.", "https://en.wikipedia.org/wiki/Sodium_nitrate#/media/File:Dusi%C4%8Dnan_sodn%C3%BD.JPG"));
		fertilizerList.add(new Fertilizer(889, "Potash", "Potassium Fertilizers", 179, "Improves Size of Flowers, Fruits and Vegetables.", "https://en.wikipedia.org/wiki/Potash#/media/File:PotashUSGOV.jpg"));
		
		Mockito.when(dao.findAll()).thenReturn(fertilizerList);
		List<Fertilizer> list = service.getAllFertilizers();
		Assertions.assertEquals(2, list.size()); 
		Mockito.verify(dao,Mockito.times(1)).findAll();
	}
	
//	@Test
//	public void testAddFertilizer() {
//		Fertilizer fertilizer = new Fertilizer();
//		fertilizer.setId(890);
//		fertilizer.setName("Potash"); 
//		fertilizer.setType("Potassium Fertilizers");
//		fertilizer.setPrice(179);
//		fertilizer.setDescription("Improves Size of Flowers, Fruits and Vegetables.");
//		fertilizer.setImage("https://en.wikipedia.org/wiki/Potash#/media/File:PotashUSGOV.jpg");
//		
//		service.addFertilizer(501, fertilizer);
//		//dao.save(item);
//		Assert.assertNotNull(fertilizer.getId()); 
//		Mockito.verify(dao, Mockito.times(1)).save(fertilizer);
//	}
	
}

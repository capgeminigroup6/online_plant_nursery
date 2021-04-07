package com.cg.online_plant_nursery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration 
//@ComponentScan(basePackages={"com.cg.online_plant_nursery.entity"}) 
//@EnableJpaRepositories(basePackages="com.cg.online_plant_nursery.services")
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

}

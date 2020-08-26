package com.ibm.orderms;

import java.util.Date;

import javax.persistence.criteria.Order;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.ibm.orderms.model.OrderDao;
import com.ibm.orderms.repository.OrderMSRepository;

@SpringBootApplication
@EnableEurekaClient
public class OrderMsApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(OrderMsApplication.class, args);
	}
	
	@Autowired
	OrderMSRepository orderRepository;

	
	@Bean
	public CommandLineRunner clr(final ApplicationContext ctx) {
		return (s) -> {
			OrderDao order = new OrderDao("ZSK13CG", new Date(), 1, 2500.00, "abc", "addr1","abc@gmail.com", "9898989711");
			orderRepository.save(order);
			order =  new OrderDao("ZSK13YY", new Date(), 2, 2800.00, "abc", "addr1","xyz@gmail.com", "9898989711");
			orderRepository.save(order);
			order = new OrderDao("ZSK13UU", new Date(), 3, 2600.00, "abc", "addr1","test1@gmail.com", "9898989711");
			orderRepository.save(order);
		};
	}

}

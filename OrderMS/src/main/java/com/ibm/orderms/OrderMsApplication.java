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
			OrderDao order = new OrderDao("ASD33TT", new Date(), 1, 3000.00, "abc", "addr1","abc@gmail.com", "9999887766");
			orderRepository.save(order);
			order =  new OrderDao("KJL1290", new Date(), 2, 2000.00, "xyz", "addr2","xyz@gmail.com", "8978563412");
			orderRepository.save(order);
			order = new OrderDao("KIB678Y", new Date(), 3, 1200.00, "qwe", "addr3","qwe@gmail.com", "9087564312");
			orderRepository.save(order);
		};
	}

}

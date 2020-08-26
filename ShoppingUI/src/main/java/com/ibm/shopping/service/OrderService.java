package com.ibm.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OrderService {
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	public String showOrders(String username, String token) {
		System.out.println("Getting Orders...");
		System.out.println("username: "+username);
		System.out.println("token: "+token);
		
		List<ServiceInstance> instances = discoveryClient.getInstances("orderms");
		for (ServiceInstance inst : instances) {
			System.out.println(inst.getHost() + ":" + inst.getPort());
		}
		ServiceInstance instance = instances.get(0);
		String host = instance.getHost();
		int port = instance.getPort();
		
		RestTemplate restTemplate = new RestTemplate();
		//String url = "http://localhost:8090/orders";
		String url = "http://" + host + ":" + port + "/orders";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer "+token);
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		System.out.println("Result - status ("+ response.getStatusCode() + ") has body: " + response.hasBody());
		System.out.println("Order Details Recieved: "+response.getBody());
		if(response.hasBody()) 
			return response.getBody();
		else 
			return null;
	}

}

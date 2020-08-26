package com.ibm.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.ibm.shopping.model.AuthResponse;
import com.ibm.shopping.model.UserDao;

@Service
public class LoginService {

	@Autowired
	DiscoveryClient discoveryClient;
	
	public String validateUser(String usename, String password) {
		String token = null;
		
		List<ServiceInstance> instances = discoveryClient.getInstances("accountms");
		for (ServiceInstance inst : instances) {
			System.out.println(inst.getHost() + ":" + inst.getPort());
		}
		ServiceInstance instance = instances.get(0);
		String host = instance.getHost();
		int port = instance.getPort();
		
		//String url = "http://localhost:8080/authenticate";
		String url = "http://" + host + ":" + port + "/authenticate";
		RestTemplate restTemplate = new RestTemplate();
		UserDao user = new UserDao();
		user.setUsername(usename);
		user.setPassword(password);

		try {
			HttpEntity<AuthResponse> resp = restTemplate.postForEntity(url, user, AuthResponse.class);
			token = resp.getBody().getAuthToken();
			System.out.println("token: " + token);
		} catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
			if (HttpStatus.UNAUTHORIZED.equals(httpClientOrServerExc.getStatusCode())) {
				System.out.println("Un authorized..");
			}
		}
		return token;
	}
}

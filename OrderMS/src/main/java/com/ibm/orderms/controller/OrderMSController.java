package com.ibm.orderms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.orderms.model.OrderDao;
import com.ibm.orderms.service.OrderService;

@RestController
public class OrderMSController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping(value="/orders", produces = "application/json")
	public ResponseEntity<List<OrderDao>> getOrders() {
		return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
	}
}

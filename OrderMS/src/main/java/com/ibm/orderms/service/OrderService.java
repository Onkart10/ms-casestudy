package com.ibm.orderms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.orderms.model.OrderDao;
import com.ibm.orderms.repository.OrderMSRepository;

@Service
public class OrderService {

	@Autowired
	OrderMSRepository orderRepository;
	
	public List<OrderDao> getAllOrders() {
		return orderRepository.findAll();
	}
	
	public OrderDao getOrderById(String id) {
		Optional<OrderDao> op = orderRepository.findById(id);
		if (op.isPresent())
			return op.get();
		else
			return null;
	}
}

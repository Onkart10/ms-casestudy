package com.ibm.orderms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.orderms.model.OrderDao;

@Repository
public interface OrderMSRepository extends JpaRepository<OrderDao, String>{

}

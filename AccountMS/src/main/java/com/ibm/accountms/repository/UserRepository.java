package com.ibm.accountms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.ibm.accountms.model.UserDao;

@Component
public interface UserRepository extends CrudRepository<UserDao, Integer> {
	UserDao findByUsername(String username);
}
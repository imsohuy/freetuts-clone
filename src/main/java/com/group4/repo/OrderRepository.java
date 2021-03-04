package com.group4.repo;

import org.springframework.data.repository.CrudRepository;

import com.group4.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Integer>{

}

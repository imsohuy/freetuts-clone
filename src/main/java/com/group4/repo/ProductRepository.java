package com.group4.repo;

import org.springframework.data.repository.CrudRepository;

import com.group4.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

}

package com.group4.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.group4.entity.Discount;

public interface DiscountRepository extends CrudRepository<Discount, Integer>{
	@Query(value = "select d.* from discount d", nativeQuery = true)
	List<Discount> findAll();
}

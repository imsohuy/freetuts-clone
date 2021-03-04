package com.group4.repo;

import org.springframework.data.repository.CrudRepository;

import com.group4.entity.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer>{

}

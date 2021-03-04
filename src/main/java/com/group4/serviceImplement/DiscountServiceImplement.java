package com.group4.serviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.entity.Discount;
import com.group4.repo.DiscountRepository;
import com.group4.service.DiscountService;

@Service
public class DiscountServiceImplement implements DiscountService{
	
	@Autowired
	DiscountRepository disRepo;
	
	@Override
	public List<Discount> findAll() {
		return disRepo.findAll();
	}

}

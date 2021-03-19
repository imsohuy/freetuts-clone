package com.group4.service;

import java.util.List;

import com.group4.DTO.DiscountDTO;

public interface DiscountService {
	List<DiscountDTO> findAll();
	
	DiscountDTO findByDiscountName(String discountName);
	
	DiscountDTO findByCode(String code);
	
	boolean createDiscount(DiscountDTO discount);
	
	int getMaxDiscountID();
}

package com.group4.serviceImplement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.DTO.DiscountDTO;
import com.group4.entity.Discount;
import com.group4.repo.DiscountRepository;
import com.group4.service.DiscountService;

@Service
public class DiscountServiceImplement implements DiscountService{
	
	@Autowired
	DiscountRepository disRepo;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public List<DiscountDTO> findAll() {
		List <Discount> discountList = disRepo.findAll();
		List<DiscountDTO> discountDTOList = new ArrayList<DiscountDTO>();
		for (Iterator<Discount> iterator = discountList.iterator(); iterator.hasNext();) {
			Discount discount = (Discount) iterator.next();
			DiscountDTO discountDTO = mapper.map(discount, DiscountDTO.class);
			discountDTOList.add(discountDTO);
		}
		return discountDTOList;
	}

	@Override
	public DiscountDTO findByDiscountName(String discountName) {
		Discount discount = disRepo.findByDiscountName(discountName);
		if(discount != null) {
			DiscountDTO discountDTO = mapper.map(discount, DiscountDTO.class);
			return discountDTO;
		}
		return null;
	}

	@Override
	public DiscountDTO findByCode(String code) {
		Discount discount = disRepo.findByCode(code);
		if(discount != null) {
			DiscountDTO discountDTO = mapper.map(discount, DiscountDTO.class);
			return discountDTO;
		}
		return null;
	}
	
	@Override
	public int getMaxDiscountID() {
		return disRepo.getMaxDiscountID();
	}
	
	@Override
	public boolean createDiscount(DiscountDTO discountDTO) {
		// TODO Auto-generated method stub
		try {
			Discount discount = mapper.map(discountDTO, Discount.class);
			disRepo.save(discount);
			return true;
		}
		catch(IllegalArgumentException ex) {
			return false;
		}
	}

	

}

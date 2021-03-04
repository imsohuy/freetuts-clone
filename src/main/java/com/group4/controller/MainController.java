	package com.group4.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group4.entity.Discount;
import com.group4.entity.Post;
import com.group4.service.CategoryService;
import com.group4.service.DiscountService;
import com.group4.service.PostService;

@Controller
public class MainController {
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private PostService postService;

	@Autowired
	private DiscountService discountService;
	
	@RequestMapping("/{post-content}")
	public String viewPostPage(@PathVariable ("post-content") String postContent, Model model) {
		return postContent;
	}

	@RequestMapping(value = "/")
	public String home(Model model) {
		Integer catID = null;
		
		List<Integer> cIdList = new ArrayList<Integer>();

		// da test
		// lap trinh
		catID = categoryService.findByCategoryName("Lập trình").getCategoryId();
		cIdList = categoryService.findAllSubCatId(catID);
		if(cIdList.size() == 0) cIdList.add(catID);
		List<Post> programPostList = postService.findTop5ByCategoryIdInOrderByPostIdDesc(cIdList);
		model.addAttribute("programPostList", programPostList);
		
		// web mien phi - chua co data
		catID = categoryService.findByCategoryName("Web miễn phí").getCategoryId();
		cIdList = categoryService.findAllSubCatId(catID);
		if(cIdList.size() == 0) cIdList.add(catID);
		List<Post> webPostList = postService.findTop5ByCategoryIdInOrderByPostIdDesc(cIdList);
		model.addAttribute("webPostList", webPostList);

		// quan tri web - chua co data
		catID = categoryService.findByCategoryName("Quản trị Web").getCategoryId();
		cIdList = categoryService.findAllSubCatId(catID);
		if(cIdList.size() == 0) cIdList.add(catID);
		List<Post> webmastersPostList = postService.findTop5ByCategoryIdInOrderByPostIdDesc(cIdList);
		model.addAttribute("webmastersPostList", webmastersPostList);
		
		// tin hoc - chua co data
		catID = categoryService.findByCategoryName("Tin học").getCategoryId();
		cIdList = categoryService.findAllSubCatId(catID);
		if(cIdList.size() == 0) cIdList.add(catID);
		List<Post> informaticsPostList = postService.findTop5ByCategoryIdInOrderByPostIdDesc(cIdList);
		model.addAttribute("informaticsPostList", informaticsPostList);
		
		// bai tap
		cIdList = categoryService.findByCategoryNameLike("%Bài tập%");
		List<Post> exercisePostList = postService.findTop7ByCategoryIdInOrderByPostIdDesc(cIdList);
		model.addAttribute("exercisePostList", exercisePostList);

		// review khoa hoc - chua co data
		catID = categoryService.findByCategoryName("Khóa học").getCategoryId();
		cIdList = categoryService.findAllSubCatId(catID);
		if(cIdList.size() == 0) cIdList.add(catID);
		List<Post> coursePostList = postService.findTop5ByCategoryIdInOrderByPostIdDesc(cIdList);
		model.addAttribute("coursePostList", coursePostList);
		model.addAttribute("size", coursePostList.size());
	
		// coupon list - load du lieu tu bang discount		
		List<Discount> couponList = discountService.findAll();
		model.addAttribute("couponList", couponList);
		
		// coupon giam gia
		catID = categoryService.findByCategoryName("Coupon giảm giá").getCategoryId();
		cIdList = categoryService.findAllSubCatId(catID);
		if(cIdList.size() == 0) cIdList.add(catID);
		List<Post> discountPostList = postService.findTop12ByCategoryIdInOrderByPostIdDesc(cIdList);
		model.addAttribute("discountPostList", discountPostList);

		// thu thuat
		catID = categoryService.findByCategoryName("Thủ thuật").getCategoryId();
		cIdList = categoryService.findAllSubCatId(catID);
		if(cIdList.size() == 0) cIdList.add(catID);
		List<Post> tipsPostList = postService.findTop5ByCategoryIdInOrderByPostIdDesc(cIdList);
		model.addAttribute("tipsPostList", tipsPostList);
		
		
		//-------------------------------------------------------------------------------------------------
		
		//comment do chua co data 

		// download - chua co data
//		catID = categoryService.findByCategoryName("Download").getCategoryId();
//		cIdList = categoryService.findAllSubCatId(catID);
//		if(cIdList.size() == 0) cIdList.add(catID);
//		List<Post> downloadPostList = postService.findTop5ByCategoryIdInOrderByPostIdDesc(cIdList);
//		model.addAttribute("downloadPostList", downloadPostList);

		// marketing - chua co data
//		catID = categoryService.findByCategoryName("Marketing").getCategoryId();
//		cIdList = categoryService.findAllSubCatId(catID);
//		if(cIdList.size() == 0) cIdList.add(catID);
//		List<Post> marketingPostList = postService.findTop5ByCategoryIdInOrderByPostIdDesc(cIdList);
//		model.addAttribute("marketingPostList", marketingPostList);

		// kham pha - chua co data
//		catID = categoryService.findByCategoryName("Khám phá").getCategoryId();
//		cIdList = categoryService.findAllSubCatId(catID);
//		if(cIdList.size() == 0) cIdList.add(catID);
//		List<Post> discoverPostList = postService.findTop5ByCategoryIdInOrderByPostIdDesc(cIdList);
//		model.addAttribute("discoverPostList", discoverPostList);

		// mon hoc - chua co data
//		catID = categoryService.findByCategoryName("Môn học").getCategoryId();
//		cIdList = categoryService.findAllSubCatId(catID);
//		if(cIdList.size() == 0) cIdList.add(catID);
//		List<Post> studyPostList = postService.findTop5ByCategoryIdInOrderByPostIdDesc(cIdList);
//		model.addAttribute("studyPostList", studyPostList);


		
							
		return "mainpage";
	}

}

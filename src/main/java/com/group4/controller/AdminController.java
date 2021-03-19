package com.group4.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.group4.DTO.CategoryDTO;
import com.group4.DTO.DiscountDTO;
import com.group4.DTO.PostDTO;
import com.group4.DTO.TemplateDTO;
import com.group4.service.CategoryService;
import com.group4.service.DiscountService;
import com.group4.service.PostService;
import com.group4.service.TemplateService;

@Controller
public class AdminController {
	
	@Autowired
	private DiscountService discountService;
	
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private PostService postService;
	
	@Autowired
	private TemplateService templateService;
	
	@RequestMapping(value = "/post-article")
	public String postArticlePage(Model model) {
		List<CategoryDTO> categoryDTOList = categoryService.findByStatus(true);
		model.addAttribute("categoryList", categoryDTOList);
		
		model.addAttribute("templateList", templateService.findAll());
		return "post-article";
	}
	
	@RequestMapping(value = "/post-article", method = RequestMethod.POST)
	@ResponseBody
	public String postArticle(@RequestParam("txtTitle") String title, @RequestParam("txtCategory") String categoryName, 
			@RequestParam("txtDescription") String description, @RequestParam("fileUp") MultipartFile image, 
			@RequestParam("txtTemplate") String templateName, @RequestParam("editor") String postContent, HttpServletRequest request) {	
		CategoryDTO categoryDTO = categoryService.findByCategoryName(categoryName);
		if(categoryDTO == null && categoryName.trim().length() != 0) {
			return "Category not existed";
		}
		TemplateDTO templateDTO = templateService.findByTemplateName(templateName);
		if(templateDTO == null && templateName.trim().length() != 0) {
			return "Template not existed";
		}
		//create post start
		int postID = postService.getMaxPostID() + 1; 
			
		long millis=System.currentTimeMillis();  
		Date date = new Date(millis);
			
		String imageName = "";
		String imageExtension = null;
		if(!image.isEmpty()) {
			imageName = StringUtils.cleanPath(image.getOriginalFilename());
			imageExtension = imageName.substring(imageName.lastIndexOf("."));
			imageName = postID + imageExtension;
		}
			
		PostDTO postDTO = new PostDTO(postID, title, date, description, imageName, postContent,
				null, categoryDTO.getCategoryId(),templateDTO.getTemplateId(), true);
		boolean result = postService.createUpdatePost(postDTO);
			
		if (result) {
			if(!image.isEmpty()) {
				try {
					String uploadRootPath = request.getServletContext().getRealPath("/") + "image\\";
					File uploadRootDir = new File(uploadRootPath);
			        
			        if (!uploadRootDir.exists()) {
			            uploadRootDir.mkdirs();
			        }
				        
			        File serverFile = new File(uploadRootDir.getAbsolutePath() + "\\" +imageName);
			        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
	                stream.write(image.getBytes());
	                stream.close();
	                    
				}
				catch (Exception e) {
					return "FAIL";
				}
			}
		}
		//create post end 
		return "SUCCESS";
	}
	
	@RequestMapping(value = "/search-article")
	public String searchArticlePage(Model model, @RequestParam(required = false, name = "txtTitle") String title,
			@RequestParam(required = false, name = "txtCategory") String categoryName) {
		List<CategoryDTO> categoryDTOList = categoryService.findByStatus(true);
		model.addAttribute("categoryList", categoryDTOList);
		if(categoryName != null) {
			Integer catID = categoryService.findByCategoryName(categoryName).getCategoryId();
			List<PostDTO> postDTOList = postService.findByTitleLikeAndCategoryId("%"+title+"%", catID);
			model.addAttribute("listPost", postDTOList);
			model.addAttribute("categoryName", categoryName);
		}
		return "search-article";
	}
	
	@RequestMapping(value = "/update-article/{postID}")
	public String updateArticlePage(Model model, @PathVariable("postID") String postID) {
		PostDTO postDTO = postService.findByPostId(Integer.parseInt(postID));
		model.addAttribute("post", postDTO);
		
		String categoryName = categoryService.findByPostId(Integer.parseInt(postID)).getCategoryName();
		model.addAttribute("categoryName", categoryName);
		
		List<CategoryDTO> categoryDTOList = categoryService.findByStatus(true);
		model.addAttribute("categoryList", categoryDTOList);
		
		String templateName = templateService.findByPostId(Integer.parseInt(postID)).getTemplateName();
		model.addAttribute("templateName", templateName);
		
		model.addAttribute("templateList", templateService.findAll());
		
		return "update-article";
	}
	
	@RequestMapping(value = "/update-article", method = RequestMethod.POST)
	@ResponseBody
	public String updateArticle(Model model, @RequestParam("txtPostID") String postID, @RequestParam("txtTitle") String title,
			@RequestParam("txtTemplate") String templateName, @RequestParam("txtCategory") String categoryName,
			@RequestParam("txtDescription") String description, @RequestParam("fileUp") MultipartFile image, 
			@RequestParam(value = "Status", required = false) String status, @RequestParam("editor") String postContent, 
			HttpServletRequest request) {
		CategoryDTO categoryDTO = categoryService.findByCategoryName(categoryName);
		if(categoryDTO == null && categoryName.trim().length() != 0) {
			return "Category not existed";
		}
		
		TemplateDTO templateDTO = templateService.findByTemplateName(templateName);
		if(templateDTO == null && templateName.trim().length() != 0) {
			return "Template not existed";
		}
		
		PostDTO oldPostDTO = postService.findByPostId(Integer.parseInt(postID));
		boolean postStatus = false;
		if(status != null) {
			postStatus = true;
		}
		
		String imageName = "";
		String imageExtension = null;
		if(!image.isEmpty()) {
			imageName = StringUtils.cleanPath(image.getOriginalFilename());
			imageExtension = imageName.substring(imageName.lastIndexOf("."));
			imageName = postID + imageExtension;
		}
		else {
			imageName = oldPostDTO.getImage();
		}
		
		PostDTO postDTO = new PostDTO(oldPostDTO.getPostId(), title, oldPostDTO.getDate(), description,
				imageName, postContent, oldPostDTO.getAuthor(), categoryDTO.getCategoryId(), templateDTO.getTemplateId(), postStatus);
		boolean result = postService.createUpdatePost(postDTO);
		
		if (result) {
			if(!image.isEmpty()) {
				try {
					String uploadRootPath = request.getServletContext().getRealPath("/") + "image\\";
					File uploadRootDir = new File(uploadRootPath);
			        
			        if (!uploadRootDir.exists()) {
			            uploadRootDir.mkdirs();
			        }
				        
			        File serverFile = new File(uploadRootDir.getAbsolutePath() + "\\" +imageName);
			        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
	                stream.write(image.getBytes());
	                stream.close();
	                    
				}
				catch (Exception e) {
					return "FAIL";
				}
			}
		}
		return "SUCCESS";
	}
	
	@RequestMapping(value = "/create-discount-code")
	public String createDiscountCodePage(Model model) {
		return "create-discount-code";
	}
	
	@RequestMapping(value = "/create-discount-code", method = RequestMethod.POST)
	@ResponseBody
	public String createDiscountCode(@RequestParam("txtDiscountName") String discountName,
			@RequestParam("txtDiscountCode") String discountCode, @RequestParam("txtPercentage") String percentage,
			@RequestParam("txtDiscountLink") String discountLink) {	
		if(discountService.findByDiscountName(discountName) != null) {
			return "Discount name already existed";
		}
		if(discountService.findByCode(discountCode) != null) {
			return "Discount code already existed";
		}
		Integer discountID = discountService.getMaxDiscountID() + 1;
		DiscountDTO discountDTO = new DiscountDTO(discountID, discountName, discountCode, Integer.parseInt(percentage), discountLink, true);
		boolean result = discountService.createDiscount(discountDTO);
		if(!result) {
			return "FAIL";
		}
		return "SUCCESS";
	}
	
	@RequestMapping(value = "/remove-discount-code")
	public String removeDiscountCodePage(Model model) {
		List<DiscountDTO> couponList = discountService.findAll();
		model.addAttribute("couponList", couponList);
		return "remove-discount-code";
	}
	
	//dưới này chưa xong
	/*
	
	@RequestMapping(value = "/remove-discount-code", method = RequestMethod.POST)
	@ResponseBody
	public String removeDiscountCode(@RequestParam("txtDiscountName") String discountName) {	
		DiscountDTO discountDTO = discountService.findByDiscountName(discountName);
		if(discountDTO != null) {
			
		} 
		else {
			return "Discount name not existed";
		}
		return "SUCCESS";
	}

	@RequestMapping(value = "/create-category")
	public String createCategoryPage(Model model) {
		List<CategoryDTO> categoryDTOList = categoryService.findByStatus(true);
		model.addAttribute("categoryList", categoryDTOList);
		return "create-category";
	}
	
	@RequestMapping(value = "/create-category", method = RequestMethod.POST)
	@ResponseBody
	public String createCategory(@RequestParam("txtCategoryName") String categoryName, @RequestParam("txtParentCategory") String parentCategoryName,
			@RequestParam("txtPath") String path, @RequestParam("editor") String postContent) {	
		System.out.println(categoryName);
		System.out.println(parentCategoryName);
		CategoryDTO categoryDTO = categoryService.findByCategoryName(parentCategoryName);
		if(categoryDTO == null && parentCategoryName.trim().length() != 0) {
			return "Category not existed";
		}
		return "SUCCESS";
	}
	*/
}

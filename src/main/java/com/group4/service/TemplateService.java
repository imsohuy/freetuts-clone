package com.group4.service;

import java.util.List;

import com.group4.DTO.TemplateDTO;

public interface TemplateService {
	
	List<TemplateDTO> findAll();
	
	TemplateDTO findByTemplateName(String templateName);
	
	TemplateDTO findByTemplateId(Integer templateId);
	
	TemplateDTO findByPostId(Integer postID);
}

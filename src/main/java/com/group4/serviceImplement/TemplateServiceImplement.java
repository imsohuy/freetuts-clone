package com.group4.serviceImplement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.DTO.TemplateDTO;
import com.group4.entity.Post;
import com.group4.entity.Template;
import com.group4.repo.PostRepository;
import com.group4.repo.TemplateRepository;
import com.group4.service.TemplateService;

@Service
public class TemplateServiceImplement implements TemplateService{

	@Autowired
	TemplateRepository templateRepo;
	
	@Autowired
	PostRepository postRepo;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public List<TemplateDTO> findAll() {
		List <Template> templateList = templateRepo.findAll();
		List<TemplateDTO> templateDTOList = new ArrayList<TemplateDTO>();
		for (Iterator<Template> iterator = templateList.iterator(); iterator.hasNext();) {
			Template template = (Template) iterator.next();
			TemplateDTO templateDTO = mapper.map(template, TemplateDTO.class);
			templateDTOList.add(templateDTO);
		}
		return templateDTOList;
	}

	@Override
	public TemplateDTO findByTemplateName(String templateName) {
		Template template = templateRepo.findByTemplateName(templateName);
		if(template != null) {
			TemplateDTO templateDTO = mapper.map(template, TemplateDTO.class);
			return templateDTO;
		}
		return null;
	}

	@Override
	public TemplateDTO findByTemplateId(Integer templateId) {
		Template template = templateRepo.findByTemplateId(templateId);
		if(template != null) {
			TemplateDTO templateDTO = mapper.map(template, TemplateDTO.class);
			return templateDTO;
		}
		return null;
	}

	@Override
	public TemplateDTO findByPostId(Integer postID) {
		Post post = postRepo.findByPostId(postID);
		Template template = templateRepo.findByTemplateId(post.getTemplateId());
		if(template != null) {
			TemplateDTO templateDTO = mapper.map(template, TemplateDTO.class);
			return templateDTO;
		}
		return null;
	}

}

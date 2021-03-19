package com.group4.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.group4.entity.Template;


public interface TemplateRepository extends CrudRepository<Template, Integer>{

	List<Template> findAll();
	
	Template findByTemplateName(String templateName);
	
	Template findByTemplateId(Integer templateId);
}

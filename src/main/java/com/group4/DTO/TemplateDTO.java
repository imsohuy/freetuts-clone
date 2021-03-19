package com.group4.DTO;


public class TemplateDTO {
	
    private Integer templateId;
    
    private String templateName;
	
    private String templateLink;

	public TemplateDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TemplateDTO(Integer templateId, String templateName, String templateLink) {
		super();
		this.templateId = templateId;
		this.templateName = templateName;
		this.templateLink = templateLink;
	}

	public Integer getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getTemplateLink() {
		return templateLink;
	}

	public void setTemplateLink(String templateLink) {
		this.templateLink = templateLink;
	}
    
    
}

package com.group4.DTO;

public class DiscountDTO{
	private Integer discountId;
	
	private String discountName;
	
	private String code;
	
	private Integer percentage;
	
	private String discountLinkPage;
	
	private boolean status;
	
	public DiscountDTO() {
		super();
	}

	public DiscountDTO(Integer discountId, String discountName, String code, Integer percentage,
			String discountLinkPage, boolean status) {
		super();
		this.discountId = discountId;
		this.discountName = discountName;
		this.code = code;
		this.percentage = percentage;
		this.discountLinkPage = discountLinkPage;
		this.status = status;
	}

	public Integer getDiscountId() {
		return discountId;
	}

	public void setDiscountId(Integer discountId) {
		this.discountId = discountId;
	}

	public String getDiscountName() {
		return discountName;
	}

	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getPercentage() {
		return percentage;
	}

	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}

	public String getDiscountLinkPage() {
		return discountLinkPage;
	}

	public void setDiscountLinkPage(String discountLinkPage) {
		this.discountLinkPage = discountLinkPage;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	
}

package com.group4.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "discount")
public class Discount {
	@Id
	@Column(name = "discount_id")
	private Integer discountId;
	
	@Column(name = "discount_name")
	private String discountName;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "percentage")
	private Integer percentage;
	
	@Column(name = "discount_link_page")
	private String discountLinkPage;

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

}

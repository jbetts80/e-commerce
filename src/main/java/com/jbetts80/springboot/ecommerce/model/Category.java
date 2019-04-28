package com.jbetts80.springboot.ecommerce.model;

import java.util.List;

import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("All category data")
//@Entity
public class Category {

	//@Id
	//@GeneratedValue
	private long id;

	@ApiModelProperty("Parent category id if exists")
	private long parentId;

	@Size(min = 3, max = 50, message = "SKU must have between 3 and 50 characters")
	@ApiModelProperty("SKU must have between 3 and 50 characters")
	private String title;

	@Size(max = 100, message = "Description must have up to 100 characters")
	@ApiModelProperty("Description must have up to 100 characters")
	private String description;

	//@OneToMany(mappedBy = "category")
	private List<Category> products;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Category> getProducts() {
		return products;
	}

	public void setProducts(List<Category> products) {
		this.products = products;
	}
}

package com.jbetts80.springboot.ecommerce.model;

import java.time.LocalDate;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("All product data")
//@Entity
public class Product {

	//@Id
	//@GeneratedValue
	private long id;

	@Size(min = 3, max = 14, message = "SKU must have between 3 and 14 characters")
	@ApiModelProperty("SKU must have between 3 and 14 characters")
	private String sku;

	@Size(min = 3, max = 50, message = "Title must have between 3 and 50 characters")
	@ApiModelProperty("Title must have between 3 and 50 characters")
	private String title;

	@Size(max = 500, message = "Description must have up to 500 characters")
	@ApiModelProperty("Description must have up to 500 characters")
	private String description;

	private double price;

	private LocalDate creationDate;

	@JsonIgnore
	//@ManyToOne(fetch = FetchType.LAZY)
	private int categoryId;

	protected Product() {
	}

	public Product(long id, String sku, String title, String description, double price, int categoryId) {
		super();
		this.id = id;
		this.sku = sku;
		this.title = title;
		this.description = description;
		this.price = price;
		this.creationDate = LocalDate.now();
		this.categoryId = categoryId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
}

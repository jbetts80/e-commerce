
package com.jbetts80.springboot.ecommerce.model;

import java.time.LocalDate;

public class Product {

    private long id;

    private String sku;

    private String title;

    private String description;

    private double price;

    private LocalDate creationDate;

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

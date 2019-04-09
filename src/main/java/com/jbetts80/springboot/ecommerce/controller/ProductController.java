
package com.jbetts80.springboot.ecommerce.controller;

import com.jbetts80.springboot.ecommerce.exception.ProductNotFoundException;
import com.jbetts80.springboot.ecommerce.model.Product;
import com.jbetts80.springboot.ecommerce.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(path = "/products/{id}")
    public Product findProductById(@PathVariable long id) {
        Product product = productService.findById(id);
        if(product == null) {
            throw new ProductNotFoundException("id [" + id + "]");
        }
        return product;
    }

    @GetMapping(path = "/products")
    public List<Product> findAllProducts() {
        return productService.findAll();
    }

    @PostMapping("/products")
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        Product newProduct = productService.save(product);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newProduct.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}

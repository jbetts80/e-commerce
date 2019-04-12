package com.jbetts80.springboot.ecommerce.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jbetts80.springboot.ecommerce.exception.ProductNotFoundException;
import com.jbetts80.springboot.ecommerce.model.Product;
import com.jbetts80.springboot.ecommerce.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping(path = "/products/{id}")
	public Resource<Product> findProductById(@PathVariable long id) {
		Product product = productService.findById(id);
		if (product == null) {
			throw new ProductNotFoundException("id [" + id + "]");
		}

		Resource<Product> resource = new Resource<Product>(product);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findAllProducts());
		resource.add(linkTo.withRel("all-products"));

		return resource;
	}

	@GetMapping(path = "/products")
	public List<Product> findAllProducts() {
		return productService.findAll();
	}

	@PostMapping("/products")
	public ResponseEntity<Object> createProduct(@RequestBody Product product) {
		Product newProduct = productService.save(product);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newProduct.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable long id) {
		Product product = productService.deleteById(id);

		if (product == null) {
			throw new ProductNotFoundException("id [" + id + "]");
		}
	}
}

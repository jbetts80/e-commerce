
package com.jbetts80.springboot.ecommerce.service;

import com.jbetts80.springboot.ecommerce.model.Product;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductService {

    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(products.size() + 1, "ASDIUHUHFUSD", "Bose Quietcomfort 35 ii",
                "Wireless Headphones, Noise Cancelling, with Alexa voice control – Triple Midnight", 349, 1));
    }

    public Product findById(long id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public List<Product> findAll() {
        return products;
    }

    public Product save(Product product) {
        if (product.getId() == 0) {
            product.setId(products.size() + 1);
        }
        products.add(product);
        return product;
    }

    public void delete(long id) {
        for (Product product : products) {
            if (product.getId() == id) {
                products.remove((int) id);
            }
        }
    }
}

package org.murat.pluralsight.controllers;

import org.murat.pluralsight.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    private List<Product> productRepository;

    public ProductController(){
        this.productRepository = buildProductRepository();
    }

    @RequestMapping(value = "products", method = RequestMethod.GET)
    public List<Product> getProducts() {
        return productRepository;
    }

    @RequestMapping(value = "products/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable String id){
        for(Product product: productRepository){
            if(product.getId().equalsIgnoreCase(id)){
                return product;
            }
        }
        return null;
    }

    private List<Product> buildProductRepository(){
        List<Product> products = new ArrayList<>();

        products.add(new Product("1","product1"));
        products.add(new Product("2","product2"));
        products.add(new Product("3","product3"));
        products.add(new Product("4","product4"));
        products.add(new Product("5","product5"));

        return products;
    }
}

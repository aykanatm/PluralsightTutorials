package org.murat.pluralsight.controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.murat.pluralsight.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RibbonClient(name = "product-service")
@RestController
public class ProductDashboardController {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getProductBackup")
    @RequestMapping(value = "/dashboard/products/{productId}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable String productId){
        return restTemplate.getForObject("http://product-service/products/" + productId, Product.class);
    }

    public Product getProductBackup(@PathVariable String productId){
        System.out.println("Fallback operation called!");

        Product p = new Product();
        p.setId(productId);
        p.setName("hy_name");

        return p;
    }
}

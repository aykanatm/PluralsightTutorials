package org.murat.pluralsight.controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.murat.pluralsight.models.Customer;
import org.murat.pluralsight.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DashboardController {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getProductBackup")
    @RequestMapping(value = "dashboard/products/{productId}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable String productId){
        return restTemplate.getForObject("http://product-service/products/" + productId, Product.class);
    }

    @HystrixCommand(fallbackMethod = "getCustomerBackup")
    @RequestMapping(value = "dashboard/customers/{customerId}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable String customerId){
        return restTemplate.getForObject("http://customer-service/customers/" + customerId, Customer.class);
    }

    public Product getProductBackup(@PathVariable String productId){
        System.out.println("Fallback operation called!");

        Product p = new Product();
        p.setId("hy_1");
        p.setName("hy_name");

        return p;
    }

    public Customer getCustomerBackup(@PathVariable String customerId){
        System.out.println("Fallback operation called!");

        Customer c = new Customer();
        c.setId("hy_1");
        c.setLastname("hy_lastname");
        c.setName("hy_name");

        return c;
    }
}

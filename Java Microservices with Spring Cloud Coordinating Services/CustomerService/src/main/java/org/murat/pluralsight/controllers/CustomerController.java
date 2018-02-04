package org.murat.pluralsight.controllers;

import org.murat.pluralsight.models.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    private List<Customer> customerRepository;

    public CustomerController(){
        customerRepository = buildCustomerRepository();
    }

    @RequestMapping(value = "customers", method = RequestMethod.GET)
    public List<Customer> getCustomers() {
        return customerRepository;
    }

    @RequestMapping(value = "customers/{id}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable String id){
        for(Customer customer: customerRepository){
            if(customer.getId().equalsIgnoreCase(id)){
                return customer;
            }
        }
        return null;
    }

    private List<Customer> buildCustomerRepository(){
        List<Customer> repository = new ArrayList<>();

        repository.add(new Customer("1","name1", "lastname1"));
        repository.add(new Customer("2","name2", "lastname2"));
        repository.add(new Customer("3","name3", "lastname3"));
        repository.add(new Customer("4","name4", "lastname4"));
        repository.add(new Customer("5","name5", "lastname6"));

        return repository;
    }
}

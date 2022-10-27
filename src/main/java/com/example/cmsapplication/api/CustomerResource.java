package com.example.cmsapplication.api;

import com.example.cmsapplication.model.Customer;
import com.example.cmsapplication.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping(value="/{c1}/{c2}")
    public List<Customer> get2Customers(@PathVariable("c1") int customer1,@PathVariable("c2") int customer2){
        List<Customer> clist=new CopyOnWriteArrayList<>();
        clist.add(customerService.getCustomer(customer1));
        clist.add(customerService.getCustomer(customer2));
        return clist;
    }

    @GetMapping(value="/{customerId}")
    public Customer getCustomer( @PathVariable("customerId") int customerId){
        return customerService.getCustomer(customerId);
    }

    @PutMapping(value = "/{customerId}")
    public Customer updateCustomer(@PathVariable("customerId") int customerId,@RequestBody Customer customer) {
      return customerService.updateCustomer(customerId,customer);
    }

    @DeleteMapping(value = "/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") int customerId){
        customerService.deleteCustomer(customerId);
    }


}

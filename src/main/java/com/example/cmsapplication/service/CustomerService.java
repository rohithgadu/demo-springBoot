package com.example.cmsapplication.service;


import com.example.cmsapplication.dao.CustomerDAO;
import com.example.cmsapplication.exception.CustomerNotFoundException;
import com.example.cmsapplication.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;
    public Customer addCustomer(Customer customer){
        return customerDAO.save(customer);
    }

    public List<Customer> getCustomers(){
        return customerDAO.findAll();
    }

    public Customer getCustomer(int customerID){
       Optional<Customer> optionalCustomer=customerDAO.findById(customerID);
       if(!optionalCustomer.isPresent())
           throw new CustomerNotFoundException("Customer Record is not available");
       return optionalCustomer.get();
    }

    public Customer updateCustomer(int customerID,Customer customer){
        customer.setCustomerID(customerID);
        return customerDAO.save(customer);
    }

    public void deleteCustomer(int customerId){
        customerDAO.deleteById(customerId);
    }


}

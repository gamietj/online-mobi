/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abdul.onlinemobi.services.Impl;

import com.abdul.onlinemobi.domain.Customer;
import com.abdul.onlinemobi.domain.MobilePhone;
import com.abdul.onlinemobi.repository.CustomerRepository;
import com.abdul.onlinemobi.services.FindCustomerService;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Khulsum
 */
@Service
public class FindCustomerServiceImpl implements FindCustomerService {
    
    @Autowired
    CustomerRepository customerRepo;
    
    @Override
    public Customer getCustomer(String id) {
        
        
        
        Customer customer = new Customer();
        List<Customer> allcustomer = customerRepo.findAll();
                
        for (Customer customers: allcustomer) {
            if (Objects.equals(customers.getIdnumber(), id)) {
                  customer = customers;
               }
           
        }
             return customer;  
        
    }
    

    
}

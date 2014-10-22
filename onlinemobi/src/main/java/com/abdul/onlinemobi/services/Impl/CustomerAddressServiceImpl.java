/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdul.onlinemobi.services.Impl;

import com.abdul.onlinemobi.domain.Customer;
import com.abdul.onlinemobi.domain.CustomerAddress;
import com.abdul.onlinemobi.repository.CustomerRepository;
import com.abdul.onlinemobi.services.CustomerAddressService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author BKLAAS1
 */
@Service
public class CustomerAddressServiceImpl implements CustomerAddressService {
    @Autowired
    CustomerRepository customerepository = null;
    CustomerAddress customerAddress = null;
    List<Customer> customers = new ArrayList<>();
    
    @Override
    public CustomerAddress getCustomer(String id) {
        customers = customerepository.findAll();
        for(Customer customer: customers) {
            if(customer.getCustomerNumber().equals(id))
            {
                customerAddress = customer.getAddress();
            }
        }
        return customerAddress;
    }
    
}

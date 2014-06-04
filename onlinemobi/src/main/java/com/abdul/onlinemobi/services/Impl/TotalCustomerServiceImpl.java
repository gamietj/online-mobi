/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abdul.onlinemobi.services.Impl;

import com.abdul.onlinemobi.domain.Customer;
import com.abdul.onlinemobi.repository.CustomerRepository;
import com.abdul.onlinemobi.services.TotalCustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Khulsum
 */
@Service
public class TotalCustomerServiceImpl implements TotalCustomerService {
    
    
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer>getTotalCustomer(){
        return  customerRepository.findAll();
    }
    
    
}

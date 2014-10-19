/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


package com.abdul.onlinemobi.presentation.webservices.rest.controllers;

import com.onlinemobi.client.webservices.rest.resources.CustomerResource;
import com.abdul.onlinemobi.domain.Contact;
import com.abdul.onlinemobi.domain.Customer;
import com.abdul.onlinemobi.domain.CustomerAddress;
import com.abdul.onlinemobi.domain.Demographic;
import com.abdul.onlinemobi.domain.Name;
import com.abdul.onlinemobi.services.CustomerService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author user

@Controller
@RequestMapping("customerapi")
public class CustomerRestCooontroller {
    
    @Autowired 
    private CustomerService customerService;
    
    @ResponseBody
    @RequestMapping(value="customers", method = RequestMethod.GET)
    public List<CustomerResource> getCustomers(Model model){
        List<Customer> customers = customerService.getCustomers();
        List<CustomerResource> rs = new ArrayList<CustomerResource>();
        for(Customer customer : customers){
            CustomerResource c = new CustomerResource();
            CustomerAddress address = new CustomerAddress();
            address.(customer.getAddress().getPostalAddress());
            address.setStreetAddress(customer.getAddress().getStreetAddress());
            Demographic demo = new Demographic();
            demo.setGender(customer.getDemographic().getGender());
            demo.setRace(customer.getDemographic().getRace());
            Contact contact = new Contact();
            contact.setContactNumber(customer.getContact().getContactNumber());
            contact.setPhoneNumber(customer.getContact().getPhoneNumber());
            Name name = new Name();
            name.setFirstName(customer.getName().getFirstName());
            name.setLastName(customer.getName().getLastName());
            c.setAddress(address);
            c.setContact(contact);
            c.setCustomerNumber(customer.getCustomerNumber());
            c.setDemo(demo);
            c.setName(name);
            c.add(new Link("http://localhost:8081/onlinemobi/customerapi/customers"));
            rs.add(c);
            
            
        }
        
        return rs;
    }
    
}
*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abdul.onlinemobi.services;

import com.abdul.onlinemobi.app.conf.ConnectionConfig;
import com.abdul.onlinemobi.domain.Customer;
import com.abdul.onlinemobi.domain.Name;
import com.abdul.onlinemobi.repository.CustomerRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Khulsum
 */
public class FindCustomerServiceTest {
    
    public static ApplicationContext ctx;
    public FindCustomerService service;
    public CustomerRepository repo;
    
    
    public FindCustomerServiceTest() {
    }
    
    @Test
    public void FindCustomer(){
        Name name = new Name();
         name.setFirstName("Justin");
         name.setLastName("Drake");
        repo = ctx.getBean(CustomerRepository.class);
        service = ctx.getBean(FindCustomerService.class);
        
        Customer cust1 = new Customer.Builder("8704225065083")
                              .name(name)
                              .build();
          repo.save(cust1);
          Customer customer = service.getCustomer("8704225065083");
          Assert.assertEquals(customer.getName().getFirstName(),"Justin");
         
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
        
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}

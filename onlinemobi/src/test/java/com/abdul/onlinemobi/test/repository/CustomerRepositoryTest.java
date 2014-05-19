/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abdul.onlinemobi.test.repository;

import com.abdul.onlinemobi.app.conf.ConnectionConfig;
import com.abdul.onlinemobi.domain.Customer;
import com.abdul.onlinemobi.domain.Contact;
import com.abdul.onlinemobi.repository.CustomerRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Khulsum
 */
public class CustomerRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;

    private CustomerRepository customer;
   
    
    @Test
     public void createPerson() {
         customer = ctx.getBean(CustomerRepository.class);
         Customer c = new Customer.Builder("gamiet@gmail.com")
                  .firstname("B")
                 .lastnaname("K")
                 .build();
         customer.save(c);
         id = c.getId();
         Assert.assertNotNull(c);
         
     
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

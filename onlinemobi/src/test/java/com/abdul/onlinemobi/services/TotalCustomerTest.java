/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abdul.onlinemobi.services;

import com.abdul.onlinemobi.app.conf.ConnectionConfig;
import com.abdul.onlinemobi.domain.Customer;
import java.util.List;
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
public class TotalCustomerTest {
    
     public static ApplicationContext ctx;
     
     private TotalCustomerService service;
    
    public TotalCustomerTest() {
    }
     
    @Test
     public void TotalCustomerTest() {
        service = (TotalCustomerService) ctx.getBean(TotalCustomerTest.class);
         List<Customer> customer = service.getTotalCustomer();
         
         Assert.assertEquals(0, customer.size(), " Expect no People");
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
     }
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abdul.onlinemobi.repository;

import com.abdul.onlinemobi.app.conf.ConnectionConfig;
import com.abdul.onlinemobi.domain.Customer;
import com.abdul.onlinemobi.domain.CustomerAddress;
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
public class CustomerAddressRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;
    public CustomerAddressRepository repo;
    
    
    public CustomerAddressRepositoryTest() {
    }
    
    @Test 
    public void createCustAddress(){
        repo = ctx.getBean(CustomerAddressRepository.class);
        CustomerAddress c = new CustomerAddress.Builder("7 woodburry close")
                             .postalAddress("7 woodburry close")
                             .build();
        repo.save(c);
        id = c.getId();
        Assert.assertNotNull(c);         
     }
    @Test(dependsOnMethods = "createCustAddress")
     public void readCustAddress(){
     repo=ctx.getBean(CustomerAddressRepository.class);
     CustomerAddress c = repo.findOne(id);
     Assert.assertEquals(c.getPostalAddress(),"7 woodburry close");
     
    }
    @Test(dependsOnMethods = "readCustAddress")
    public void updateCustAddress(){
        repo = ctx.getBean(CustomerAddressRepository.class);
        CustomerAddress c = repo.findOne(id);
        CustomerAddress updateCustAddress = new CustomerAddress.Builder("7 woodburry close") 
                                            .customerAddress(c)
                                            .postalAddress("19 2nd Avenue")
                                            .build();
        repo.save(updateCustAddress);
        CustomerAddress newCustAddress = repo.findOne(id);
        Assert.assertEquals(newCustAddress.getPostalAddress(),"19 2nd Avenue");
        
    }
    @Test(dependsOnMethods = "updateCustAddress")
    public void deleteCustAddress(){
        repo = ctx.getBean(CustomerAddressRepository.class);
        CustomerAddress cust = repo.findOne(id);
        repo.delete(cust);
        
        CustomerAddress deletedCusAddress = repo.findOne(id);
        Assert.assertNull(deletedCusAddress);
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

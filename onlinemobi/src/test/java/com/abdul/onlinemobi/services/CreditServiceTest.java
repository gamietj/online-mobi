/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdul.onlinemobi.services;

import com.abdul.onlinemobi.app.conf.ConnectionConfig;
import com.abdul.onlinemobi.domain.CreditCard;
import com.abdul.onlinemobi.domain.Customer;
import com.abdul.onlinemobi.domain.Name;
import com.abdul.onlinemobi.repository.CreditCardRepository;
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
 * @author Lucrecia
 */
public class CreditServiceTest {
    
    public static ApplicationContext ctx;
    public CreditService service;
    public CreditCardRepository repo;
    
    public CreditServiceTest() {
    }
    //@Test
    public void FindCredit(){
        //private int creditNumber;
        
        CreditCard cNum = new CreditCard();
        repo = ctx.getBean(CreditCardRepository.class);
       CreditCard c = new CreditCard.Builder(12382)
                          .balance("200")
                          .expiryDate("2018")
                          .owner("clifford")
                          .build();
       repo.save(c);
         //cNum.setLastName("Drake");
        
          String customer = service.getCreditBalance(12382);
          Assert.assertEquals(customer,"200");
         
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

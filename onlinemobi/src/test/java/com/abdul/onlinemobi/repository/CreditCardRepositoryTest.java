/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abdul.onlinemobi.repository;

import com.abdul.onlinemobi.app.conf.ConnectionConfig;
import com.abdul.onlinemobi.domain.CreditCard;
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
public class CreditCardRepositoryTest {
    
    public CreditCardRepositoryTest() {
    }
    
    public static ApplicationContext ctx;
    private Long id;
    private CreditCardRepository repo;

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
   @Test
   public void createCreditCard(){
       repo = ctx.getBean(CreditCardRepository.class);
       CreditCard c = new CreditCard.Builder(12382)
                          .balance("200")
                          .expiryDate("2018")
                          .owner("clifford")
                          .build();
       repo.save(c);
       id = c.getId();
       Assert.assertNotNull(c);
   }
   
   @Test(dependsOnMethods = "createCreditCard")
   public void readCreditCard(){
       repo = ctx.getBean(CreditCardRepository.class);
       CreditCard c = repo.findOne(id);
       Assert.assertEquals(c.getCreditNumber(),12382);
   }
   @Test(dependsOnMethods = "readCreditCard")
   public void updateCreditCard(){
       repo = ctx.getBean(CreditCardRepository.class);
       CreditCard c = repo.findOne(id);
       CreditCard updateCreditCard = new CreditCard.Builder(12382)
                                      .creditCard(c)
                                      .balance("400")
                                      .build();
       
       repo.save(updateCreditCard);
       CreditCard newCreditCard = repo.findOne(id);
       Assert.assertEquals(newCreditCard.getBalance(), "400");
   }
   
   @Test(dependsOnMethods = "updateCreditCard")
   public void deleteCreditCard(){
       repo = ctx.getBean(CreditCardRepository.class);
       CreditCard c = repo.findOne(id);
       repo.delete(c);
       CreditCard deleteCreditCard = repo.findOne(id);
       Assert.assertNull(deleteCreditCard);
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

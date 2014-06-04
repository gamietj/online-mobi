/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abdul.onlinemobi.services;

import com.abdul.onlinemobi.app.conf.ConnectionConfig;
import com.abdul.onlinemobi.domain.MobilePhone;
import com.abdul.onlinemobi.repository.MobilePhoneRepository;
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
public class MobileQTYServiceTest {
    
    public static ApplicationContext ctx; 
    public MobileQTYService service;
    private MobilePhoneRepository mobilerepository;
    
    public MobileQTYServiceTest() {
    }
  
    @Test
        public void getAvailablePhone(){
        mobilerepository = ctx.getBean(MobilePhoneRepository.class);
        service = ctx.getBean(MobileQTYService.class);
        
        MobilePhone m1 = new MobilePhone.Builder("9320")
                         .qty(3).build();
     
        mobilerepository.save(m1);
        
        int qty = service.getAvailablePhone("9320");
        Assert.assertEquals(qty,3);
     }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    

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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}*/
}

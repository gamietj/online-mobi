/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abdul.onlinemobi.services;

import com.abdul.onlinemobi.app.conf.ConnectionConfig;
import com.abdul.onlinemobi.domain.MobilePhone;
import com.abdul.onlinemobi.repository.MobilePhoneRepository;
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
public class AvailableMobileServiceTest {
    
    public static ApplicationContext ctx;
    public AvailableMobileService service;
    private MobilePhoneRepository mobileRepository;
    
    @Test
    public void getAvailableMobiles(){
        mobileRepository = ctx.getBean(MobilePhoneRepository.class);
        service = ctx.getBean(AvailableMobileService.class);
        
        MobilePhone m1 = new MobilePhone.Builder("9320")
                         .qty(3).build();
        MobilePhone m2 = new MobilePhone.Builder("S4")
                         .qty(0).build();
        MobilePhone m3 = new MobilePhone.Builder("S5")
                         .qty(9).build();
        
        mobileRepository.save(m1);
        mobileRepository.save(m2);
        mobileRepository.save(m3);   
        
        List<MobilePhone>mobile = service.getAvailableMobiles();
        Assert.assertEquals(mobile.size(),2);
        
    }
    
    public AvailableMobileServiceTest() {
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

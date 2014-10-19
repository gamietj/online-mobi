/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abdul.onlinemobi.services;

import com.abdul.onlinemobi.app.conf.ConnectionConfig;
import com.abdul.onlinemobi.domain.MobilePhone;
import com.abdul.onlinemobi.repository.MobilePhoneRepository;
import static com.abdul.onlinemobi.repository.MobilePhoneRepositoryTest.ctx;
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
    private Long id1;
    private Long id2;
    private Long id3;
    
    @Test
    public void getAvailableMobiles(){
        mobileRepository = ctx.getBean(MobilePhoneRepository.class);
        service = ctx.getBean(AvailableMobileService.class);
        
        MobilePhone m1 = new MobilePhone.Builder("9320")
                         .make("Blackberry")
                         .qty(3).build();
                    
        MobilePhone m2 = new MobilePhone.Builder("S4")
                          .make("Samsung")
                         .qty(0).build();
        MobilePhone m3 = new MobilePhone.Builder("S5")
                         .make("Samsung")
                         .qty(9).build();
        
        mobileRepository.save(m1);
        mobileRepository.save(m2);
        mobileRepository.save(m3); 
        id1 = m1.getId();
        id2 = m2.getId();
        id3 = m3.getId();
        
        List<MobilePhone>mobile = service.getAvailableMobiles();
        Assert.assertEquals(mobile.size(),2);
        
    }

     @Test(dependsOnMethods = "getAvailableMobiles")
     public void deleteMobile(){
        mobileRepository = ctx.getBean(MobilePhoneRepository.class);
        MobilePhone mobile1 = mobileRepository.findOne(id1);
        MobilePhone mobile2 = mobileRepository.findOne(id2);
        MobilePhone mobile3 = mobileRepository.findOne(id3);
       
            
        mobileRepository.delete(mobile1);
        mobileRepository.delete(mobile2);
        mobileRepository.delete(mobile3);
        
        MobilePhone deletedMobile = mobileRepository.findOne(id1);
        Assert.assertNull(deletedMobile);
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

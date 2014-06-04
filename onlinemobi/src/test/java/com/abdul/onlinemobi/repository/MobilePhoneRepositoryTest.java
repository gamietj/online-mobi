/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abdul.onlinemobi.repository;

import com.abdul.onlinemobi.app.conf.ConnectionConfig;
import com.abdul.onlinemobi.domain.MobilePhone;
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
public class MobilePhoneRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;
    private MobilePhoneRepository repo;
    
    
    public MobilePhoneRepositoryTest() {
    }

    
    @Test
    public void createMobile(){
        repo = ctx.getBean(MobilePhoneRepository.class);
        MobilePhone mobi = new MobilePhone.Builder("9320")
                            .make("Samsung")
                            .qty(3)
                            .build();
        
        repo.save(mobi);
        id = mobi.getId();
        
        MobilePhone mobile = repo.findOne(id);
        Assert.assertNotNull(mobile);    
        
    }
    
    @Test(dependsOnMethods = "createMobile")
    public void readMobile(){
        repo = ctx.getBean(MobilePhoneRepository.class);
        MobilePhone mobile = repo.findOne(id);
        Assert.assertEquals(mobile.getModel(), "9320");
    }
    @Test(dependsOnMethods = "readMobile")
    public void updateMobile(){
        repo = ctx.getBean(MobilePhoneRepository.class);
        MobilePhone mobile = repo.findOne(id);
        MobilePhone updateMobile = new MobilePhone.Builder("9320")
                                .MobilePhone(mobile)
                                .make("Blackberry")
                                .build();
        repo.save(updateMobile);
        MobilePhone newMobile = repo.findOne(id);
        Assert.assertEquals(newMobile.getMake(), "Blackberry");
    }
    
    @Test(dependsOnMethods = "updateMobile")
    public void deleteMobile(){
        repo = ctx.getBean(MobilePhoneRepository.class);
        MobilePhone mobile = repo.findOne(id);
        repo.delete(mobile);
        MobilePhone deletedMobile = repo.findOne(id);
        Assert.assertNull(deletedMobile);
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

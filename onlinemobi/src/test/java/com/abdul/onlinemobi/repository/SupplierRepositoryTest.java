/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abdul.onlinemobi.repository;

import com.abdul.onlinemobi.app.conf.ConnectionConfig;
import com.abdul.onlinemobi.domain.Supplier;
import com.abdul.onlinemobi.domain.SupplierName;
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
public class SupplierRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;
    public SupplierRepository repo;
    
    
   
    @Test 
    public void createSupplier(){
        SupplierName name = new SupplierName();
        name.setSupplierName("Samsung");
        name.setRepresentative("Mark");
        
        repo = ctx.getBean(SupplierRepository.class);
        Supplier c = new Supplier.Builder("23423")
                            .supName(name)
                            .build();
        repo.save(c);
        id = c.getId();
        Assert.assertNotNull(c);         
     }
    @Test(dependsOnMethods = "createSupplier")
     public void readSupplier(){
     repo=ctx.getBean(SupplierRepository.class);
     Supplier s = repo.findOne(id);
     Assert.assertEquals(s.getSupname().getSupplierName(),"Samsung");
     
    }
    @Test(dependsOnMethods = "readSupplier")
    public void updateSupplier(){
        SupplierName name = new SupplierName();
        name.setSupplierName("Nokia");
    
        
        repo = ctx.getBean(SupplierRepository.class);
        Supplier c = repo.findOne(id);
        Supplier updateSupplier= new Supplier.Builder("23423")
                                    .supplier(c) 
                                    .supName(name)
                                    .build();
        repo.save(updateSupplier);
        Supplier newSupplier= repo.findOne(id);
        Assert.assertEquals(newSupplier.getSupname().getSupplierName(),"Nokia");
        
    }
    @Test(dependsOnMethods = "updateSupplier")
    public void deleteSupplier(){
        repo = ctx.getBean(SupplierRepository.class);
        Supplier s = repo.findOne(id);
        repo.delete(s);
        
        Supplier deletedSupplier = repo.findOne(id);
        Assert.assertNull(deletedSupplier);
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

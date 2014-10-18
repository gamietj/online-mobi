/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abdul.onlinemobi.repository;

import com.abdul.onlinemobi.app.conf.ConnectionConfig;
import com.abdul.onlinemobi.domain.OrderItem;
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
public class OrderItemRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;
    private OrderItemRepository repo;
    
    public OrderItemRepositoryTest() {
    }
    
    @Test
    public void createItem(){
        repo = ctx.getBean(OrderItemRepository.class);
        OrderItem item = new OrderItem.Builder(1)
                         .build();
        repo.save(item);
        id  = item.getId();
        OrderItem i = repo.findOne(id);
        Assert.assertNotNull(i);
     }
    
     @Test (dependsOnMethods = "createItem")
     public void readItem(){
         repo = ctx.getBean(OrderItemRepository.class);
         OrderItem i = repo.findOne(id);
         Assert.assertEquals(i.getQuantity(), 1);
         
     }
     @Test (dependsOnMethods ="readItem")
     public void updateItem(){
         repo=ctx.getBean(OrderItemRepository.class);
         OrderItem i = repo.findOne(id);
         OrderItem updateitem = new OrderItem.Builder(3)
                                .id(id)
                                .build();
         repo.save(updateitem);
         OrderItem newItem = repo.findOne(id);
         Assert.assertEquals(newItem.getQuantity(), 3);
                 
     }
     
     @Test(dependsOnMethods = "updateItem")
     public void deleteItem(){
         repo = ctx.getBean(OrderItemRepository.class);
         OrderItem i = repo.findOne(id);
         repo.delete(i);
         OrderItem deletedItem = repo.findOne(id);
         Assert.assertNull(deletedItem);
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

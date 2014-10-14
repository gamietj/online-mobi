/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abdul.onlinemobi.repository;

import com.abdul.onlinemobi.app.conf.ConnectionConfig;
import com.abdul.onlinemobi.domain.Orders;
import java.util.Date;
import javax.persistence.criteria.Order;
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
public class OrderRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;
    private OrderRepository repo;
    
    
    public OrderRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createOrder(){
        Date d = new Date();
        repo = ctx.getBean(OrderRepository.class);
        Orders order = new Orders.Builder(12345)
                        .invNumber("S002")
                        .build();
        
        repo.save(order);
        id = order.getId();
        Orders orders = repo.findOne(id);
        Assert.assertNotNull(orders);
                                            
    }
    @Test(dependsOnMethods = "createOrder")
       public void readOrder(){
        repo = ctx.getBean(OrderRepository.class);
        Orders order = repo.findOne(id);
        Assert.assertEquals(order.getOrderNumber(),12345);
        
    }
       @Test(dependsOnMethods = "readOrder")
       public void updateOrder(){
           repo = ctx.getBean(OrderRepository.class);
           Orders order = repo.findOne(id);
           Orders updateOrder = new Orders.Builder(12345)
                             .order(order)
                             .invNumber("S003")
                             .build();
          repo.save(updateOrder);
          Orders newOrder = repo.findOne(id);
          Assert.assertEquals(newOrder.getInvNumber(), "S003");
       }
       
       @Test(dependsOnMethods = "updateOrder")
       public void deleteOrder(){
            repo = ctx.getBean(OrderRepository.class);
            Orders order = repo.findOne(id);
            repo.delete(order);
            Orders deleteOrder = repo.findOne(id);
            Assert.assertNull(deleteOrder);
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

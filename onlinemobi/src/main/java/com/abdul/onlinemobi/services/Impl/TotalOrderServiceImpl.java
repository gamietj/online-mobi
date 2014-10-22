/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdul.onlinemobi.services.Impl;

import com.abdul.onlinemobi.domain.OrderItem;
import com.abdul.onlinemobi.domain.Orders;
import com.abdul.onlinemobi.repository.OrderRepository;
import com.abdul.onlinemobi.services.TotalOrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author BKLAAS1
 */
public class TotalOrderServiceImpl implements TotalOrderService {
   @Autowired
    OrderRepository orderRepo;
    public List<Orders>getAllOrders() {
    return  orderRepo.findAll();
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdul.onlinemobi.services.Impl;

import com.abdul.onlinemobi.domain.Orders;
import com.abdul.onlinemobi.repository.OrderRepository;
import com.abdul.onlinemobi.services.OrderListServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lucrecia
 */
@Service
public class OrderListServiceImpl implements OrderListServices{
    
    @Autowired
    OrderRepository orderRepo;
    @Override
    public List<Orders>getAllOrders() {
    return  orderRepo.findAll();
    }
}

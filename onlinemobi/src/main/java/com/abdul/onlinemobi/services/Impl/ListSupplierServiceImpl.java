/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abdul.onlinemobi.services.Impl;

import com.abdul.onlinemobi.domain.Supplier;
import com.abdul.onlinemobi.repository.SupplierRepository;
import com.abdul.onlinemobi.services.ListSupplierService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Khulsum
 */
@Service
public class ListSupplierServiceImpl implements ListSupplierService{

    
    @Autowired
    SupplierRepository supplierRepo;
    @Override
    public List<Supplier> getAllSuppliers() {
    return  supplierRepo.findAll();
    }
    
}

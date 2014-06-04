/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abdul.onlinemobi.services.Impl;

import com.abdul.onlinemobi.domain.MobilePhone;
import com.abdul.onlinemobi.repository.MobilePhoneRepository;
import com.abdul.onlinemobi.services.MobileQTYService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Khulsum
 */
@Service
public class MobileQTYServiceImpl implements MobileQTYService {
    
    @Autowired
    private MobilePhoneRepository mobilephonerepository;

    @Override
        public int getAvailablePhone(String model) {
        List<MobilePhone> allMobiles = mobilephonerepository.findAll();
        int qty = 0;
                
            for (MobilePhone mobile: allMobiles) {
            if (mobile.getModel().equals(model)) {
                qty = mobile.getQty();
            }
        }
        return qty;
    }
    
}

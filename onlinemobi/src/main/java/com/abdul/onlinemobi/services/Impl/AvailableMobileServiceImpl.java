/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abdul.onlinemobi.services.Impl;

import com.abdul.onlinemobi.domain.MobilePhone;
import com.abdul.onlinemobi.repository.MobilePhoneRepository;
import com.abdul.onlinemobi.services.AvailableMobileService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Khulsum
 */
@Service
public class AvailableMobileServiceImpl implements AvailableMobileService {

    
    @Autowired
    MobilePhoneRepository mobilerepository;
    
    @Override
        public List<MobilePhone> getAvailableMobiles() {
        List<MobilePhone> mobiles = new ArrayList<>();
        List<MobilePhone> allMobiles = mobilerepository.findAll();
                
        for (MobilePhone mobile: allMobiles) {
            if (mobile.getQty() > 0) {
                mobiles.add(mobile);
            }
        }
        return mobiles;
         
       
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abdul.onlinemobi.services;

import com.abdul.onlinemobi.domain.MobilePhone;
import java.util.List;

/**
 *
 * @author Khulsum
 */
public interface AvailableMobileService {
    
    public List<MobilePhone> getAvailableMobiles();
    
}

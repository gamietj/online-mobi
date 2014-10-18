/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdul.onlinemobi.services.Impl;

import com.abdul.onlinemobi.domain.CreditCard;
import com.abdul.onlinemobi.repository.CreditCardRepository;
import com.abdul.onlinemobi.services.CreditService;
import java.util.List;
//import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lucrecia
 */
@Service
public class CreditServiceImpl implements CreditService{

    @Autowired
    CreditCardRepository creditcardrepository;
    
       @Override
       public String getCreditBalance(int creditNumber) {
        
        CreditCard c = new CreditCard();
        List<CreditCard> allcards = creditcardrepository.findAll();
        String balance="";       
        for (CreditCard cards: allcards) {
            if(cards.getCreditNumber()==creditNumber) {
                
                balance = cards.getBalance();
                
           }
        
        }
        return balance;
      
}
}
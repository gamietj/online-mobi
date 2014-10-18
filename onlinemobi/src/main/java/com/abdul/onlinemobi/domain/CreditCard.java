/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abdul.onlinemobi.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Khulsum
 */
@Entity
public class CreditCard implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int creditNumber;
    private String expiryDate;
    private String owner;
    private String balance;
    
    private CreditCard(Builder builder){
        id=builder.id;
        creditNumber=builder.creditNumber;
        expiryDate=builder.expiryDate;
        owner=builder.owner;
        balance=builder.balance;
        
    }
    
        public static class Builder{
        
        private Long id;
        private int creditNumber;
        private String expiryDate;
        private String owner;
        private String balance;
        
        public Builder(int creditNumber){
            this.creditNumber = creditNumber;
        }
        
        public Builder id(Long value){
            id = value;
            return this;
        }
        
        public Builder expiryDate(String value){
            expiryDate = value;
            return this;
        }
        public Builder owner(String value){
            owner = value;
            return this;
        }
        
        public Builder balance(String value){
            balance = value;
            return this;
        }
        
        public Builder creditCard(CreditCard creditCard){
            id = creditCard.getId();
            creditNumber = creditCard.getCreditNumber();
            expiryDate = creditCard.getExpiryDate();
            owner = creditCard.getOwner();
            balance= creditCard.getBalance();
            return this;
        }
        
        public CreditCard build(){
            return new CreditCard(this);
        }
             
        
    }
    public CreditCard(){
        
    }

    public int getCreditNumber() {
        return creditNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getOwner() {
        return owner;
    }

    public String getBalance() {
        return balance;
    }
   
   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CreditCard)) {
            return false;
        }
        CreditCard other = (CreditCard) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abdul.onlinemobi.domain.CreditCard[ id=" + id + " ]";
    }
    
}

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
public class MobilePhone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String make;
    private String model;
    private String description;
    private int qty;
    
    
    private MobilePhone(Builder builder){
        id=builder.id;
        make=builder.make;
        model=builder.model;
        qty=builder.qty;
        
    }
    public MobilePhone(){}
    
    public static class Builder{
        private Long id;
        private String make;
        private String model;
        private String description;
        private int qty;
        
        public Builder(String model){
            this.model = model;
        }
        public Builder id(Long value){
            id  = value;
            return this;
        }
        public Builder make(String value){
            make = value;
            return this;
        }
        public Builder qty(int value){
            qty = value;
            return this;
        }
        
        public Builder MobilePhone(MobilePhone mobilephone){
            id=mobilephone.getId();
            make=mobilephone.getMake();
            model=mobilephone.getMake();
            qty=mobilephone.getQty();
            return this;
        }
        
        public MobilePhone build(){
            return new MobilePhone(this);
        }
               
    
    
    }
    public Long getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getDescription() {
        return description;
    }

    public int getQty() {
        return qty;
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
        if (!(object instanceof MobilePhone)) {
            return false;
        }
        MobilePhone other = (MobilePhone) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abdul.onlinemobi.domain.MobilePhone[ id=" + id + " ]";
    }
    
}

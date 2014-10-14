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
public class SupplierAddress implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String streetAddress;
    private String postalAddress;

       private SupplierAddress(Builder builder){
           id=builder.id;
           streetAddress=builder.streetAddress;
           postalAddress=builder.postalAddress;
       }
       
       public SupplierAddress(){
           
       }   
    public static class Builder{
        private Long id;
        private String streetAddress;
        private String postalAddress;
        
        public Builder(String streetAddress){
            this.streetAddress = streetAddress;
           }
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder postalAddress(String postal){
            this.postalAddress = postal;
            return this;
        }
        
        public Builder customerAddress(SupplierAddress customerAddress){
            id= customerAddress.getId();
            streetAddress  = customerAddress.getStreetAddress();
            postalAddress= customerAddress.getPostalAddress();
            return this;
        
        }
           public SupplierAddress build(){
            return new SupplierAddress(this);
        }
        
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getPostalAddress() {
        return postalAddress;
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
        if (!(object instanceof SupplierAddress)) {
            return false;
        }
        SupplierAddress other = (SupplierAddress) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abdul.onlinemobi.domain.CustomerAddress[ id=" + id + " ]";
    }
    
}

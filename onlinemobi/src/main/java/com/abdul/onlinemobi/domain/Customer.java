/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abdul.onlinemobi.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Abdul
 */
@Entity
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String customerNumber;
    @Embedded
    private Name name;
    @Embedded
    private Contact contact;
   
    
    @OneToOne
    private CustomerAddress address;
    
    @Embedded
    private Demographic demographic;
    @OneToMany
    List<Orders> order;
    @OneToMany
    List<CreditCard>creditCard;
    private String custId;
    
    public Customer(){
        
    }
    
    private Customer(Builder builder){
        id = builder.id;
        customerNumber = builder.customerNumber;
        name = builder.name;
        contact = builder.contact;
        address = builder.address;
        demographic = builder.demographic;
        order = builder.order;
        creditCard = builder.creditCard;
        custId = builder.custId;
        
    }
    
    
    public static class Builder{
        
        private Long id;
        private String customerNumber;
        private Name name; 
        private Contact contact;
        private CustomerAddress address;
        private Demographic demographic;
        List<Orders> order;
        List<CreditCard>creditCard;
        private String custId;
        
        public Builder(String customerNumber){
            this.customerNumber = customerNumber;
        }  
        
        public Builder id(Long value){
            id = value;
            return this;
        }
        
        public Builder name(Name value)
        {
            name = value;
            return this;
        }
        public Builder contact(Contact value){
            contact = value;
            return this;
        }
        
        public Builder address(CustomerAddress value){
            address = value;
            return this;
        }
        public Builder demographic(Demographic value){
            demographic = value;
            return this;
        }
        
        public Builder order(List<Orders> value){
            order = value;
            return this;
            
        }
        public Builder creditCard(List<CreditCard> value){
            creditCard = value;
            return this;
            
        }
        public Builder custId(String value){
            custId =  value;
            return this;
        }
        
        public Builder Customer(Customer value){
            id = value.getId();
            customerNumber = value.getCustomerNumber();
            name = value.getName();
            contact = value.getContact();
            address = value.getAddress();
            demographic = value.getDemographic();
            order = value.getOrder();
            creditCard = value.getCreditCard();
            custId = value.getCustId();
            
            return this;
        }
        
        public Customer build(){
            return new Customer(this);
        }
     
        
    }
    
    public Contact getContact() {
        return contact;
    }
    public String getCustId(){
        return custId;
    }
    
      public CustomerAddress getAddress() {
        return address;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public Name getName() {
        return name;
    }

    public Demographic getDemographic() {
        return demographic;
    }

    public List<Orders> getOrder() {
        return order;
    }

    public List<CreditCard> getCreditCard() {
        return creditCard;
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
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abdul.onlinemobi.domain.Customer[ id=" + id + " ]";
    }
    
}

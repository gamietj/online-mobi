/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abdul.onlinemobi.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Khulsum
 */
@Entity
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;
     @Column(name = "quantity")
     private int quantity;
     @OneToOne
     private MobilePhone mobilephone;

       
     public OrderItem(){
     }
     
    public static class Builder{
     
      private Long id;
    
      private int quantity;
      private MobilePhone mobilephone;
      
      
       public Builder(int quantity){
            this.quantity = quantity;
        }
       
       
      public Builder id  (Long id){
          this.id = id;
          return this;
      }
     
      public Builder mobilphone(MobilePhone value)
      {              
         mobilephone = value;
         return this;
      }
      
      public Builder OrderItem(OrderItem orderitem){
          id = orderitem.getId();
          quantity = orderitem.getQuantity();
          mobilephone = orderitem.getMobilephone();
          return this;
      }
      
      public OrderItem build(){
          return new OrderItem(this);
      }
    
    }
    private OrderItem(Builder builder){
        id = builder.id;
        quantity = builder.quantity;
        mobilephone = builder.mobilephone;
        
    }
    
    
    public Long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public MobilePhone getMobilephone() {
        return mobilephone;
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
        if (!(object instanceof OrderItem)) {
            return false;
        }
        OrderItem other = (OrderItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abdul.onlinemobi.domain.OrderItem[ id=" + id + " ]";
    }
    
}

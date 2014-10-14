/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abdul.onlinemobi.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author 210083832
 */
@Entity
public class CustomerInvoice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date invoiceDate;
    private BigDecimal orderAmount;
    private String invoiceStatus;
    @OneToOne 
    private Orders order;
    
    public CustomerInvoice(){
        
    }
    
    private CustomerInvoice(Builder builder){
        id = builder.id;
        invoiceDate = builder.invoiceDate;
        orderAmount = builder.orderAmount;
        invoiceStatus = builder.invoiceStatus;
        order = builder.order;
        
    }
    
    
    
    public static class Builder{
      
    private Long id;
    private Date invoiceDate;
    private BigDecimal orderAmount;
    private String invoiceStatus;
    private Orders order;
    
    
    
    
    public Builder(BigDecimal orderAmount){
         this.orderAmount = orderAmount;
     }
    public Builder id (Long value){
        id = value;
        return this;       
    }
    
    public Builder invoiceDate(Date value){
        invoiceDate = value;
        return this;
    }
    
    public Builder orderAmount(BigDecimal value){
        orderAmount = value;
        return this;
    }
    public Builder invoiceStatus(String value){
        invoiceStatus = value;
        return this;
    }
    public Builder order(Orders value){
        order = value;
        return this;
    }
    
    public Builder CustomerInvoice(CustomerInvoice value)
    {
        id = value.getId();
        invoiceDate = value.getInvoiceDate();
        orderAmount = value.getOrderAmount();
        invoiceStatus = value.getInvoiceStatus();
        order = value.getOrder();
        
        return this;
     }
    public CustomerInvoice build(){
        return new CustomerInvoice(this);
    }
    
}

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    public Orders getOrder() {
        return order;
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
        if (!(object instanceof CustomerInvoice)) {
            return false;
        }
        CustomerInvoice other = (CustomerInvoice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.startup.onlinemobi.domain.CustomerInvoice[ id=" + id + " ]";
    }
    
}

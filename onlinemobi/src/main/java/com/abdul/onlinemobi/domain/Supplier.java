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
 * @author Abdul
 */
@Entity
public class Supplier implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String supname;
    private String supaddress;
    private String supcontact;
    private String repname;
    private String repcontact;
    
    public static class Builder{
        
        private Long id;
        private String supname;
        private String supaddress;
        private String supcontact;
        private String repname;
        private String repcontact;
        
        public Builder(String supname){
            this.supname = supname;
        }
        
        public Builder id(Long value){
            id = value;
            return this;
        }
        
        public Builder supaddress(String value){
            supaddress = value;
            return this;
         }
        
        public Builder supcontact(String value){
            supcontact = value;
            return this;
        }
        public Builder repname(String value){
            repname = value;
            return this;
        }
        public Builder repcontact(String value){
            repcontact = value;
            return this;
        }
        
        public Builder supplier(Supplier supplier){
            id = supplier.getId();
            supname = supplier.getSupname();
            supaddress = supplier.getSupaddress();
            supcontact = supplier.getSupcontact();
            repname = supplier.getRepname();
            repcontact = supplier.getRepcontact();
            return this;
        }
        
        public Supplier build(){
            return new Supplier(this);
        }
        
    
    }
    private Supplier(Builder builder){
        id = builder.id;
        supname = builder.supname;
        supaddress=builder.supaddress;
        supcontact =builder.supaddress;
        repname = builder.repname;
        repcontact = builder.repcontact;
        
    }
      
    public String getSupname() {
        return supname;
    }

    public String getSupaddress() {
        return supaddress;
    }

    public String getSupcontact() {
        return supcontact;
    }

    public String getRepname() {
        return repname;
    }

    public String getRepcontact() {
        return repcontact;
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
        if (!(object instanceof Supplier)) {
            return false;
        }
        Supplier other = (Supplier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abdul.onlinemobi.domain.Supplier[ id=" + id + " ]";
    }
    
}

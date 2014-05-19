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
    
    private String firstname;
    private String lastname;
    private int age;
    @Column(unique = true)
    private String email;
    @Embedded
    private Contact contact;
  
    //@OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "customer_id")
    //List<Order> order;
    
    //@OneToMany
   // @JoinColumn(name = "customer_id")
    //List<CreditCard> creditcard;
  
    private Customer(Builder builder) {
        id= builder.id;
        firstname = builder.firstname;
        lastname=builder.lastname;
        age = builder.age;
        email = builder.email;
        contact = builder.contact;
        //order = builder.order;
        //creditcard = builder.creditcard;
       }
    
    public Customer() {
        }
    
    public static class Builder {

        private Long id;
        private String firstname;
        private String lastname;
        private int age;
        private String email;
        private Contact contact;
        //List<Order> order;
        //List<CreditCard> creditcard;

        public Builder(String email) {
            this.email = email;
        }

        public Builder id(Long value) {
            id = value;
            return this;
        }

        public Builder firstname(String value) {
            firstname = value;
            return this;
        }

        public Builder lastnaname(String value) {
            lastname = value;
            return this;
        }

        public Builder age(int value) {
            age = value;
            return this;
        }

        public Builder contact(Contact value) {
            contact = value;
            return this;
        }

       /* public Builder order(List<Order> value) {
            order = value;
            return this;
        }

        public Builder creditcard(List<CreditCard> value) {
            creditcard = value;
            return this;
        }*/
        public Builder customer(Customer customer){
            id = customer.getId();
            firstname = customer.getFirstname();
            lastname = customer.getLastname();
            age = customer.getAge();
            email = customer.getEmail();
            //order = customer.getOrder();
            //creditcard = customer.getCreditCard();
            contact = customer.getContact();
            return this;
            
        }
        
         public Customer build(){
            return new Customer(this);
        }
        
    }
    
   /* public List<CreditCard> getCreditCard() {
        return creditcard;
    }*/

    public int getAge() {
        return age;
    }
    
   /* public List<Order> getOrder() {
        return order;
    }*/

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public Contact getContact() {
        return contact;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
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

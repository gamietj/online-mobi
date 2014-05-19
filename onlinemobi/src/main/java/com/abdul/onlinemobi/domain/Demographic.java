/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abdul.onlinemobi.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Khulsum
 */
@Embeddable 
public class Demographic implements Serializable {
    
    String gender;
    String race;
    String date;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
}

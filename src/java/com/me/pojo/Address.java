/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.pojo;

/**
 *
 * @author Administrator
 */
public class Address {
        private int addressID;
        private String street1;
        private String street2;
        private String city;
        private String state;
        private int zip;
        private int userID;

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }



    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

   
    @Override
    public String toString() {
        return street1 +" "+ street2+" "+city+" "+state;
    }
    
    
}

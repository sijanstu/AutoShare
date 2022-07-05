package com.sijanstu.autoshare.entity;

/**
 *
 * @author Sijan
 */
public class User {
    String username;
    String password;
    String CRN;
    String PIN;
    String kitta;
    String security;
    int company;

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String Security) {
        this.security = Security;
    }

    public String getKitta() {
        return kitta;
    }

    public void setKitta(String kitta) {
        this.kitta = kitta;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCRN() {
        return CRN;
    }

    public void setCRN(String CRN) {
        this.CRN = CRN;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public int getCompany() {
        return company;
    }

    public void setCompany(int company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", password=" + password + ", CRN=" + CRN + ", PIN=" + PIN + ", kitta=" + kitta + ", security=" + security + ", company=" + company + '}';
    }





    
}

package com.sijanstu.autoshare.version3.dto;

import com.sijanstu.autoshare.version3.dto.ipo.Bank;
import com.sijanstu.autoshare.version3.dto.portfolio.Portfolio;
import com.sijanstu.autoshare.version3.exceptions.CredentialsException;
import com.sijanstu.autoshare.version3.httprequests.Request;
import lombok.*;

import java.io.IOException;
import java.io.Serializable;

@Data
public class User implements Serializable {
    private String token;
    private Portfolio portfolio;
    private Bank[] banks;
    private String username;
    private String password;
    private Integer branch;
    private String address;
    private String boid;
    private String clientCode;
    private String contact;
    private String createdApproveDate;
    private String createdApproveDateStr;
    private String customerTypeCode;
    private String demat;
    private String dematExpiryDate;
    private String email;
    private String expiredDate;
    private String expiredDateStr;
    private String gender;
    private String id;
    private String imagePath;
    private String meroShareEmail;
    private String name;
    private String passwordChangeDate;
    private String passwordChangedDateStr;
    private String passwordExpiryDate;
    private String passwordExpiryDateStr;
    private String profileName;
    private String renewedDate;
    private String renewedDateStr;
    private String status;
}
package com.sijanstu.autoshare.version3.dto;

import com.sijanstu.autoshare.version3.dto.ipo.Bank;
import com.sijanstu.autoshare.version3.dto.portfolio.Portfolio;
import com.sijanstu.autoshare.version3.httprequests.Request;
import lombok.Data;

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

    //ovveride toString method
    @Override
    public String toString() {
        return "name: " + name + "\n"
                + "username: " + username + "\n"
                + "password: " + password + "\n"
                + "branch: " + branch + "\n"
                + "address: " + address + "\n"
                + "boid: " + boid + "\n"
                + "clientCode: " + clientCode + "\n"
                + "contact: " + contact + "\n"
                + "createdApproveDate: " + createdApproveDate + "\n"
                + "createdApproveDateStr: " + createdApproveDateStr + "\n"
                + "customerTypeCode: " + customerTypeCode + "\n"
                + "demat: " + demat + "\n"
                + "dematExpiryDate: " + dematExpiryDate + "\n"
                + "email: " + email + "\n"
                + "expiredDate: " + expiredDate + "\n"
                + "expiredDateStr: " + expiredDateStr + "\n"
                + "gender: " + gender + "\n"
                + "id: " + id + "\n"
                + "imagePath: " + imagePath + "\n"
                + "meroShareEmail: " + meroShareEmail + "\n"
                + "name: " + name + "\n"
                + "passwordChangeDate: " + passwordChangeDate + "\n"
                + "passwordChangedDateStr: " + passwordChangedDateStr + "\n"
                + "passwordExpiryDate: " + passwordExpiryDate + "\n"
                + "passwordExpiryDateStr: " + passwordExpiryDateStr + "\n"
                + "profileName: " + profileName + "\n"
                + "renewedDate: " + renewedDate + "\n"
                + "renewedDateStr: " + renewedDateStr + "\n"
                + "status: " + status + "\n";
    }
    //get token without validating
    public String getTokenW() {
        return token;
    }
    //get token
    public String getToken() {
        if (isTokenValid()) {
            return token;
        } else {
            try {
                return new Request(this).getToken();
            } catch (Exception e) {
                return null;
            }
        }
    }

    //is token valid
    public boolean isTokenValid() {
        Request request = new Request(this);
        return request.isTokenValid();
    }
}

package com.sijanstu.autoshare.version3.ui.ipoui.iporesult;

import lombok.Data;

import java.util.ArrayList;
@Data
class Body{
    public ArrayList<CompanyShareList> companyShareList;
    public CaptchaData captchaData;
}
@Data
public class Root{
    public boolean success;
    public String message;
    public Body body;
}


package com.sijanstu.autoshare.version3.ui.ipoui.iporesult;

import lombok.Data;

import java.util.ArrayList;
@Data
class Body{
    public ArrayList<CompanyShareLists> companyShareList;
    public CaptchaData captchaData;
}
class CompanyShareLists{
    public int id;
    public String name;
    public String scrip;
    public boolean isFileUploaded;
}
@Data
public class Root{
    public boolean success;
    public String message;
    public Body body;
}


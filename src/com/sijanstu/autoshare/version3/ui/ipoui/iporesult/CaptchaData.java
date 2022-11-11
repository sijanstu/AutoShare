package com.sijanstu.autoshare.version3.ui.ipoui.iporesult;

import lombok.Data;

@Data
public class CaptchaData {
    public String captcha;
    public String audioCaptcha;
    public String captchaIdentifier;
    public Object blob;
    public Integer solution;
}

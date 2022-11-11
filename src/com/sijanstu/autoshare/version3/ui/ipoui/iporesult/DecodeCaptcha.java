package com.sijanstu.autoshare.version3.ui.ipoui.iporesult;

import com.google.gson.Gson;
import com.sijanstu.autoshare.version3.Config;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DecodeCaptcha {
    private static final File captchaFile = new File("download.wav");

    public DecodeCaptcha(String base64Audio) {
        try {
            byte[] decodedBytes = java.util.Base64.getDecoder().decode(base64Audio);
            FileOutputStream fos = new FileOutputStream(captchaFile);
            fos.write(decodedBytes);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DecodeCaptcha() {

    }

    public String decode() throws IOException {
        String Url = "https://english-stt.herokuapp.com/stt_api/";
        String result = "";
        //get response from server sending file
        Document doc = Jsoup.connect(Url)
                .data("file", captchaFile.getName(), new FileInputStream(captchaFile))
                .ignoreContentType(true)
                .post();
        result = doc.body().text();
        Transcription transcription = new Gson().fromJson(result, Transcription.class);
        return transcription.text;
    }

    //main method for testing
    public static void main(String[] args) throws IOException {
        DecodeCaptcha decodeCaptcha = new DecodeCaptcha();
        while (true) {
            CaptchaData captchaData = decodeCaptcha.getBestCaptcha();
            String payload = String.format(Config.IPOCheckPayload, "52", "1301090001912748", captchaData.getSolution(), captchaData.getCaptchaIdentifier());
            Connection.Response response = Jsoup.connect(Config.IPO_CHECK_URL)
                    .method(Connection.Method.POST)
                    .ignoreContentType(true)
                    .headers(Config.CheckHEADERS)
                    .requestBody(payload)
                    .execute();
            System.out.println(response.body());
            if (response.statusCode() == 200) {
                break;
            }
        }

    }

    CaptchaData getBestCaptcha() throws IOException {
        int length = 0;
        int number = 0;
        CaptchaData captchaData = null;
        while (length != 5) {
            captchaData = getCaptcha();
            number = getNumberFromString(decode());
            length = String.valueOf(number).length();
            System.out.println("reloading captcha");
        }
        captchaData.setSolution(number);
        return captchaData;
    }

    CaptchaData getCaptcha() throws IOException {
        String url = "https://iporesult.cdsc.com.np/result/companyShares/fileUploaded";
        Document doc = Jsoup.connect(url)
                .ignoreContentType(true)
                .maxBodySize(999999999)
                .get();
        Root root = new Gson().fromJson(doc.body().text(), Root.class);
        byte[] decodedBytes = java.util.Base64.getDecoder().decode(root.body.captchaData.audioCaptcha);
        FileOutputStream fos = new FileOutputStream(captchaFile);
        fos.write(decodedBytes);
        fos.close();
        return root.body.captchaData;
    }

    int getNumberFromString(String str) {
        System.out.println(str);
        //get all words
        String[] arr = str.split(" ");
        StringBuilder number = new StringBuilder();
        for (String s : arr) {
            if (s.equals("")) continue;
            switch (s.trim()) {
                case "one":
                    number.append("1");
                    break;
                case "two":
                    number.append("2");
                    break;
                case "three":
                    number.append("3");
                    break;
                case "four":
                    number.append("4");
                    break;
                case "five":
                    number.append("5");
                    break;
                case "six":
                    number.append("6");
                    break;
                case "seven":
                    number.append("7");
                    break;
                case "eight":
                    number.append("8");
                    break;
                case "nine":
                    number.append("9");
                    break;
                case "zero":
                    number.append("0");
                    break;
                case "oh":
                    number.append("0");
                    break;
                case "for":
                    number.append("4");
                    break;
                case "to":
                    number.append("2");
                    break;
                case "too":
                    number.append("2");
                    break;
                case "be":
                    number.append("3");
                    break;
                case "are":
                    number.append("4");
                    break;
                case "you":
                    number.append("2");
                    break;
                case "see":
                    number.append("3");
                    break;
                case "sea":
                    number.append("3");
                    break;
                case "bee":
                    number.append("3");
                    break;
                case "ivor":
                    number.append("4");
                    break;
                case "at":
                    number.append("8");
                    break;
                case "ate":
                    number.append("8");
                    break;
                case "on":
                    number.append("1");
                    break;
                case "in":
                    number.append("1");
                    break;
                case "and":
                    number.append("1");
                    break;
                case "any":
                    number.append("1");
                    break;
                case "as":
                    number.append("1");
                    break;
                case "several":
                    number.append("7");
                    break;
                case "free":
                    number.append("3");
                    break;
                case "the":
                    number.append("3");
                    break;
                case "or":
                    number.append("4");
                    break;
                case "sets":
                    number.append("6");
                    break;
                case "eh":
                    number.append("8");
                    break;
                case "find":
                    number.append("5");
                    break;
                default:
                    break;
            }
        }
        if (number.toString().equals("")) return 0;
        return Integer.parseInt(number.toString());
    }
}
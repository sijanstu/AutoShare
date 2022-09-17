package com.sijanstu.autoshare;

import com.microsoft.playwright.Page;
import com.sijanstu.autoshare.browser.Chromium;
import com.sijanstu.autoshare.gui.MainUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * @author Sijan
 */
public class AutoShare {
    public static List<String> companiesList;

    public static void main(String[] args) throws IOException {
        companiesList = new ArrayList<>();
        getCompanyList();
        MainUI.mainUI();
    }

    static void getCompanyList() {
        System.out.println("Getting company list...");
        Page page=Chromium.startBrowser("https://meroshare.cdsc.com.np/#/login", Boolean.FALSE);
        //page.navigate("https://meroshare.cdsc.com.np/#/login", new Page.NavigateOptions());
        Document dropdown = Jsoup.parse(page.innerHTML("#selectBranch > select"));
        Elements options = dropdown.getElementsByTag("option");
        options.forEach((option) -> companiesList.add(option.text()));
        page.close();
    }
}

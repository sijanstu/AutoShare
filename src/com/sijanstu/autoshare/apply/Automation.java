package com.sijanstu.autoshare.apply;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.SelectOption;
import com.sijanstu.autoshare.browser.Chromium;
import com.sijanstu.autoshare.entity.Company;
import com.sijanstu.autoshare.entity.User;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import com.sijanstu.autoshare.gui.MainUI;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * @author Sijan
 */
public class Automation {
   public static Page page;
    public static Object applyIPO(User user, int companyToApply, boolean checkingIPO, boolean verifying) throws Exception {
        String response=null;
        //playwright = Playwright.create();
        //BrowserType chromium = playwright.chromium();
       // BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions().setHeadless(!MainUI.showBox.isSelected());
       // launchOptions.slowMo = 65.5;
       // Browser browser = chromium.launch(launchOptions.setChannel("chrome"));
       // BrowserContext context = browser.newContext();
         page = Chromium.startBrowser("https://meroshare.cdsc.com.np/#/login", !MainUI.showBox.isSelected());
        //clear cache
        //page.navigate("https://meroshare.cdsc.com.np/#/login", new Page.NavigateOptions());
        page.onPageError((pageError) -> {
            //show dialog box with error message
            JDialog dialog = new JDialog();
            dialog.setTitle("Error");
            dialog.setSize(300, 300);
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.add(new JLabel(pageError));
        });
        page.navigate("https://meroshare.cdsc.com.np");
        page.waitForLoadState(LoadState.NETWORKIDLE);
        page.click("#selectBranch");
        page.keyboard().type(user.getSecurity());
        page.fill("body > span > span > span.select2-search.select2-search--dropdown > input", user.getSecurity());
        // page.type("#selectBranch", user.getSecurity());
        page.keyboard().press("Enter");
        //enter username
        page.click("#username");
        page.type("#username", user.getUsername());
        //enter password
        page.click("#password");
        page.type("#password", user.getPassword());
        //click login
        page.click("body > app-login > div > div > div > div > div > div > div.card.login-app--card > div > form > div > div:nth-child(4) > div > button");
        //change url
        page.waitForLoadState();
        if (page.isVisible("#toast-container > div")) {
            response = Jsoup.parse(page.innerHTML("#toast-container > div")).text();
           // page.close();
            return response;
        }
        page.navigate("https://meroshare.cdsc.com.np/#/asba");
        page.waitForLoadState();
        page.navigate("https://meroshare.cdsc.com.np/#/asba");
        page.waitForLoadState();
        if (verifying) {
            page.click("#main > div > app-asba > div > div.row > div > div > ul > li:nth-child(3)");
            page.waitForLoadState();
            return "Verifying";
        }
        page.click("#main > div > app-asba > div > div.row > div > div > ul > li:nth-child(1)");
        page.waitForLoadState();
        if (!page.isVisible("#main > div > app-asba > div > div:nth-child(2)")) {
            page.reload();
            page.waitForLoadState();
        }
        Elements companyListElements;
        int i = 0;
        while (i < 4) {
            Document companyListHtml = Jsoup.parse(page.innerHTML("#main > div > app-asba > div > div:nth-child(2)"));
            companyListElements = companyListHtml.getElementsByClass("company-name");
            if (companyListElements.isEmpty()) {
                if (i <= 4) {
                    i++;
                    page.reload();
                    continue;
                }
                response = "No companies found";
                //page.close();
                return response;
            }
            List<Company> companies = new ArrayList<>();
            if (checkingIPO) {
                companyListElements.forEach((companyElement) -> {
                    Company company = new Company();
                    company.setName(companyElement.text());
                    companies.add(company);
                });
                //page.close();
                return companies;
            }
            break;
        }
        page.waitForLoadState();
        //select company to apply for IPO
        String companySelector = "#main > div > app-asba > div > div:nth-child(2) > app-applicable-issue > div > div > div > div > div:nth-child(" + companyToApply + ") > div > div.col-md-5.col-sm-3 > div > div:nth-child(4) > button";
        if (!page.isVisible(companySelector)) {
            return "Already Applied";
        }
        page.click(companySelector);
        page.waitForLoadState();
        System.out.println(companySelector);
        SelectOption option = new SelectOption();
        option.setIndex(1);//selects first available bank
        page.selectOption("#selectBank", option);
        //fill form
        page.click("#appliedKitta");
        page.type("#appliedKitta", user.getKitta());
        page.click("#crnNumber");
        page.type("#crnNumber", user.getCRN());
        //checkbox
        page.click("#disclaimer");
        //click submit
        page.click("#main > div > app-issue > div > wizard > div > wizard-step:nth-child(1) > form > div.card > div > div.row > div:nth-child(2) > div > button.btn.btn-gap.btn-primary");
        page.type("#transactionPIN", user.getPIN());
        page.click("#main > div > app-issue > div > wizard > div > wizard-step:nth-child(2) > div.card > div > form > div.row > div > div > div > button.btn.btn-gap.btn-primary");
        page.waitForLoadState();
        page.waitForTimeout(1500);
        if (page.isVisible("#toast-container")) {
            response = Jsoup.parse(page.innerHTML("#toast-container > div")).text();
            // page.close();
            return response;
        }
        return "success but verify once";
    }
}

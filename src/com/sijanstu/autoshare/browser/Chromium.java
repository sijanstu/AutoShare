package com.sijanstu.autoshare.browser;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import javax.swing.*;
import java.util.HashMap;

import static java.lang.System.exit;

/**
 * @author Sijan Bhandari
 */
//remove warning
public class Chromium {
    //supress class warning
    static public Playwright playwright;

    public static Page startBrowser(String url, Boolean visibility) {
        return startLocalBrowser(url, visibility);
    }

    public static Page startLocalBrowser(String url, Boolean visibility) {
        //skip browser download
        Playwright.CreateOptions options = new Playwright.CreateOptions();
        options.setEnv(new HashMap<>(System.getenv()));
        options.env.put("PLAYWRIGHT_SKIP_BROWSER_DOWNLOAD", "1");
        playwright = Playwright.create(options);
        Browser browser;
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions().setHeadless(visibility);
        launchOptions.slowMo = 65.5;
        launchOptions.setChannel("chrome");
        try {
            browser = playwright.chromium().launch(launchOptions);
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate(url, new Page.NavigateOptions());
            return page;
        } catch (Exception e) {
            System.out.println("chromium not found, using msedge");
            launchOptions.setChannel("msedge");
            try {
                browser = playwright.chromium().launch(launchOptions);
                BrowserContext context = browser.newContext();
                Page page = context.newPage();
                page.navigate(url, new Page.NavigateOptions());
                return page;
            } catch (Exception e1) {
                System.out.println("msedge not found, displaying error");
                JOptionPane.showMessageDialog(null, "Chromium or msedge not found, please install one of them");
                exit(0);
            }
        }
        return null;
    }
}

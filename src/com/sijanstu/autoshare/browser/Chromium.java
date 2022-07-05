package com.sijanstu.autoshare.browser;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

/**
 * @author Sijan Bhandari
 */
public class Chromium {

    public static Page startBrowser(String url, Boolean visibility) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions().setHeadless(visibility);
        launchOptions.slowMo = 65.5;
        Browser browser = playwright.chromium().launch(launchOptions);
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate(url, new Page.NavigateOptions());
        return page;
    }
}

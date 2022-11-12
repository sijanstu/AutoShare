package com.sijanstu.autoshare.version3;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLaf;
import com.sijanstu.autoshare.version3.ui.Main;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Config {
    public static final String VERSION = "3.0.0";
    public static final String AUTHOR = "Sijanstu";
    public static final String APPLY_IPO_URL ="https://webbackend.cdsc.com.np/api/meroShare/applicantForm/share/apply";
    public static final String IPO_CHECK_URL = "https://iporesult.cdsc.com.np/result/result/check";
    public static String PROPERIES_PATH = System.getProperty("user.home") + "/autoshare.properties";
    public static final String AUTH_HEADER = "Authorization";
    public static final String AUTH_URL = "https://webbackend.cdsc.com.np/api/meroShare/auth/";
    public static final String USER_DETAIL_URL = "https://webbackend.cdsc.com.np/api/meroShare/ownDetail/";
    public static final String APPLICABLE_ISSUE_URL = "https://webbackend.cdsc.com.np/api/meroShare/companyShare/applicableIssue/";
    public static final String APPLICABLE_ISSUE_PAYLOAD = "{\"filterFieldParams\":[{\"key\":\"companyIssue.companyISIN.script\",\"alias\":\"Scrip\"},{\"key\":\"companyIssue.companyISIN.company.name\",\"alias\":\"Company Name\"},{\"key\":\"companyIssue.assignedToClient.name\",\"value\":\"\",\"alias\":\"Issue Manager\"}],\"page\":1,\"size\":10,\"searchRoleViewConstants\":\"VIEW_APPLICABLE_SHARE\",\"filterDateParams\":[{\"key\":\"minIssueOpenDate\",\"condition\":\"\",\"alias\":\"\",\"value\":\"\"},{\"key\":\"maxIssueCloseDate\",\"condition\":\"\",\"alias\":\"\",\"value\":\"\"}]}";
    public static final String USER_PORTFOLIO_URL = "https://webbackend.cdsc.com.np/api/meroShareView/myPortfolio/";
    public static final String AUTH_PAYLOAD = "{\"clientId\":%d,\"username\":\"%s\",\"password\":\"%s\"}";
    public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36";
    public static final HashMap<String, String> HEADERS = new HashMap<String, String>() {{
        put("Accept", "application/json, text/plain, */*");
        put("Accept-Language", "en-US,en;q=0.6");
        put("Content-Type", "application/json");
        put("Origin", "https://meroshare.cdsc.com.np");
        put("Referer", "https://meroshare.cdsc.com.np/");
        put("Sec-Fetch-Dest", "empty");
        put("Sec-Fetch-Mode", "cors");
        put("Sec-Fetch-Site", "same-site");
        put("Sec-GPC", "1");
        put("user-agent", USER_AGENT);
    }};
    public static final HashMap<String, String> CheckHEADERS = new HashMap<String, String>() {{
        put("Accept", "application/json, text/plain, */*");
        put("Accept-Language", "en-US,en;q=0.6");
        put("Content-Type", "application/json");
        put("Origin", "https://iporesult.cdsc.com.np");
        put("Referer", "https://iporesult.cdsc.com.np/");
        put("Sec-Fetch-Dest", "empty");
        put("Sec-Fetch-Mode", "cors");
        put("Sec-Fetch-Site", "same-site");
        put("Sec-GPC", "1");
        put("user-agent", USER_AGENT);
    }};
    public static final String BANK_URL = "https://webbackend.cdsc.com.np/api/meroShare/bank/";
    public static final String PORTFOLIO_PAYLOAD = "{\"sortBy\":\"script\",\"demat\":[\"%s\"],\"clientCode\":\"%s\",\"page\":1,\"size\":200,\"sortAsc\":true}";
    public static String HISTORY_PAYLOAD = "{\"filterFieldParams\":[{\"key\":\"companyShare.companyIssue.companyISIN.script\",\"alias\":\"Scrip\"},{\"key\":\"companyShare.companyIssue.companyISIN.company.name\",\"alias\":\"Company Name\"}],\"page\":1,\"size\":200,\"searchRoleViewConstants\":\"VIEW_APPLICANT_FORM_COMPLETE\",\"filterDateParams\":[{\"key\":\"appliedDate\",\"condition\":\"\",\"alias\":\"\",\"value\":\"\"},{\"key\":\"appliedDate\",\"condition\":\"\",\"alias\":\"\",\"value\":\"\"}]}";
    public static String HISTORY_URL = "https://webbackend.cdsc.com.np/api/meroShare/applicantForm/active/search/";
    public static String CAPITAL_LIST_URL = "https://webbackend.cdsc.com.np/api/meroShare/capital/";


    public static String HomeDir = System.getProperty("user.home");
    public static String ProgDir = HomeDir + "/autoshare";
    public static String LogDir = ProgDir + "/logs";
    public static String PropertiesFile = ProgDir + "/autoshare.properties";
    public static String ThemeFolder = ProgDir + "/themes";
    public static String ThemeFile = ProgDir + "/theme.txt";
    public static String HistoryScriptUrl = "https://webbackend.cdsc.com.np/api/meroShare/applicantForm/report/detail/";

    //ipo apply payload
    public static String IPOApplyPayload="{\"demat\":\"%s\",\"boid\":\"%s\",\"accountNumber\":\"%s\",\"customerId\":%d,\"accountBranchId\":%d,\"appliedKitta\":\"%s\",\"crnNumber\":\"%s\",\"transactionPIN\":\"%s\",\"companyShareId\":\"%s\",\"bankId\":%d}";

    public static String IPOCheckPayload="{\n" +
            "  \"companyShareId\": \"%s\",\n" +
            "  \"boid\": \"%s\",\n" +
            "  \"userCaptcha\": \"%s\",\n" +
            "  \"captchaIdentifier\": \"%s\"\n" +
            "}";
    public static void updateTheme(){
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        FlatLaf.updateUI();
    }
}

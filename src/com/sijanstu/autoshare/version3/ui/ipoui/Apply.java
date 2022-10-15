package com.sijanstu.autoshare.version3.ui.ipoui;

import com.google.gson.Gson;
import com.sijanstu.autoshare.version3.Config;
import com.sijanstu.autoshare.version3.dto.User;
import com.sijanstu.autoshare.version3.dto.ipo.Bank;
import com.sijanstu.autoshare.version3.dto.ipo.IPOUser;
import com.sijanstu.autoshare.version3.exceptions.CredentialsException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;

public class Apply {
    private final User user=new User();
    Connection.Method post = Connection.Method.POST;
    Connection.Method get = Connection.Method.GET;
    private Connection.Response get(Connection.Method method, String url, String payload) throws IOException {
        Connection v = Jsoup.connect(url)
                .method(method)
                .ignoreContentType(true)
                .headers(getHeaders());
        if (method == post) v.requestBody(payload);
        return v.execute();
    }
    private HashMap<String, String> getHeaders() {
        HashMap<String, String> headers = Config.HEADERS;
        if (user.getToken() != null) {
            headers.put(Config.AUTH_HEADER, user.getToken());
        }
        return headers;
    }
    public Connection.Response applyIPO(IPOUser ipoUser, String kitta, String cmpId) throws IOException, CredentialsException {
        user.setToken(get(post,
                Config.AUTH_URL,
                String.format(Config.AUTH_PAYLOAD, ipoUser.getCompany(), ipoUser.getUsername(), ipoUser.getPassword())
        ).header("Authorization"));
        if (user.getToken() == null) throw new CredentialsException("Invalid Credentials");
        Bank[] banks = new Gson().fromJson(get(get, Config.BANK_URL, "").body(), Bank[].class);
        for (int i = 0; i < banks.length; i++) {
            banks[i]=getBank(banks[i].getId());
        }
        Connection.Response response = get(get, Config.USER_DETAIL_URL, "");
        User user = new Gson().fromJson(response.body(), User.class);
        String payload=getIpoApplyPayload(user,banks,kitta,ipoUser,cmpId);
        Connection.Response response1= get(post, Config.APPLY_IPO_URL, payload);
        return response1;

    }
    private String getIpoApplyPayload(User user, Bank[] banks,String kitta,IPOUser ipoUser,String cmpId) throws IOException {
        Bank bank=chooseBank(banks,user.getName());
        return String.format(Config.IPOApplyPayload,
                user.getDemat(),
                user.getBoid(),
                bank.getAccountNumber(),
                bank.getId(),
                bank.getAccountBranchId(),
                kitta,
                ipoUser.getCRN(),
                ipoUser.getPIN(),
                cmpId,
                bank.getBankId()
        );
    }

    private Bank getBank(int id) throws IOException {
        Connection.Response response = get(get, Config.BANK_URL+""+id, "");
        return new Gson().fromJson(response.body(), Bank.class);
    }

    private Bank chooseBank(Bank[] banks,String user) {
        if (banks.length == 1) return banks[0];
        String[] bankNames=new String[banks.length];
        for (int i = 0; i < banks.length; i++) {
            bankNames[i]=banks[i].getBranchName();
        }
        JOptionPane pane = new JOptionPane("Choose Bank for User "+user, JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION, null, bankNames, bankNames[0]);
        JDialog dialog = pane.createDialog(user);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
        String selectedValue = (String) pane.getValue();
        for (Bank bank : banks) {
            if (bank.getBranchName().equals(selectedValue)) return bank;
        }
        return banks[0];
    }
}

package com.sijanstu.autoshare.version3.httprequests;

import com.google.gson.Gson;
import com.sijanstu.autoshare.version3.Config;
import com.sijanstu.autoshare.version3.dto.User;
import com.sijanstu.autoshare.version3.dto.ipo.Bank;
import com.sijanstu.autoshare.version3.dto.ipo.Capital;
import com.sijanstu.autoshare.version3.dto.ipo.ScripList;
import com.sijanstu.autoshare.version3.dto.portfolio.Portfolio;
import com.sijanstu.autoshare.version3.exceptions.CredentialsException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.HashMap;

@Getter
@Setter
@NoArgsConstructor
public class Request {
    private User user;
    Connection.Method post = Connection.Method.POST;
    Connection.Method get = Connection.Method.GET;

    public Request(User user) {
        this.user = user;
    }

    private Connection.Response get(Connection.Method method, String url, String payload) throws IOException {
        Connection v = Jsoup.connect(url)
                .method(method)
                .ignoreContentType(true)
                .headers(getHeaders());
        if (method == post) v.requestBody(payload);
        return v.execute();
    }

    public User login() throws CredentialsException, IOException {
        getToken();
        getUserDetail();
        getPortfolio();
        getBanks();
        return user;
    }

    private HashMap<String, String> getHeaders() {
        HashMap<String, String> headers = Config.HEADERS;
        if (user != null && user.getToken() != null) {
            headers.put(Config.AUTH_HEADER, user.getToken());
        }
        return headers;
    }

    private Connection.Response getHistory() throws IOException {
        String payload = String.format(Config.HISTORY_PAYLOAD, user.getDemat(), user.getClientCode());
        return get(post, Config.HISTORY_URL, payload);
    }

    private void getToken() throws CredentialsException {
        try {
            String payload = String.format(Config.AUTH_PAYLOAD, user.getBranch(), user.getUsername(), user.getPassword());
            Connection.Response response = get(post, Config.AUTH_URL, payload);
            user.setToken(response.header("Authorization"));
        } catch (IOException e) {
            throw new CredentialsException("Invalid Credentials");
        }
    }

    private void getPortfolio() throws IOException {
        String payload = String.format(Config.PORTFOLIO_PAYLOAD, user.getDemat(), user.getClientCode());
        Connection.Response response = get(post, Config.USER_PORTFOLIO_URL, payload);
        Portfolio portfolio = new Gson().fromJson(response.body(), Portfolio.class);
        user.setPortfolio(portfolio);
    }

    public ScripList getApplicableIssue() throws IOException {
        Connection.Response response= get(post, Config.APPLICABLE_ISSUE_URL, Config.APPLICABLE_ISSUE_PAYLOAD);
        //parse response
        return new Gson().fromJson(response.body(), ScripList.class);
    }

    private void getUserDetail() throws IOException {
        Connection.Response response = get(get, Config.USER_DETAIL_URL, "");
        User user = new Gson().fromJson(response.body(), User.class);
        user.setToken(this.user.getToken());
        this.user = user;
    }

    private void getBanks() throws IOException {
        Connection.Response response = get(get, Config.BANK_URL, "");
        Bank[] banks = new Gson().fromJson(response.body(), Bank[].class);
        for (int i = 0; i < banks.length; i++) {
            banks[i]=getBank(this.user.getToken(),banks[i].getId());
        }
        user.setBanks(banks);
    }

    public Capital[] getCapitals() throws IOException {
        Connection.Response response = get(get, Config.CAPITAL_LIST_URL, "");
        return new Gson().fromJson(response.body(), Capital[].class);
    }
    private Bank getBank(String token,int id) throws IOException {
        Connection.Response response = get(get, Config.BANK_URL+""+id, "");
        return new Gson().fromJson(response.body(), Bank.class);
    }
}

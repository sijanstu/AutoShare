package com.sijanstu.autoshare.version3.users;

import com.sijanstu.autoshare.version3.Config;
import com.sijanstu.autoshare.version3.dto.User;
import com.sijanstu.autoshare.version3.dto.ipo.IPOUser;
import com.sijanstu.autoshare.version3.exceptions.CredentialsException;
import com.sijanstu.autoshare.version3.httprequests.Request;
import com.sijanstu.autoshare.version3.ui.UserList;
import lombok.Getter;
import lombok.Setter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

@Getter
@Setter
public class UserCollection {
    private ArrayList<User> users;
    private ArrayList<IPOUser> ipoUsers;

    public UserCollection() {
        users = new ArrayList<>();
        ipoUsers = new ArrayList<>();
    }

    public void add(User user) {
        users.add(user);
    }

    public void add(IPOUser user) {
        ipoUsers.add(user);
    }

    public void refreshIPOUsers() {
        File file = new File(Config.PROPERIES_PATH);
        if (file.exists()) {
            try {
                Properties p = new Properties();
                p.load(new FileReader(file));
                int i = 1;
                while (true) {
                    String userNumber = "user" + i;
                    if (p.containsKey(userNumber + ".username")) {
                        IPOUser user = new IPOUser();
                        user.setUsername(p.getProperty(userNumber + ".username"));
                        user.setPassword(p.getProperty(userNumber + ".password"));
                        user.setCRN(p.getProperty(userNumber + ".crn"));
                        user.setPIN(p.getProperty(userNumber + ".pin"));
                        user.setSecurity(p.getProperty(userNumber + ".dp"));
                        ipoUsers.add(user);
                        i++;
                    } else {
                        break;
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(UserList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void loginUser(User user) throws IOException, CredentialsException {
        Request request = new Request(user);
        request.login();
    }
}

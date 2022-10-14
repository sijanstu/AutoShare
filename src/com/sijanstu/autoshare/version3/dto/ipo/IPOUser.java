package com.sijanstu.autoshare.version3.dto.ipo;

import com.sijanstu.autoshare.version3.Config;
import com.sijanstu.autoshare.version3.dto.User;
import com.sijanstu.autoshare.version3.ui.UserList;
import lombok.Data;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sijan
 */
@Data
public class IPOUser {
    String username;
    String password;
    String CRN;
    String PIN;
    String kitta;
    String security;
    int company;

    public static ArrayList<IPOUser> getIPOUsers() {
        ArrayList<IPOUser> users = new ArrayList<>();
            File file = new File(Config.PROPERIES_PATH);
            if (file.exists()) {
                try {
                    Properties p = new Properties();
                    p.load(new FileReader(file));
                    int i = 1;
                    while (true) {
                        String userNumber = "user" + i;
                        if (p.containsKey(userNumber + ".username")) {
                            IPOUser ipoUser = new IPOUser();
                            ipoUser.setUsername(p.getProperty(userNumber + ".username"));
                            ipoUser.setPassword(p.getProperty(userNumber + ".password"));
                            ipoUser.setCRN(p.getProperty(userNumber + ".crn"));
                            ipoUser.setPIN(p.getProperty(userNumber + ".pin"));
                            ipoUser.setSecurity(p.getProperty(userNumber + ".dp"));
                            ipoUser.setCompany(Integer.parseInt(p.getProperty(userNumber + ".dpId")));
                            users.add(ipoUser);
                            i++;
                        } else {
                            break;
                        }
                    }
                } catch (IOException ex) {
                    Logger.getLogger(UserList.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        return users;
    }
}

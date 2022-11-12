package com.sijanstu.autoshare.version3.dto.ipo;

import com.sijanstu.autoshare.version3.Config;
import com.sijanstu.autoshare.version3.ui.UserList;
import lombok.Data;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
    HashMap<String, String> tokens;
    private static ArrayList<IPOUser> IPOUserList;
    String fileIndex;

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

    public boolean delete() {
        File file = new File(Config.PROPERIES_PATH);
        Properties p = new Properties();
        try {
            p.load(new FileReader(file));
            p.remove(fileIndex + "username");
            p.remove(fileIndex + "password");
            p.remove(fileIndex + "crn");
            p.remove(fileIndex + "pin");
            p.remove(fileIndex + "dp");
            p.store(new FileWriter(file), "user deleted:" + username);
            return true;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error in deleting user");
        }
        return false;
    }

    public ArrayList<IPOUser> getAllLogged() {
        if (IPOUserList == null) {
            IPOUserList = new ArrayList<>();
            File file = new File(Config.PROPERIES_PATH);
            Properties p = new Properties();
            if (file.exists()) {
                try {
                    p.load(new FileReader(file));
                    int i = 1;
                    while (true) {
                        String userNumber = "user" + i;
                        if (p.containsKey(userNumber + ".username")) {
                            IPOUser user = new IPOUser();
                            user.setUsername(p.getProperty(userNumber + ".username"));
                            user.setPassword(p.getProperty(userNumber + ".password"));
                            user.setSecurity(p.getProperty(userNumber + ".dp"));
                            user.setPIN(p.getProperty(userNumber + ".pin"));
                            user.setCRN(p.getProperty(userNumber + ".crn"));
                            user.setFileIndex(userNumber);
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
        return IPOUserList;
    }
}

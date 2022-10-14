package com.sijanstu.autoshare.version3.themes;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.sijanstu.autoshare.version3.Config;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

/**
 * this class is used to store the theme of the application
 *
 * @author Sijan Bhandari
 */
public class Theme {
    private FlatLaf theme = new FlatDarkLaf();

    public FlatLaf getTheme() throws IOException {
        readTheme();
        return theme;
    }

    public void setTheme(FlatLaf theme) {
        this.theme = theme;
        writeTheme();
    }

    public FlatLaf setDarkTheme(boolean dark) throws UnsupportedLookAndFeelException, IOException {
        if (dark) {
            setTheme(new FlatDarkLaf());
        } else {
            setTheme(new FlatLightLaf());
        }
        writeTheme();
        setTheme();
        return theme;
    }

    public void setTheme() throws UnsupportedLookAndFeelException, IOException {
        readTheme();
        UIManager.setLookAndFeel(theme);
        FlatLaf.updateUI();
    }

    @Override
    public String toString() {
        return theme.getName();
    }

    //read the theme from the file
    public void readTheme() throws IOException {
        File file = new File(Config.ThemeFile);
        //check if the file exists
        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(file));
            String line = reader.readLine();
            if (line != null) {
                if (line.equals("light")) {
                    theme = new FlatLightLaf();
                } else {
                    theme = new FlatDarkLaf();
                }
            }
            reader.close();
        }
        writeTheme();
    }

    //write the theme to the file
    public void writeTheme() {
        try {
            File file = new File(Config.ThemeFile);
            //create directory if it does not exist
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            //check if the file exists
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            java.io.FileWriter writer = new java.io.FileWriter(file);
            if (theme.getName().equals("Flat Light")) {
                writer.write("light");
            } else {
                writer.write("dark");
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

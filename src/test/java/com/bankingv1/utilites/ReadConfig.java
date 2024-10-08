package com.bankingv1.utilites;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

    Properties pro;

    public ReadConfig(){

        File src = new File("./configers/config.properties");
        try {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);

        } catch (Exception e) {
            System.out.println("exception is "+e.getMessage());
        }

    }
    public String getApplicationURL(){

        String url = pro.getProperty("baseURL");
        return url;
    }
    public String getUsername(){

        String username = pro.getProperty("username");
        return username;
    }
    public String getPassword(){

        String password = pro.getProperty("password");
        return password;
    }
    public String getChromepath(){

        String chromepath = pro.getProperty("chromepath");
        return chromepath;
    }
    public String getIepath(){

        String iepath = pro.getProperty("iepath");
        return iepath;
    }
    public String getFirefoxpath(){

        String firefoxpath = pro.getProperty("firefoxpath");
        return firefoxpath;
    }



}

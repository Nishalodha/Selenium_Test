package com.clariontechnologies.utils;

import org.testng.log4testng.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {
    private static Logger log = Logger.getLogger(PropertiesUtils.class);

    public static Properties pro = new Properties();

    public static String getLocator(String locatorName) {
        String value = "";

        try {
            String basepath = System.getProperty("user.dir");
            FileInputStream fin = new FileInputStream(basepath + "\\src\\test\\resources\\ObjectRepository.properties");
            pro.load(fin);
            value = (String) pro.get(locatorName);
        } catch (FileNotFoundException e) {
            log.error("File Not Found", e);
        } catch (IOException e) {
            log.error("", e);
        }
        return value;

    }


}

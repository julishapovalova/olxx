package com.olx.property;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class EnvironmentProperties {

    private static Properties prop;

    private EnvironmentProperties() {
    }

    private static void init() {
        prop = new Properties();
        try {
            prop.load(new FileInputStream("src/test/resources/application.properties"));
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String propertyName) {
        if (prop == null) {
            init();
        }
        return prop.getProperty(propertyName);
    }
}

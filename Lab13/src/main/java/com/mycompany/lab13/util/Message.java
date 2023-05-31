package com.mycompany.lab13.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Message {
    private Properties properties;

    public Message() {
        loadProperties("/res/Messages.properties");
    }

    public Message(String propertiesFile) {
        loadProperties(propertiesFile);
    }

    public String getPrompt() {
        return getProperty("prompt");
    }

    public String getLocales() {
        return getProperty("locales");
    }

    public String getLocale() {
        return getProperty("locale.set");
    }

    public String getInfo() {
        return getProperty("info");
    }

    public String getInvalid() {
        return getProperty("invalid");
    }

    public String getCountry() {
        return getProperty("country");
    }

    public String getLanguage() {
        return getProperty("language");
    }

    public String getCurrency() {
        return getProperty("currency");
    }

    public String getWeek() {
        return getProperty("week");
    }

    public String getMonths() {
        return getProperty("months");
    }

    public String getToday() {
        return getProperty("today");
    }

    private void loadProperties(String propertiesFile) {
        properties = new Properties();
        try (InputStream inputStream = getClass().getResourceAsStream(propertiesFile)) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                System.err.println("Properties file not found: " + propertiesFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getProperty(String key) {
        return properties.getProperty(key);
    }
}

package com.example.config;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DatabaseConfig {
    private static final String CONFIG_FILE = "src/main/resources/application.properties";
    private Properties properties;

    public DatabaseConfig() {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream(CONFIG_FILE)) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getDatabaseType() {
        return properties.getProperty("database.type");
    }

    public String getDatabaseUrl() {
        return properties.getProperty(getDatabaseType() + ".url");
    }

    public String getDatabaseUser() {
        return properties.getProperty(getDatabaseType() + ".user");
    }

    public String getDatabasePassword() {
        return properties.getProperty(getDatabaseType() + ".password");
    }
}
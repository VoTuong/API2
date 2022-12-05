package com.googleclassroom.oauth2.util;

import java.util.Properties;

import static com.googleclassroom.oauth2.util.APIConstants.*;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader(){
        properties = PropertyUtils.propertyLoader(CONFIG_FILE_PATH);
    }

    public static ConfigLoader getInstance(){
        if(configLoader == null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getAuthMode(){
        String prop = properties.getProperty("auth_mode");
        if(prop != null) return prop;
        else throw new RuntimeException("property auth_mode is not specified in the config.properties file");
    }

    public String getTokenUrl(){
        String prop = properties.getProperty("token_url");
        if(prop != null) return prop;
        else throw new RuntimeException("property token_url is not specified in the config.properties file");
    }

    public String getClientId(){
        String prop = properties.getProperty("client_id");
        if(prop != null) return prop;
        else throw new RuntimeException("property client_id is not specified in the config.properties file");
    }

    public String getClientSecret(){
        String prop = properties.getProperty("client_secret");
        if(prop != null) return prop;
        else throw new RuntimeException("property client_secret is not specified in the config.properties file");
    }

    public String getGrantType(){
        String prop = properties.getProperty("grant_type");
        if(prop != null) return prop;
        else throw new RuntimeException("property grant_type is not specified in the config.properties file");
    }

    public String getRefreshToken(){
        String prop = properties.getProperty("refresh_token");
        if(prop != null) return prop;
        else throw new RuntimeException("property refresh_token is not specified in the config.properties file");
    }
}

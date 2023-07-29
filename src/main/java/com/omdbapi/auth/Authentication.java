package com.omdbapi.auth;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Authentication {
    public String getAuth() {
        Properties properties = new Properties();

        try {
            FileInputStream file = new FileInputStream("src/main/resources/config.properties");
            properties.load(file);
            file.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }

        String apiKey = properties.getProperty("api.key");
        if (apiKey == null) {
            System.err.println("Chave de segurança da API não encontrada no arquivo de configurações.");
            return null;
        }
        return apiKey;
    }
}

package com.omdbapi.infra;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileCreator {
    public void jsonCreator(List list) {
        try {
            FileWriter writer = new FileWriter("titulos.json");
            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();
            writer.write(gson.toJson(list));
            writer.close();
            System.out.println("O arquivo JSON com suas pesquisas foi criado");
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }
}

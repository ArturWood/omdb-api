package com.omdbapi.service;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.omdbapi.auth.Authentication;
import com.omdbapi.model.Series;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SeriesService {
    Authentication authentication = new Authentication();

    public Series getSeries(String series) {
        try {
            String url = "https://www.omdbapi.com/?t=" + series.replace(" ", "+") + "&type=series&apikey=" + authentication.getAuth();
            System.out.println("endpoint: " + url);

            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).build();
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            System.out.println("resposta serviço: " + json);

            if (!json.contains("Error")) {
                Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
                Series responseSeries = gson.fromJson(json, Series.class);
                System.out.println(responseSeries);

                return responseSeries;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}

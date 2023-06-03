package com.omdbapi.service;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.omdbapi.auth.Authentication;
import com.omdbapi.model.Movie;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MovieService {
    Authentication authentication = new Authentication();

    public Movie getMovie(String movie) {
        try {
            String url = "https://www.omdbapi.com/?t=" + movie.replace(" ", "+") + "&type=movie&apikey=" + authentication.getAuth();
            System.out.println("endpoint: " + url);

            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).build();
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            System.out.println("resposta serviço: " + json);

            if (!json.contains("Error")) {
                Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
                Movie responseMovie = gson.fromJson(json, Movie.class);
                System.out.println(responseMovie);

                return responseMovie;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}

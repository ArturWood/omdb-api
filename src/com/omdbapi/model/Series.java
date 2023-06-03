package com.omdbapi.model;

import com.google.gson.annotations.SerializedName;

public record Series(String title, String year, String released, String runtime, String genre, @SerializedName(value = "imdbRating") String imdbRating, String type) {
}

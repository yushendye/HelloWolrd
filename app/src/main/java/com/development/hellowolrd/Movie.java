package com.development.hellowolrd;

public class Movie {
    String url;
    String name;
    double rating;

    public Movie(String url, String name, double rating) {
        this.url = url;
        this.name = name;
        this.rating = rating;
    }

    public Movie() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}

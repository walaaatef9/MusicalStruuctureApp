package com.example.android.musicalstructure;

public class Artist {
    private final String name;
    private final String band;
    private final String role;


    public Artist(String name, String band, String role) {
        this.name = name;
        this.band = band;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getBand() {
        return band;
    }

    public String getRole() {
        return role;
    }
}

package com.example.android.musicalstructure;

import java.util.ArrayList;

public class Album {
    private final String title;
    private final int year;
    private final String band;

    private final ArrayList<Song> songs = new ArrayList<>();
    private final ArrayList<Artist> artists = new ArrayList<>();


    Album(String title, int year, String band) {
        this.title = title;
        this.year = year;
        this.band = band;
    }

    /**
     * Get Album Title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get Album Year.
     */
    public int getYear() {
        return year;
    }

    /**
     * Get Album Band.
     */
    public String getBand() {
        return band;
    }

    /**
     * Get Total Artists in Album.
     */
    public int getArtistCount() {
        if (artists == null) {
            return 0;
        }
        return artists.size();
    }

    /**
     * Get Total Songs in Album.
     */
    public int getSongsCount() {
        if (songs == null) {
            return 0;
        }
        return songs.size();
    }

    /**
     * Get Album Artists.
     */
    public ArrayList<Artist> getArtists() {
        return artists;
    }

    /**
     * Set Albums Artists.
     */
    void addArtist(Artist artist) {
        this.artists.add(artist);
    }

    /**
     * Get Album Songs.
     */
    public ArrayList<Song> getSongs() {
        return songs;
    }

    /**
     * Set Albums Songs.
     */
    void addSong(Song song) {
        this.songs.add(song);
    }


}

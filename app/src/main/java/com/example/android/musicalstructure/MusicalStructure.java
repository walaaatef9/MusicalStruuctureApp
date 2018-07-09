package com.example.android.musicalstructure;

import android.app.Application;

import java.util.ArrayList;

public class MusicalStructure extends Application {

    private final ArrayList<Album> albums = new ArrayList<>();

    /**
     * Get Albums.
     */
    public ArrayList<Album> getAlbums() {
        return albums;
    }

    /**
     * Set Albums.
     */
    void addAlbum(Album album) {
        this.albums.add(album);
    }


    /**
     * Get Total Albums in ArrayList
     */
    public int getAlbumsCount() {
        if (albums == null) {
            return 0;
        }
        return albums.size();
    }

}

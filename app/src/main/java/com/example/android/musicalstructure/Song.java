package com.example.android.musicalstructure;

public class Song {
    private final String title;
    private final String album;
    private final int trackNumber;
    private final String duration;

    public Song(String album, String title, int trackNumber, String duration) {
        this.album = album;
        this.title = title;
        this.trackNumber = trackNumber;
        this.duration = duration;
    }

    public String getSongName() {
        return title;
    }

    public String getAlbumName() {
        return album;
    }

    public int getSongTrackNumber() {
        return trackNumber;
    }

    public String getDuration() {
        return duration;
    }
}

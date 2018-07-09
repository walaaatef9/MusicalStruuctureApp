package com.example.android.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private static final int LOAD_ALL = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // load Albums, Artists and Songs.
        if (((MusicalStructure) this.getApplication()).getAlbumsCount() == 0) {
            initializeAlbumInformation();
        }

        //Album activity_main.xml click listener
        LinearLayout albums = findViewById(R.id.album_layout);
        albums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new intent to open the {@link AlbumsActivity}
                Intent albumsIntent = new Intent(MainActivity.this, AlbumsActivity.class);

                // Start the new activity
                startActivity(albumsIntent);
            }
        });

        //Artist activity_main.xml click listener
        LinearLayout artists = findViewById(R.id.artist_layout);
        artists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new intent to open the {@link ArtistsActivity}
                Bundle basket = new Bundle();
                basket.putInt("pos", LOAD_ALL);

                Intent artistsIntent = new Intent(MainActivity.this, ArtistsActivity.class);
                artistsIntent.putExtras(basket);
                // Start the new activity
                startActivity(artistsIntent);
            }
        });

        //Songs activity_main.xml click listener
        LinearLayout songs = findViewById(R.id.songs_layout);
        songs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new intent to open the {@link SongsActivity}
                Bundle basket = new Bundle();
                basket.putInt("pos", LOAD_ALL);

                Intent songIntent = new Intent(MainActivity.this, SongsActivity.class);
                songIntent.putExtras(basket);
                // Start the new activity
                startActivity(songIntent);
            }
        });

    }

    /**
     * Initialize Album/Artist/Song information
     */
    private void initializeAlbumInformation() {
        //add Albums
        ((MusicalStructure) this.getApplication()).addAlbum(new Album("Max Damage", 1999, "Game Over"));
        ((MusicalStructure) this.getApplication()).addAlbum(new Album("In Ville", 2018, "Kriptonvana"));
        ((MusicalStructure) this.getApplication()).addAlbum(new Album("There is a spoon", 1966, "The Matrixians"));
        ((MusicalStructure) this.getApplication()).addAlbum(new Album("Penguins can fly", 1978, "System of a BSOD"));

        //add Albums Artists
        ((MusicalStructure) this.getApplication()).getAlbums().get(0).addArtist(new Artist("Postal Dude", ((MusicalStructure) this.getApplication()).getAlbums().get(0).getBand(), "guitarist"));
        ((MusicalStructure) this.getApplication()).getAlbums().get(0).addArtist(new Artist("Rick Dangerous", ((MusicalStructure) this.getApplication()).getAlbums().get(0).getBand(), "vocalist"));
        ((MusicalStructure) this.getApplication()).getAlbums().get(0).addArtist(new Artist("B.J. Blazkowicz", ((MusicalStructure) this.getApplication()).getAlbums().get(0).getBand(), "drummer"));
        ((MusicalStructure) this.getApplication()).getAlbums().get(0).addArtist(new Artist("Lara Croft", ((MusicalStructure) this.getApplication()).getAlbums().get(0).getBand(), "guitarist"));
        ((MusicalStructure) this.getApplication()).getAlbums().get(0).addArtist(new Artist("Duke Nukem", ((MusicalStructure) this.getApplication()).getAlbums().get(0).getBand(), "drummer"));

        ((MusicalStructure) this.getApplication()).getAlbums().get(1).addArtist(new Artist("Lana Lang", ((MusicalStructure) this.getApplication()).getAlbums().get(1).getBand(), "vocalist"));
        ((MusicalStructure) this.getApplication()).getAlbums().get(1).addArtist(new Artist("Clark Kent", ((MusicalStructure) this.getApplication()).getAlbums().get(1).getBand(), "drummer"));
        ((MusicalStructure) this.getApplication()).getAlbums().get(1).addArtist(new Artist("Jimmy Olsen", ((MusicalStructure) this.getApplication()).getAlbums().get(1).getBand(), "guitarist"));

        ((MusicalStructure) this.getApplication()).getAlbums().get(2).addArtist(new Artist("Neo", ((MusicalStructure) this.getApplication()).getAlbums().get(2).getBand(), "vocalist"));
        ((MusicalStructure) this.getApplication()).getAlbums().get(2).addArtist(new Artist("Trinity", ((MusicalStructure) this.getApplication()).getAlbums().get(2).getBand(), "drummer"));
        ((MusicalStructure) this.getApplication()).getAlbums().get(2).addArtist(new Artist("Morpheus", ((MusicalStructure) this.getApplication()).getAlbums().get(2).getBand(), "guitarist"));

        ((MusicalStructure) this.getApplication()).getAlbums().get(3).addArtist(new Artist("Bill Gates", ((MusicalStructure) this.getApplication()).getAlbums().get(3).getBand(), "vocalist"));
        ((MusicalStructure) this.getApplication()).getAlbums().get(3).addArtist(new Artist("Steve Jobs", ((MusicalStructure) this.getApplication()).getAlbums().get(3).getBand(), "drummer"));
        ((MusicalStructure) this.getApplication()).getAlbums().get(3).addArtist(new Artist("Linus Torvalds", ((MusicalStructure) this.getApplication()).getAlbums().get(3).getBand(), "guitarist"));

        //add Albums Songs
        ((MusicalStructure) this.getApplication()).getAlbums().get(0).addSong(new Song(((MusicalStructure) this.getApplication()).getAlbums().get(0).getTitle(), "Going Postal", 1, "00:04:21"));
        ((MusicalStructure) this.getApplication()).getAlbums().get(0).addSong(new Song(((MusicalStructure) this.getApplication()).getAlbums().get(0).getTitle(), "Going Dangerous", 2, "00:05:43"));
        ((MusicalStructure) this.getApplication()).getAlbums().get(0).addSong(new Song(((MusicalStructure) this.getApplication()).getAlbums().get(0).getTitle(), "Going Nuclear", 3, "00:06:45"));

        ((MusicalStructure) this.getApplication()).getAlbums().get(1).addSong(new Song(((MusicalStructure) this.getApplication()).getAlbums().get(1).getTitle(), "Small Ville", 1, "00:03:12"));
        ((MusicalStructure) this.getApplication()).getAlbums().get(1).addSong(new Song(((MusicalStructure) this.getApplication()).getAlbums().get(1).getTitle(), "Big Ville", 2, "00:02:34"));
        ((MusicalStructure) this.getApplication()).getAlbums().get(1).addSong(new Song(((MusicalStructure) this.getApplication()).getAlbums().get(1).getTitle(), "Tiny Ville", 3, "00:04:56"));
        ((MusicalStructure) this.getApplication()).getAlbums().get(1).addSong(new Song(((MusicalStructure) this.getApplication()).getAlbums().get(1).getTitle(), "Huge Ville", 4, "00:06:23"));
        ((MusicalStructure) this.getApplication()).getAlbums().get(1).addSong(new Song(((MusicalStructure) this.getApplication()).getAlbums().get(1).getTitle(), "Little Ville", 5, "00:04:26"));

        ((MusicalStructure) this.getApplication()).getAlbums().get(2).addSong(new Song(((MusicalStructure) this.getApplication()).getAlbums().get(2).getTitle(), "Blue Pill", 1, "00:04:12"));
        ((MusicalStructure) this.getApplication()).getAlbums().get(2).addSong(new Song(((MusicalStructure) this.getApplication()).getAlbums().get(2).getTitle(), "Red Pill", 2, "00:05:32"));
        ((MusicalStructure) this.getApplication()).getAlbums().get(2).addSong(new Song(((MusicalStructure) this.getApplication()).getAlbums().get(2).getTitle(), "Brown Pill", 3, "00:04:56"));
        ((MusicalStructure) this.getApplication()).getAlbums().get(2).addSong(new Song(((MusicalStructure) this.getApplication()).getAlbums().get(2).getTitle(), "Black Pill", 4, "00:02:59"));
        ((MusicalStructure) this.getApplication()).getAlbums().get(2).addSong(new Song(((MusicalStructure) this.getApplication()).getAlbums().get(2).getTitle(), "Pink Pill", 5, "00:05:09"));
        ((MusicalStructure) this.getApplication()).getAlbums().get(2).addSong(new Song(((MusicalStructure) this.getApplication()).getAlbums().get(2).getTitle(), "Purple Pill", 6, "00:04:33"));
        ((MusicalStructure) this.getApplication()).getAlbums().get(2).addSong(new Song(((MusicalStructure) this.getApplication()).getAlbums().get(2).getTitle(), "White Pill", 7, "00:04:44"));
        ((MusicalStructure) this.getApplication()).getAlbums().get(2).addSong(new Song(((MusicalStructure) this.getApplication()).getAlbums().get(2).getTitle(), "Transparent Pill", 8, "00:08:29"));
        ((MusicalStructure) this.getApplication()).getAlbums().get(2).addSong(new Song(((MusicalStructure) this.getApplication()).getAlbums().get(2).getTitle(), "Green Pill", 8, "00:04:00"));
        ((MusicalStructure) this.getApplication()).getAlbums().get(2).addSong(new Song(((MusicalStructure) this.getApplication()).getAlbums().get(2).getTitle(), "Yellow Pill", 8, "00:09:05"));

        ((MusicalStructure) this.getApplication()).getAlbums().get(3).addSong(new Song(((MusicalStructure) this.getApplication()).getAlbums().get(3).getTitle(), "Windows", 1, "00:04:12"));
        ((MusicalStructure) this.getApplication()).getAlbums().get(3).addSong(new Song(((MusicalStructure) this.getApplication()).getAlbums().get(3).getTitle(), "Linux", 2, "00:05:34"));
        ((MusicalStructure) this.getApplication()).getAlbums().get(3).addSong(new Song(((MusicalStructure) this.getApplication()).getAlbums().get(3).getTitle(), "Mac", 3, "00:06:56"));
        ((MusicalStructure) this.getApplication()).getAlbums().get(3).addSong(new Song(((MusicalStructure) this.getApplication()).getAlbums().get(3).getTitle(), "Blue Screen", 4, "00:05:23"));
        ((MusicalStructure) this.getApplication()).getAlbums().get(3).addSong(new Song(((MusicalStructure) this.getApplication()).getAlbums().get(3).getTitle(), "rm -Rf /", 5, "00:04:23"));
    }
}

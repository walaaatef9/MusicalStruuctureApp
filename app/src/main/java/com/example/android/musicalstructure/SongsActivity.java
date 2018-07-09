package com.example.android.musicalstructure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class SongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        Bundle basket = getIntent().getExtras();
        int albumIndex = basket.getInt("pos");

        loadAdapter(albumIndex);

    }

    private void loadAdapter(int albumIndex) {
        // init song ArrayList
        ArrayList<Song> songs;
        if (albumIndex == -1) {
            songs = new ArrayList<Song>();
            for (int i = 0; i < ((MusicalStructure) this.getApplication()).getAlbumsCount(); i++) {
                if (((MusicalStructure) this.getApplication()).getAlbums().get(i).getSongsCount() > 0) {
                    songs.addAll(((MusicalStructure) this.getApplication()).getAlbums().get(i).getSongs());
                }
            }
        } else {
            songs = ((MusicalStructure) this.getApplication()).getAlbums().get(albumIndex).getSongs();
        }

        // Create an {@link SongAdapter}, whose data source is a list of {@link Song}s. The
        // adapter knows how to create list items for each item in the list.
        SongAdapter adapter = new SongAdapter(this, songs);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // song_list.xml layout file.
        ListView listView = findViewById(R.id.song_list);

        // Make the {@link ListView} use the {@link SongAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Song} in the list.
        listView.setAdapter(adapter);
    }
}

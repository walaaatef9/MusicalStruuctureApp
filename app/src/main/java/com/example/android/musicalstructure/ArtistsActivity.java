package com.example.android.musicalstructure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class ArtistsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artist_list);

        Bundle basket = getIntent().getExtras();
        int albumIndex = basket.getInt("pos");

        loadAdapter(albumIndex);

    }

    private void loadAdapter(int albumIndex) {
        // init artists ArrayList
        ArrayList<Artist> artists;
        if (albumIndex == -1) {
            artists = new ArrayList<Artist>();
            for (int i = 0; i < ((MusicalStructure) this.getApplication()).getAlbumsCount(); i++) {
                if (((MusicalStructure) this.getApplication()).getAlbums().get(i).getArtistCount() > 0) {
                    artists.addAll(((MusicalStructure) this.getApplication()).getAlbums().get(i).getArtists());
                }
            }
        } else {
            artists = ((MusicalStructure) this.getApplication()).getAlbums().get(albumIndex).getArtists();
        }

        // Create an {@link SongAdapter}, whose data source is a list of {@link Song}s. The
        // adapter knows how to create list items for each item in the list.
        ArtistAdapter adapter = new ArtistAdapter(this, artists);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // song_list.xml layout file.
        ListView listView = findViewById(R.id.artist_list);

        // Make the {@link ListView} use the {@link SongAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Song} in the list.
        listView.setAdapter(adapter);
    }
}

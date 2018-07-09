package com.example.android.musicalstructure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class AlbumsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_list);

        loadAdapter();
    }

    private void loadAdapter() {
        ArrayList<Album> albums = ((MusicalStructure) this.getApplication()).getAlbums();

        // Create an {@link AlbumAdapter}, whose data source is a list of {@link Album}s. The
        // adapter knows how to create list items for each item in the list.
        AlbumAdapter adapter = new AlbumAdapter(this, albums);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // album_list.xml layout file.
        ListView listView = findViewById(R.id.album_list);

        // Make the {@link ListView} use the {@link AlbumAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Album} in the list.
        listView.setAdapter(adapter);
    }

}

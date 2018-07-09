package com.example.android.musicalstructure;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class AlbumAdapter extends ArrayAdapter<Album> {

    /**
     * Create a new {@link AlbumAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param albums  is the list of {@link Album}s to be displayed.
     */
    public AlbumAdapter(Context context, ArrayList<Album> albums) {
        super(context, 0, albums);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder mainVH = null;

        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_album, parent, false);

            // Get the {@link Album} object located at this position in the list
            Album currentAlbum = getItem(position);

            // Find the TextView in the list_album.xml layout with the ID title_text_view and set value.
            TextView titleTextView = listItemView.findViewById(R.id.title_text_view);
            titleTextView.setText(currentAlbum.getTitle());

            // Find the TextView in the list_album.xml layout with the ID year_text_view and set value.
            TextView yearTextView = listItemView.findViewById(R.id.year_text_view);
            yearTextView.setText(Integer.toString(currentAlbum.getYear()));

            // Find the TextView in the list_album.xml layout with the ID total_tracks_text_view and set value.
            TextView bandTextView = listItemView.findViewById(R.id.band_text_view);
            bandTextView.setText(currentAlbum.getBand());

            //   // Find the TextView in the list_album.xml layout with the ID total_tracks_text_view and set value.
            //   TextView tracksTextView = listItemView.findViewById(R.id.band_text_view);
            //   tracksTextView.setText(Integer.toString(currentAlbum.getBand()) + " Songs");

            // Find the Button in the list_album.xml layout with ID artist_btn and store it in the tag and create listener.
            final ViewHolder vh = new ViewHolder();
            vh.position = position;

            vh.buttonArtists = listItemView.findViewById(R.id.artist_btn);
            vh.buttonArtists.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Create a new intent to open the {@link AlbumsActivity}
                    Bundle basket = new Bundle();
                    basket.putInt("pos", position);
                    Intent artistIntent = new Intent(getContext(), ArtistsActivity.class);
                    artistIntent.putExtras(basket);
                    // Start the new activity
                    getContext().startActivity(artistIntent);
                }
            });

            vh.buttonSongs = listItemView.findViewById(R.id.song_btn);
            vh.buttonSongs.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Create a new intent to open the {@link AlbumsActivity}
                    Bundle basket = new Bundle();
                    basket.putInt("pos", position);
                    Intent songIntent = new Intent(getContext(), SongsActivity.class);
                    songIntent.putExtras(basket);
                    // Start the new activity
                    getContext().startActivity(songIntent);
                }
            });

            listItemView.setTag(vh);

        } else {
            mainVH = (ViewHolder) convertView.getTag();
        }

        return listItemView;
    }

    class ViewHolder {
        int position;
        Button buttonArtists;
        Button buttonSongs;
    }


}

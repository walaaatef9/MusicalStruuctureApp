package com.example.android.musicalstructure;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ArtistAdapter extends ArrayAdapter<Artist> {
    /**
     * Create a new {@link ArtistAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param artists is the list of {@link Artist}s to be displayed.
     */
    public ArtistAdapter(Context context, ArrayList<Artist> artists) {
        super(context, 0, artists);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_artist, parent, false);
        }

        // Get the {@link Artist} object located at this position in the list
        Artist currentArtist = getItem(position);

        // Find the TextView in the list_artist.xml layout with the ID artist_text_view and set value.
        TextView artistTextView = listItemView.findViewById(R.id.artist_text_view);
        artistTextView.setText(currentArtist.getName());

        // Find the TextView in the list_artist.xml layout with the ID artist_text_view and set value.
        TextView bandTextView = listItemView.findViewById(R.id.band_text_view);
        bandTextView.setText(currentArtist.getBand());

        // Find the TextView in the list_artist.xml layout with the ID role_text_view and set value.
        TextView roleTextView = listItemView.findViewById(R.id.role_text_view);
        roleTextView.setText(currentArtist.getRole());


        return listItemView;
    }
}

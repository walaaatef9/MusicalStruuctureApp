package com.example.android.musicalstructure;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {
    /**
     * Create a new {@link SongAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param songs   is the list of {@link Song}s to be displayed.
     */
    public SongAdapter(Context context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mainVH = null;

        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_song, parent, false);

            // Get the {@link Song} object located at this position in the list
            Song currentSong = getItem(position);

            // Find the TextView in the list_song.xml layout with the ID year_text_view and set value.
            TextView yearTextView = listItemView.findViewById(R.id.number_text_view);
            yearTextView.setText(Integer.toString(currentSong.getSongTrackNumber()));

            // Find the TextView in the list_song.xml layout with the ID title_text_view and set value.
            TextView titleTextView = listItemView.findViewById(R.id.title_text_view);
            titleTextView.setText(currentSong.getSongName());

            // Find the TextView in the list_song.xml layout with the ID total_tracks_text_view and set value.
            TextView durationTextView = listItemView.findViewById(R.id.duration_text_view);
            durationTextView.setText(currentSong.getDuration());

            // Find the TextView in the list_song.xml layout with the ID title_text_view and set value.
            TextView albumTextView = listItemView.findViewById(R.id.album_text_view);
            albumTextView.setText(currentSong.getAlbumName());

            // Find the Button in the list_album.xml layout with ID artist_btn and store it in the tag and create listener.
            final ViewHolder vh = new ViewHolder();
            vh.position = position;

            vh.buttonPlay = listItemView.findViewById(R.id.play_btn);
            vh.buttonPlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "TODO: Play Music", Toast.LENGTH_SHORT).show();
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
        Button buttonPlay;
    }
}

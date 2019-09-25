package com.albert.musiclive.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.albert.musiclive.Adapters.ArtitsAdapter;
import com.albert.musiclive.Adapters.MusicAdapter;
import com.albert.musiclive.R;
import com.albert.musiclive.models.Artist;
import com.albert.musiclive.models.Song;
import com.albert.musiclive.tools.Serializer;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SongListFragment  extends Fragment {
    private RecyclerView recyclerViewSong;
    private ProgressBar progressBar;
    private List<Song> listSong;
    private MusicAdapter musicAdapter;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference table_song = database.getReference("Songs");

    private String artistId;

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_songlist, container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerViewSong = view.findViewById(R.id.lv_song);
        recyclerViewSong.setHasFixedSize(true);

        listSong = new ArrayList<>();
        musicAdapter = new MusicAdapter(getContext(),listSong);
        recyclerViewSong.setAdapter(musicAdapter);
        recyclerViewSong.setLayoutManager(new LinearLayoutManager(getContext()));


       /* for(int i=0;i<=10;i++){
            Song song = new Song();
            song.setTitle("Ido't"+i);
            song.setLikesCount(""+i);
            listSong.add(song);
        }*/

       //Get information of Artist
         //final Artist artist =(Artist) Serializer.deSerialize("artist",getContext());
        //Toast.makeText(getContext(), artistId, Toast.LENGTH_SHORT).show();
        table_song.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listSong.clear();
                for(DataSnapshot dss:dataSnapshot.getChildren()){
                    Song song = dss.getValue(Song.class);
                    song.setSongId(dss.getKey());

                    if(artistId.equals(song.getArtistId())) {
                        listSong.add(song);
                    }

                }

                musicAdapter.notifyDataSetChanged();
                // progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getContext(), ""+databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
        });



    }
}

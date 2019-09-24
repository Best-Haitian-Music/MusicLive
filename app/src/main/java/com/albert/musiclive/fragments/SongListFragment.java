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

import com.albert.musiclive.Adapters.ArtitsAdapter;
import com.albert.musiclive.Adapters.MusicAdapter;
import com.albert.musiclive.R;
import com.albert.musiclive.models.Artist;
import com.albert.musiclive.models.Song;

import java.util.ArrayList;
import java.util.List;

public class SongListFragment  extends Fragment {
    private RecyclerView recyclerViewSong;
    private ProgressBar progressBar;
    private List<Song> listSong;
    private MusicAdapter musicAdapter;
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


        for(int i=0;i<=10;i++){
            Song song = new Song();
            song.setTitle("Ido't"+i);
            song.setLikeCount(""+i);
            listSong.add(song);
        }

        musicAdapter.notifyDataSetChanged();

    }
}

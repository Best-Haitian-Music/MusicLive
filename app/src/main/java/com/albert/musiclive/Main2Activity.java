package com.albert.musiclive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.albert.musiclive.models.Artist;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    private List<Artist> listArtist;

    ArtistAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView = findViewById(R.id.lv_artist);
        //  progressBar= view.findViewById(R.id.progress_circular);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        listArtist = new ArrayList<>();
        adapter = new ArtistAdapter(getApplicationContext(),listArtist);
        recyclerView.setAdapter(adapter);

        for(int i=0;i<=10;i++){
            Artist artist = new Artist();
            artist.setName("Iberdo");
            listArtist.add(artist);
        }

        adapter.notifyDataSetChanged();
    }
}

package com.albert.musiclive;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.albert.musiclive.fragments.ProfileFragment;
import com.albert.musiclive.fragments.SongListFragment;
import com.albert.musiclive.models.Artist;

import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    private List<Artist> listArtist;

    ArtAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final FragmentTransaction ft =  getSupportFragmentManager().beginTransaction();
        final FragmentManager fragmentManager = getSupportFragmentManager();

        Fragment fragment;
        fragment = new SongListFragment();
        fragmentManager.beginTransaction().replace(R.id.flContainer,fragment).commit();
    }
}

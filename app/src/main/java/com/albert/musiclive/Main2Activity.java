package com.albert.musiclive;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.albert.musiclive.fragments.HomeFragment;
import com.albert.musiclive.fragments.PlayListFragment;
import com.albert.musiclive.fragments.ProfileFragment;
import com.albert.musiclive.fragments.SearchFragment;
import com.albert.musiclive.fragments.SongListFragment;
import com.albert.musiclive.models.Artist;
import com.albert.musiclive.tools.Serializer;

import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private BottomNavigationView bottomNavigationView;
    private List<Artist> listArtist;

    ArtAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final FragmentTransaction ft =  getSupportFragmentManager().beginTransaction();
        final FragmentManager fragmentManager = getSupportFragmentManager();
        //Artist artist = new Artist();
       // artist.setArtistId("");
       // Serializer.serialize("artist",artist,this);
        Intent i = getIntent();
        String artistId = i.getStringExtra("artistId");
        String artistName = i.getStringExtra("artistName");
       // Toast.makeText(this, artistId, Toast.LENGTH_SHORT).show();
        Fragment fragment;
        fragment = new SongListFragment();
        ((SongListFragment) fragment).setArtistId(artistId);
        ((SongListFragment) fragment).setArtistName(artistName);
        fragmentManager.beginTransaction().replace(R.id.flContainer,fragment).commit();

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment;
                switch(menuItem.getItemId()){

                    case R.id.action_home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.action_search:
                        fragment = new SearchFragment();

                        break;
                    case R.id.action_playlist:
                        fragment = new PlayListFragment();
                        break;
                    case R.id.action_profile:
                    default:
                        fragment = new ProfileFragment();
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.flContainer,fragment).commit();
                return true;
            }
        });
    }


}

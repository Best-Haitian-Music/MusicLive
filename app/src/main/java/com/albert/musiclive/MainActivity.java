package com.albert.musiclive;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.albert.musiclive.fragments.HomeFragment;
import com.albert.musiclive.fragments.PlayListFragment;
import com.albert.musiclive.fragments.ProfileFragment;
import com.albert.musiclive.fragments.SearchFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FragmentTransaction ft =  getSupportFragmentManager().beginTransaction();
        final FragmentManager fragmentManager = getSupportFragmentManager();

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
        // set default selection
        bottomNavigationView.setSelectedItemId(R.id.action_home);
    }


}

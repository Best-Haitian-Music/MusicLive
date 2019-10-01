package com.albert.musiclive.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.albert.musiclive.Adapters.ArtitsAdapter;
import com.albert.musiclive.Adapters.MusicAdapter;
import com.albert.musiclive.R;
import com.albert.musiclive.models.Artist;
import com.albert.musiclive.models.Song;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView recyclerView2;
    SearchView et_search;
    ImageButton ib_search;

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference table_artist = database.getReference("Artists");
    final DatabaseReference table_song = database.getReference("Songs");

    protected ArtitsAdapter adapte;
    private MusicAdapter musicAdapter;

    private List<Artist> listArtist;
    private List<Song> listSong;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        listArtist = new ArrayList<>();
        recyclerView = view.findViewById(R.id.rv_search);
       
        et_search = view.findViewById(R.id.et_search);

    }

    @Override
    public void onStart() {
        super.onStart();
        table_artist.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot dss:dataSnapshot.getChildren()){
                    Artist artist = dss.getValue(Artist.class);
                    artist.setArtistId(dss.getKey());
                    listArtist.add(artist);
                }
                ArtitsAdapter adapter = new ArtitsAdapter(getContext(),listArtist);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getContext(), ""+databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        if(et_search!=null){
            et_search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    search(s);
                    return true;
                }
            });
        }
    }

    private void search(String s) {

        ArrayList<Artist> list = new ArrayList<>();
        for (Artist object : listArtist){
            if(object.getName().toLowerCase().contains(s.toLowerCase())){
                list.add(object);
            }
        }
        ArtitsAdapter artitsAdapter = new ArtitsAdapter(getContext(),list);
        recyclerView.setAdapter(artitsAdapter);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        // Inflate the menu; this adds items to the action bar.

       // inflater.inflate(R.menu.menu_search, menu);
        // ...

    }


}

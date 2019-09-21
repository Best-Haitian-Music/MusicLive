package com.albert.musiclive.fragments;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.albert.musiclive.ArtistAdapter;
import com.albert.musiclive.LoginActivity;
import com.albert.musiclive.MainActivity;
import com.albert.musiclive.PostsAdapter;
import com.albert.musiclive.R;
import com.albert.musiclive.models.Artist;
import com.albert.musiclive.models.Song;
import com.albert.musiclive.models.User;
import com.albert.musiclive.tools.Serializer;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private Button mPlay;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    private List<Artist> listArtist;

    ArtistAdapter adapter;
    FirebaseStorage mStorage;
    FirebaseDatabase mDatabase;
    DatabaseReference databaseReference;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference table_artist = database.getReference("Artists");
    protected List<Artist> mPosts;
    protected PostsAdapter adapte;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.lv_artist);
      //  progressBar= view.findViewById(R.id.progress_circular);
       recyclerView.setHasFixedSize(true);



        listArtist = new ArrayList<>();
        adapte = new PostsAdapter(getContext(),listArtist);
        recyclerView.setAdapter(adapte);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        for(int i=0;i<=10;i++){
            Artist artist = new Artist();
            artist.setName("Iberdo"+i);
            artist.setNbreAbon(""+i);
            listArtist.add(artist);
        }

        adapte.notifyDataSetChanged();
      //  progressBar.setVisibility(View.GONE);
       /* table_artist.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listArtist.clear();
                for(DataSnapshot dss:dataSnapshot.getChildren()){
                    Artist artist = dss.getValue(Artist.class);
                    artist.setArtistId(dss.getKey());
                    listArtist.add(artist);

                }

                for(int i=0;i<=10;i++){
                    Artist artist = new Artist();
                    artist.setName("Iberdo");
                    listArtist.add(artist);
                }
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getContext(), ""+databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
        });*/


       /* mPlay = view.findViewById(R.id.btnPlay);

        mPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MediaPlayer mediaPlayer = new MediaPlayer();
                try{
                    mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/besthaitianmusic.appspot.com/o/Ido'T.mp3?alt=media&token=8f198c43-51b4-4450-82f4-62d74063ad26");
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            mp.start();
                        }
                    });
                    mediaPlayer.prepare();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        });*/

    }

   /*@Override
    public void onDestroy() {
        super.onDestroy();
        //table_artist.removeEventListener(valueEventListener);
    }*/
}

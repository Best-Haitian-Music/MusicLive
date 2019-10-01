package com.albert.musiclive.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.albert.musiclive.Adapters.MusicAdapter;
import com.albert.musiclive.R;
import com.albert.musiclive.models.Artist;
import com.albert.musiclive.models.PlayList;
import com.albert.musiclive.models.Song;
import com.albert.musiclive.models.User;
import com.albert.musiclive.tools.Serializer;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PlayListFragment extends Fragment {

    private RecyclerView recyclerView;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference table_song = database.getReference("Songs");
    final DatabaseReference table_playlist = database.getReference("PlayLists");
    ArrayList<Song> songArrayList;
    ArrayList<Artist> artistArrayList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_playlist, container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv);

        User user = (User) Serializer.deSerialize("saveUser",getContext());
        getSongArrayList(getPlayLists(user.getUserName()));

    }

    public ArrayList<PlayList> getPlayLists(final String userName){
        final ArrayList<PlayList> list = new ArrayList<>();
        table_playlist.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list.clear();
                for(DataSnapshot dss:dataSnapshot.getChildren()){
                    PlayList playList = dss.getValue(PlayList.class);
                    playList.setPlaylistId(dss.getKey());

                        if(userName.equals(playList.getUserId())){
                            list.add(playList);
                        }
                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getContext(), ""+databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        return list;
    }

    public void getSongArrayList(final ArrayList<PlayList> playLists){
        final ArrayList<Song> listSong = new ArrayList<>();
        table_song.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listSong.clear();
                for(DataSnapshot dss:dataSnapshot.getChildren()){
                    Song song = dss.getValue(Song.class);
                    song.setSongId(dss.getKey());
                    for (PlayList play:playLists){
                        if(song.getSongId().equals(play.getMusicId())){
                            listSong.add(song);
                        }
                    }


                }
                MusicAdapter adapter = new MusicAdapter(getContext(),listSong);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getContext(), ""+databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

}

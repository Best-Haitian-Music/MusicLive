package com.albert.musiclive.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.albert.musiclive.LoginActivity;
import com.albert.musiclive.R;
import com.albert.musiclive.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class ProfileFragment extends Fragment {
    private TextView tvUserName;
    private TextView tvNbreAbon;
    private ImageView ivEdit;
    //Init Firebase
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference table_user = database.getReference("Users");
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final User[] user1 = {new User()};
        table_user.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.child("Albert4940").exists()) {

                    //Get information
                    user1[0] = dataSnapshot.child("Albert4940").getValue(User.class);
                    tvUserName.setText(user1[0].getUserName());
                    tvNbreAbon.setText(user1[0].getNbreAbon());


                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}

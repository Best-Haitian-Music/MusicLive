package com.albert.musiclive.fragments;

import android.content.Intent;
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

import com.albert.musiclive.EditProfileActivity;
import com.albert.musiclive.LoginActivity;
import com.albert.musiclive.R;
import com.albert.musiclive.User;
import com.albert.musiclive.WelcomeActivity;
import com.albert.musiclive.tools.Serializer;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import static com.parse.Parse.getApplicationContext;

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

    public void startEdit(){

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final User[] user1 = {(User) Serializer.deSerialize("saveUser", getContext())};
        tvUserName = view.findViewById(R.id.tvUserName);
        tvNbreAbon = view.findViewById(R.id.tvNbreAbon);
        ivEdit = view.findViewById(R.id.ivEdit);
        //tvUserName.setText("Yow");
        table_user.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.child( user1[0].getUserName()).exists()) {

                    //Get information
                    user1[0] = dataSnapshot.child(user1[0].getUserName()).getValue(User.class);
                    tvUserName.setText(user1[0].getName());
                    tvNbreAbon.setText(user1[0].getNbreAbon());

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        ivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(RegistrationActivity.this, "Nap Travay sou Fonctyonalite sa", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getContext(), EditProfileActivity.class);
                startActivity(i);
            }
        });

    }


}

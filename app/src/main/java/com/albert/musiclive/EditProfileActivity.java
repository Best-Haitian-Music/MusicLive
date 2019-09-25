package com.albert.musiclive;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.albert.musiclive.models.User;
import com.albert.musiclive.tools.Serializer;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditProfileActivity extends AppCompatActivity {
    private TextView ivImage;
    private EditText name;
    private EditText phone;
    private EditText email;
    private EditText etUserName;
    private EditText etPassWord;
    private Button btnSave;
    private static String idUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        ivImage=findViewById(R.id.imageView);
        //Init Firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("Users");

      //  ivImage.setBackground(Drawable.createFromPath("/drawable/ic_person_black_24dp.xml"));
    name=findViewById(R.id.etName);
        phone=findViewById(R.id.etPhone);
        email = findViewById(R.id.etEmail);
        etUserName=findViewById(R.id.etUserName);
        etPassWord=findViewById(R.id.etPassWord);
        btnSave=findViewById(R.id.btnSave);

        User user = (User) Serializer.deSerialize("saveUser",this);
        idUser = user.getUserName();

        name.setText(user.getName());
        phone.setText(user.getPhone());
        email.setText(user.getEmail());
        etUserName.setText(user.getUserName());
        etPassWord.setText(user.getPassword());



        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String mName = name.getText().toString();
                final String mPhone = phone.getText().toString();
                final String mEmail = email.getText().toString();
                final String user = etUserName.getText().toString();
                final String pass = etPassWord.getText().toString();

                final ProgressDialog mDialog = new ProgressDialog(EditProfileActivity.this);
                mDialog.setMessage("Please waiting....");
                mDialog.show();


                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        //check if already user
                        if(dataSnapshot.child(idUser).exists()){
                            mDialog.dismiss();
                            //Toast.makeText(EditProfileActivity.this, "UserName already register ", Toast.LENGTH_SHORT).show();


                            mDialog.dismiss();
                            User user1 = new User(mName,pass,mPhone,mEmail,"","",user,"","","");
                            table_user.child(idUser).setValue(user1);
                            Toast.makeText(EditProfileActivity.this, "Update successfully !", Toast.LENGTH_SHORT).show();
                            Serializer.serialize("saveUser",user1,EditProfileActivity.this);
                            Intent i = new Intent(getBaseContext(),MainActivity.class);
                            startActivity(i);
                            finish();

                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


            }
        });
    }
}

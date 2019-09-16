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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegistrationActivity extends AppCompatActivity {
    private EditText name;
    private EditText phone;
    private EditText email;
    private EditText etUserName;
    private EditText etPassWord;
    private Button btnSignUp;
    private TextView tvCreate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        name=findViewById(R.id.etName);
        phone=findViewById(R.id.etPhone);
        email = findViewById(R.id.etEmail);
        etUserName=findViewById(R.id.etUserName);
        etPassWord=findViewById(R.id.etPassWord);
        btnSignUp=findViewById(R.id.btnSignUp);
        tvCreate=findViewById(R.id.tvCreate);

        //Init Firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("user");


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String mName = name.getText().toString();
                final String mPhone = phone.getText().toString();
                final String mEmail = email.getText().toString();
                final String user = etUserName.getText().toString();
                final String pass = etPassWord.getText().toString();
                final ProgressDialog mDialog = new ProgressDialog(RegistrationActivity.this);
                mDialog.setMessage("Please waiting....");
                mDialog.show();


                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        //check if already user
                        if(dataSnapshot.child(user).exists()){
                            mDialog.dismiss();
                            Toast.makeText(RegistrationActivity.this, "UserName already register ", Toast.LENGTH_SHORT).show();
                        }else {

                            mDialog.dismiss();
                            User user1 = new User(user,pass);
                            table_user.child(user).setValue(user1);
                            Toast.makeText(RegistrationActivity.this, "Sign Up successfully !", Toast.LENGTH_SHORT).show();
                            

                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                //Toast.makeText(RegistrationActivity.this, "Nap Travay sou Fonktyonalite sa", Toast.LENGTH_SHORT).show();
            }
        });

        tvCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(RegistrationActivity.this, "Nap Travay sou Fonctyonalite sa", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getBaseContext(), HomeActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}

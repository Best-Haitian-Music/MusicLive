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

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private EditText etUserName;
    private EditText etPassWord;
    private Button btnLogin;
    private TextView tvCreate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUserName=findViewById(R.id.etUserName);
        etPassWord=findViewById(R.id.etPassWord);
        btnLogin=findViewById(R.id.btnLogin);
        tvCreate=findViewById(R.id.tvCreate);

        //Init Firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("user");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String user = etUserName.getText().toString();
                final String pass = etPassWord.getText().toString();

                final ProgressDialog mDialog = new ProgressDialog(LoginActivity.this);
                mDialog.setMessage("Please waiting....");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if(dataSnapshot.child(user).exists()) {

                            mDialog.dismiss();

                            //Get information
                            User user1 = dataSnapshot.child(user).getValue(User.class);

                            if (user1.getPassword().equals(pass)) {
                                Toast.makeText(LoginActivity.this, "Sign in successfully !", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(LoginActivity.this, "Wrong password !", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            mDialog.dismiss();
                            Toast.makeText(LoginActivity.this, "User not exist in database ", Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                // Toast.makeText(HomeActivity.this, "Nap Travay sou Fonktyonalite sa", Toast.LENGTH_SHORT).show();
            }
        });

        tvCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Toast.makeText(HomeActivity.this, "Nap Travay sou Fonctyonalite sa", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getBaseContext(),RegistrationActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}

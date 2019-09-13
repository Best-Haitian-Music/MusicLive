package com.albert.musiclive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mName = name.getText().toString();
                String mPhone = phone.getText().toString();
                String mEmail = email.getText().toString();
                String user = etUserName.getText().toString();
                String pass = etPassWord.getText().toString();
                Toast.makeText(RegistrationActivity.this, "Nap Travay sou Fonktyonalite sa", Toast.LENGTH_SHORT).show();
            }
        });

        tvCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(RegistrationActivity.this, "Nap Travay sou Fonctyonalite sa", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getBaseContext(),MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}

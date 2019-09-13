package com.albert.musiclive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private EditText etUserName;
    private EditText etPassWord;
    private Button btnLogin;
    private TextView tvCreate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUserName=findViewById(R.id.etUserName);
        etPassWord=findViewById(R.id.etPassWord);
        btnLogin=findViewById(R.id.btnLogin);
        tvCreate=findViewById(R.id.tvCreate);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = etUserName.getText().toString();
                String pass = etPassWord.getText().toString();
                Toast.makeText(MainActivity.this, "Nap Travay sou Fonktyonalite sa", Toast.LENGTH_SHORT).show();
            }
        });

        tvCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // Toast.makeText(MainActivity.this, "Nap Travay sou Fonctyonalite sa", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getBaseContext(),RegistrationActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}

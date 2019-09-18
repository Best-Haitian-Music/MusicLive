package com.albert.musiclive;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class EditProfileActivity extends AppCompatActivity {
    private TextView ivImage;
    private EditText name;
    private EditText phone;
    private EditText email;
    private EditText etUserName;
    private EditText etPassWord;
    private Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        ivImage=findViewById(R.id.imageView);

        ivImage.setBackground(Drawable.createFromPath("/drawable/ic_person_black_24dp.xml"));
    /*name=findViewById(R.id.etName);
        phone=findViewById(R.id.etPhone);
        email = findViewById(R.id.etEmail);
        etUserName=findViewById(R.id.etUserName);
        etPassWord=findViewById(R.id.etPassWord);
        btnSave=findViewById(R.id.btnSave);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String mName = name.getText().toString();
                final String mPhone = phone.getText().toString();
                final String mEmail = email.getText().toString();
                final String user = etUserName.getText().toString();
                final String pass = etPassWord.getText().toString();
            }
        });*/
    }
}

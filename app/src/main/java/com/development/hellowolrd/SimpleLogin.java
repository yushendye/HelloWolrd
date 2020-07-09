package com.development.hellowolrd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SimpleLogin extends AppCompatActivity {
    //EditText object declaration
    EditText edt_username, edt_password;

    //Button object
    Button btn_login_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_login);

        edt_username = findViewById(R.id.edt_username);
        edt_password = findViewById(R.id.edt_password);

        btn_login_btn = findViewById(R.id.btn_login);


        btn_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edt_username.getText().toString();
                Intent loginIntent = new Intent(SimpleLogin.this,UserLoggedin.class);
                loginIntent.putExtra("username", username);
                startActivity(loginIntent);
            }
        });

    }
}
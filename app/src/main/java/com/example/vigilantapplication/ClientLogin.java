package com.example.vigilantapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ClientLogin extends AppCompatActivity {

    Button goToButton;
    TextView registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_login);

        goToButton = findViewById(R.id.account_switch_button);
        registerButton = findViewById(R.id.register_button);
        goToButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClientLogin.this, OfficerLogin.class);
                startActivity(intent);
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClientLogin.this, ClientRegistration.class);
                startActivity(intent);
            }
        });
    }
}
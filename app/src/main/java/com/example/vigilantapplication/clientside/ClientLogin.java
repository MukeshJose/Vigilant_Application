package com.example.vigilantapplication.clientside;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.vigilantapplication.R;
import com.example.vigilantapplication.officerside.OfficerLogin;

public class ClientLogin extends AppCompatActivity {

    Button goToButton, loginButton;
    TextView registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_login);

        goToButton = findViewById(R.id.bt_account_switch_button);
        registerButton = findViewById(R.id.tv_register_button);
        loginButton = findViewById(R.id.bt_login_button);
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

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClientLogin.this, ClientComplainForm.class);
                startActivity(intent);
            }
        });
    }
}
package com.example.vigilantapplication.officerside;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vigilantapplication.OfficersHomeFragment;
import com.example.vigilantapplication.OfficersMainActivity;
import com.example.vigilantapplication.R;

public class OfficerLogin extends AppCompatActivity {

    private Button btLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_officer_login);
        initView();

        btLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OfficersMainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        btLoginButton = findViewById(R.id.bt_login_button);
    }
}
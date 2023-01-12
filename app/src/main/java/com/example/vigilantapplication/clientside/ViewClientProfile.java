package com.example.vigilantapplication.clientside;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vigilantapplication.R;

public class ViewClientProfile extends AppCompatActivity {

    private Button btEditProfileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_client_profile);
        initView();

        btEditProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewClientProfile.this, EditClientProfile.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        btEditProfileButton = findViewById(R.id.bt_edit_profile_button);
    }
}
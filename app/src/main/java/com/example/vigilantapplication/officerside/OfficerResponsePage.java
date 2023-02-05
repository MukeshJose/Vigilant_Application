package com.example.vigilantapplication.officerside;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vigilantapplication.R;

public class OfficerResponsePage extends AppCompatActivity {

    private Button btResponseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_officer_response_page);
        initView();

        btResponseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OfficerResponsePage.this, OfficerComplainView.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        btResponseButton = findViewById(R.id.bt_response_button);
    }
}
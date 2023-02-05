package com.example.vigilantapplication.officerside;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vigilantapplication.R;

public class OfficerComplainView extends AppCompatActivity {

    private Button btStatusUpdateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_officer_complain_view);
        initView();
        btStatusUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OfficerStatusUpdate.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        btStatusUpdateButton = findViewById(R.id.bt_status_update_button);
    }
}
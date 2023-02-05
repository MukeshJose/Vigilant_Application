package com.example.vigilantapplication.clientside;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vigilantapplication.R;

public class ClientRegistration extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    String[] IdTypes = {"--Select an ID--", "Aadhar card", "Driving License", "Pan Card"};
    private Button btRegisterButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_registration);

        spinner = findViewById(R.id.sp_id_type);
        spinner.setOnItemSelectedListener(ClientRegistration.this);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, IdTypes);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        initView();

        btRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(ClientRegistration.this, ViewClientProfile.class);
//                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void initView() {
        btRegisterButton = findViewById(R.id.bt_register_button);
    }
}
package com.example.vigilantapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ClientRegistration extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    String[] IdTypes = {"--Select an ID--", "Aadhar card", "Driving License", "Pan Card"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_registration);

        spinner = findViewById(R.id.id_type);
        spinner.setOnItemSelectedListener(ClientRegistration.this);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, IdTypes);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
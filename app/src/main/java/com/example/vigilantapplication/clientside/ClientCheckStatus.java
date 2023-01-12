package com.example.vigilantapplication.clientside;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vigilantapplication.Adapters.ClientCheckStatusAdapter;
import com.example.vigilantapplication.R;

public class ClientCheckStatus extends AppCompatActivity {

    private RecyclerView rvCheckStatusView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_check_status);
        initView();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rvCheckStatusView.setLayoutManager(layoutManager);
        ClientCheckStatusAdapter clientCheckStatusAdapter = new ClientCheckStatusAdapter(getApplicationContext());
        rvCheckStatusView.setAdapter(clientCheckStatusAdapter);
    }

    private void initView() {
        rvCheckStatusView = findViewById(R.id.rv_check_status_view);
    }
}
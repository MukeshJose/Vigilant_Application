package com.example.vigilantapplication.clientside;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vigilantapplication.Adapters.AllComplaintAdapter;
import com.example.vigilantapplication.R;
import com.example.vigilantapplication.model.Root;
import com.example.vigilantapplication.retrofit.APIClient;
import com.example.vigilantapplication.retrofit.APIInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllComplaintsActivity extends AppCompatActivity {

    private RecyclerView rvAllComplaintView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_complaints);

        APIInterface api_all_complaints = APIClient.getClient().create(APIInterface.class);

        SharedPreferences preferences = getSharedPreferences("myShared", MODE_PRIVATE);
        String data = preferences.getString("key1", "default");
        Toast.makeText(this, data + "hellowww", Toast.LENGTH_SHORT).show();

        api_all_complaints.CALL_APIAllComplaint(data).enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                if (response.isSuccessful()) {
                    Root root = response.body();
                    if (root.status) {
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                        rvAllComplaintView.setLayoutManager(linearLayoutManager);
                        AllComplaintAdapter allComplaintAdapter = new AllComplaintAdapter(getApplicationContext(), root);
                        rvAllComplaintView.setAdapter(allComplaintAdapter);
                    }else{
                        Toast.makeText(AllComplaintsActivity.this, "all complaints failed", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(AllComplaintsActivity.this, "allComplaintsFailed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                Toast.makeText(AllComplaintsActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
        initView();
    }

    private void initView() {
        rvAllComplaintView = findViewById(R.id.rv_all_complaint_view);
    }
}
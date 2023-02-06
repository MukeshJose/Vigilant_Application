package com.example.vigilantapplication.officerside;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vigilantapplication.OfficersMainActivity;
import com.example.vigilantapplication.R;
import com.example.vigilantapplication.model.Root;
import com.example.vigilantapplication.retrofit.APIClient;
import com.example.vigilantapplication.retrofit.APIInterface;
import com.google.android.material.textfield.TextInputEditText;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OfficerLogin extends AppCompatActivity {

    private Button btLoginButton;
    @NotEmpty
    private TextInputEditText etIdentification;
    @NotEmpty
    @Password
    private TextInputEditText etPassword;
    private Button btAccountSwitchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_officer_login);
        initView();

        APIInterface api_officer_login = APIClient.getClient().create(APIInterface.class);

        btLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OfficersMainActivity.class);
                startActivity(intent);

                api_officer_login.CALL_APIOfficerLogin(etIdentification.getText().toString(), etPassword.getText().toString(), "ajshgbdjahsg").enqueue(new Callback<Root>() {
                    @Override
                    public void onResponse(Call<Root> call, Response<Root> response) {
                        if (response.isSuccessful()) {
                            Root root = response.body();
                            if (root.status) {
                                startActivity(new Intent(OfficerLogin.this, OfficersMainActivity.class));
                                Toast.makeText(OfficerLogin.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(OfficerLogin.this, "Login Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<Root> call, Throwable t) {
                        Toast.makeText(OfficerLogin.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void initView() {
        btLoginButton = findViewById(R.id.bt_login_button);
        etIdentification = findViewById(R.id.et_identification);
        etPassword = findViewById(R.id.et_password);
        btAccountSwitchButton = findViewById(R.id.bt_account_switch_button);
    }
}
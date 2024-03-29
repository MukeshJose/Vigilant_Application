package com.example.vigilantapplication.clientside;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.vigilantapplication.ClientProfileViewFragment;
import com.example.vigilantapplication.MainActivity;
import com.example.vigilantapplication.R;
import com.example.vigilantapplication.model.Root;
import com.example.vigilantapplication.officerside.OfficerLogin;
import com.example.vigilantapplication.retrofit.APIClient;
import com.example.vigilantapplication.retrofit.APIInterface;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClientLogin extends AppCompatActivity {


    private TextView tvForgotPassword;
    private Button btLoginButton;
    private TextView tvRegisterButton;
    private CardView cvAccountSwitchButton;
    @NotEmpty
    private TextInputEditText phoneNumber;
    @NotEmpty
    @Password
    private TextInputEditText password;
    String device_token = "jshfbvjshvjfdhvaj";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity_login);
        tvRegisterButton = findViewById(R.id.tv_register_button);
        btLoginButton = findViewById(R.id.bt_login_button);
        initView();


        cvAccountSwitchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClientLogin.this, OfficerLogin.class);
                startActivity(intent);
            }
        });

        tvRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClientLogin.this, ClientRegistration.class);
                startActivity(intent);
            }
        });

        btLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences share = getSharedPreferences("myShared", MODE_PRIVATE);
                SharedPreferences.Editor edit = share.edit();
                edit.putString("key1", phoneNumber.getText().toString());
                edit.commit();
                Toast.makeText(getApplicationContext(), "saved", Toast.LENGTH_SHORT).show();
                ClientProfileViewFragment clientProfileViewFragmentNew = new ClientProfileViewFragment(phoneNumber.getText().toString(), password.getText().toString(), device_token);
                APIInterface api_login = APIClient.getClient().create(APIInterface.class);
                api_login.CALL_APIUserLogin(phoneNumber.getText().toString(), password.getText().toString(), device_token).enqueue(new Callback<Root>() {


                    @Override
                    public void onResponse(Call<Root> call, Response<Root> response) {
                        if (response.isSuccessful()) {
                            Root root = response.body();
                            if (root.status) {
                                startActivity(new Intent(ClientLogin.this, MainActivity.class));
                            } else {
                                Toast.makeText(ClientLogin.this, "Login Failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(ClientLogin.this, "error", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Root> call, Throwable t) {
                        Toast.makeText(ClientLogin.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        initView();
    }


    private void initView() {

        tvForgotPassword = (TextView) findViewById(R.id.tv_forgot_password);
        btLoginButton = (Button) findViewById(R.id.bt_login_button);
        tvRegisterButton = (TextView) findViewById(R.id.tv_register_button);
        cvAccountSwitchButton = (CardView) findViewById(R.id.cv_account_switch_button);
        phoneNumber = (TextInputEditText) findViewById(R.id.et_phone_number);
        password = (TextInputEditText) findViewById(R.id.et_password);

    }


}
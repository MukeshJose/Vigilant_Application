package com.example.vigilantapplication.clientside;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.vigilantapplication.R;
import com.example.vigilantapplication.model.Root;
import com.example.vigilantapplication.retrofit.APIClient;
import com.example.vigilantapplication.retrofit.APIInterface;
import com.google.android.material.textfield.TextInputEditText;
import com.mobsandgeeks.saripaar.annotation.ConfirmPassword;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClientRegistration extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] IdTypes = {"--Select an ID--", "Aadhar card", "Driving License", "Pan Card"};
    private Button btRegisterButton;
    private CardView cvDisplayImage;
    private CardView cvDpEditButton;
    @NotEmpty
    private TextInputEditText etUserName;
    @NotEmpty
    private Spinner spIdType;
    @NotEmpty
    private TextInputEditText etIdNumber;
    @NotEmpty
    private TextInputEditText etAddress;
    @NotEmpty
    @Email
    private TextInputEditText etEmailId;
    @NotEmpty
    private TextInputEditText etPhoneNumber;
    @NotEmpty
    @Password
    private TextInputEditText etPassword;
    @NotEmpty
    @ConfirmPassword
    private TextInputEditText etConfirmPassword;
    String id_type_selection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_registration);

        initView();
        spIdType.setOnItemSelectedListener(ClientRegistration.this);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, IdTypes);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spIdType.setAdapter(adapter);


        btRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(ClientRegistration.this, ViewClientProfile.class);
//                startActivity(intent);

                RequestBody name = RequestBody.create(MediaType.parse("text/plain"), etUserName.getText().toString());
                RequestBody phone = RequestBody.create(MediaType.parse("text/plain"), etPhoneNumber.getText().toString());
                RequestBody email = RequestBody.create(MediaType.parse("text/plain"), etEmailId.getText().toString());
                RequestBody password = RequestBody.create(MediaType.parse("text/plain"), etPassword.getText().toString());
                RequestBody address = RequestBody.create(MediaType.parse("text/plain"), etAddress.getText().toString());
                RequestBody id_type = RequestBody.create(MediaType.parse("text/plain"), id_type_selection);
                RequestBody id_number = RequestBody.create(MediaType.parse("text/plain"), etIdNumber.getText().toString());

                APIInterface api_registration = APIClient.getClient().create(APIInterface.class);

                api_registration.CALL_APIRegistration(name, email, phone, password, address, id_type, id_number).enqueue(new Callback<Root>() {
                    @Override
                    public void onResponse(Call<Root> call, Response<Root> response) {
                        if (response.isSuccessful()) {
                            Root root = response.body();
                            if (root.status) {
                                Toast.makeText(ClientRegistration.this, "Registration is Successful", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(ClientRegistration.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(ClientRegistration.this, "Reg error", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Root> call, Throwable t) {
                        Toast.makeText(ClientRegistration.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        id_type_selection = IdTypes[i];
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Toast.makeText(this, "Please select an option", Toast.LENGTH_SHORT).show();

    }

    private void initView() {
        btRegisterButton = findViewById(R.id.bt_register_button);
        cvDisplayImage = findViewById(R.id.cv_display_image);
        cvDpEditButton = findViewById(R.id.cv_dp_edit_button);
        etUserName = findViewById(R.id.et_user_name);
        spIdType = findViewById(R.id.sp_id_type);
        etIdNumber = findViewById(R.id.et_id_number);
        etAddress = findViewById(R.id.et_address);
        etEmailId = findViewById(R.id.et_email_id);
        etPhoneNumber = findViewById(R.id.et_phone_number);
        etPassword = findViewById(R.id.et_password);
        etConfirmPassword = findViewById(R.id.et_confirm_password);
    }
}
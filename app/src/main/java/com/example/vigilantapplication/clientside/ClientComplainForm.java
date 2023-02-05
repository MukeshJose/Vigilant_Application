package com.example.vigilantapplication.clientside;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.example.vigilantapplication.ClientHomeFragment;
import com.example.vigilantapplication.MainActivity;
import com.example.vigilantapplication.R;
import com.google.android.material.textfield.TextInputLayout;

public class ClientComplainForm extends AppCompatActivity {

    private RelativeLayout heading;
    private TextView tvGoBackButton;
    private TextView tvHelpButton;
    private TextInputLayout etComplaintSubject;
    private TextInputLayout etOfficeType;
    private TextInputLayout etOfficeLocation;
    private TextInputLayout etAccusedName;
    private EditText etDescriptionBox;
    private TextView tvPhotoUploadQuery;
    private ImageView ivPhotoUpload;
    private TextInputLayout etContactNumber;
    private TextView tvComplainerIdentity;
    private SwitchCompat sbSwitchButton;
    private Button btAddComplaintButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_complain_form);
        initView();

        tvHelpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClientComplainForm.this, ClientCheckStatus.class);
                startActivity(intent);
            }
        });

        btAddComplaintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        heading = findViewById(R.id.heading);
        tvGoBackButton = findViewById(R.id.tv_goBack_button);
        tvHelpButton = findViewById(R.id.tv_help_button);
        etComplaintSubject = findViewById(R.id.et_complaint_subject);
        etOfficeType = findViewById(R.id.et_office_type);
        etOfficeLocation = findViewById(R.id.et_office_location);
        etAccusedName = findViewById(R.id.et_accused_name);
        etDescriptionBox = findViewById(R.id.et_description_box);
        tvPhotoUploadQuery = findViewById(R.id.tv_photo_upload_query);
        ivPhotoUpload = findViewById(R.id.iv_photo_upload);
        etContactNumber = findViewById(R.id.et_contact_number);
        tvComplainerIdentity = findViewById(R.id.tv_complainer_identity);
        sbSwitchButton = findViewById(R.id.sb_switch_button);
        btAddComplaintButton = findViewById(R.id.bt_add_complaint_button);
    }
}
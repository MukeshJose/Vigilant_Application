package com.example.vigilantapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.vigilantapplication.model.Root;
import com.example.vigilantapplication.retrofit.APIClient;
import com.example.vigilantapplication.retrofit.APIInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ClientProfileViewFragment extends Fragment {


    private CardView cvDisplayImage;
    private TextView tvUserName;
    private TextView tvIdType;
    private TextView tvIdNumber;
    private TextView tvPhoneNumber;
    private Button btEditProfileButton;

    public ClientProfileViewFragment() {
    }

    static String phoneNumber, passWord, deviceToken;

    public ClientProfileViewFragment(String phone_number, String pass_word, String device_token) {
        phoneNumber = phone_number;
        passWord = pass_word;
        deviceToken = device_token;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_client_profile_view, container, false);
        initView(view);

        APIInterface api_profile_display = APIClient.getClient().create(APIInterface.class);
        api_profile_display.CALL_APIUserLogin(phoneNumber, passWord, deviceToken).enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                if (response.isSuccessful()) {
                    Root root = response.body();
                    if (root.status) {
                        tvUserName.setText(root.driverDetails.get(0).name);
                    }
                }
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private void initView(View view) {
        cvDisplayImage = view.findViewById(R.id.cv_display_image);
        tvUserName = view.findViewById(R.id.tv_user_name);
        tvIdType = view.findViewById(R.id.tv_id_type);
        tvIdNumber = view.findViewById(R.id.tv_id_number);
        tvPhoneNumber = view.findViewById(R.id.tv_phone_number);
        btEditProfileButton = view.findViewById(R.id.bt_edit_profile_button);
    }
}
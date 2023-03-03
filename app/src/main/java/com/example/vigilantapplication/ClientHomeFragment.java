package com.example.vigilantapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.vigilantapplication.clientside.AllComplaintsActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class ClientHomeFragment extends Fragment {

    private RelativeLayout rlPageHeading;
    private TextView tvHomeHeading;
    private ImageView tvSettingsButton;
    private RelativeLayout rlMainSection;
    private CardView cvAddComplaint;
    private ImageView ivAddComplaint;
    private CardView cvCheckStatus;
    private ImageView ivCheckStatus;
    private CardView cvHistory;
    private ImageView ivHistory;
    private CardView cvContacts;
    private ImageView ivContacts;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_client_home, container, false);
        initView(view);

        cvHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "going to all complaint", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), AllComplaintsActivity.class);
                startActivity(intent);

            }
        });
        // Inflate the layout for this fragment
        return view;
    }

    private void initView(View view) {
        rlPageHeading = view.findViewById(R.id.rl_page_heading);
        tvHomeHeading = view.findViewById(R.id.tv_home_heading);
        tvSettingsButton = view.findViewById(R.id.tv_settings_button);
        rlMainSection = view.findViewById(R.id.rl_main_section);
        cvAddComplaint = view.findViewById(R.id.cv_add_complaint);
        ivAddComplaint = view.findViewById(R.id.iv_add_complaint);
        cvCheckStatus = view.findViewById(R.id.cv_check_status);
        ivCheckStatus = view.findViewById(R.id.iv_check_status);
        cvHistory = view.findViewById(R.id.cv_history);
        ivHistory = view.findViewById(R.id.iv_history);
        cvContacts = view.findViewById(R.id.cv_contacts);
        ivContacts = view.findViewById(R.id.iv_contacts);
    }
}
package com.example.vigilantapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class OfficersHomeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        AllComplaintFragment allComplaintFragment = new AllComplaintFragment();

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_officer_home_page, allComplaintFragment);
        fragmentTransaction.commit();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_officers_home, container, false);
    }
}
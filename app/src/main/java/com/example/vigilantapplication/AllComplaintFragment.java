package com.example.vigilantapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vigilantapplication.Adapters.AllComplaintAdapter;


public class AllComplaintFragment extends Fragment {
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_all_complaint, container, false);

        recyclerView = view.findViewById(R.id.rv_all_complaint);
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
//        recyclerView.setLayoutManager(layoutManager);
//        AllComplaintAdapter allComplaintAdapter = new AllComplaintAdapter(getActivity());
//        recyclerView.setAdapter(allComplaintAdapter);
        return view;
    }
}
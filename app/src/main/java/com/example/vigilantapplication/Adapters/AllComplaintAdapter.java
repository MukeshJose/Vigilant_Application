package com.example.vigilantapplication.Adapters;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vigilantapplication.R;
import com.example.vigilantapplication.model.Root;
import com.example.vigilantapplication.retrofit.APIClient;
import com.example.vigilantapplication.retrofit.APIInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllComplaintAdapter extends RecyclerView.Adapter<AllComplaintAdapter.MyViewHolder> {
    Context context;
    Root root;


    public AllComplaintAdapter(Context context, Root root) {
        this.context = context;
        this.root = root;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_complaint_custom_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.tvDateAllComplaint.setText(root.driverHistory.get(position).date);
        holder.tvTitleAllComplaint.setText(root.driverHistory.get(position).suspectName);
        holder.tvOfficeTypeAllComplaint.setText(root.driverHistory.get(position).description);
    }

    @Override
    public int getItemCount() {
        return root.driverHistory.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvDateAllComplaint;
        TextView tvTitleAllComplaint;
        TextView tvOfficeTypeAllComplaint;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDateAllComplaint = itemView.findViewById(R.id.tv_date_all_fragment);
            tvTitleAllComplaint = itemView.findViewById(R.id.tv_title_all_complaint);
            tvOfficeTypeAllComplaint = itemView.findViewById(R.id.tv_office_type_all_complaint);
        }
    }
}

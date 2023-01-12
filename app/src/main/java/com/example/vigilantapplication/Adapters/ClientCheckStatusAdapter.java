package com.example.vigilantapplication.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vigilantapplication.R;
import com.example.vigilantapplication.officerside.OfficerResponsePage;

public class ClientCheckStatusAdapter extends RecyclerView.Adapter<ClientCheckStatusAdapter.MyViewHolder> {
    public ClientCheckStatusAdapter(Context context) {
        this.context = context;
    }

    Context context;
    String[] names = {"name1", "name2"};

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.client_check_status_custom_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.titleCheck.setText(names[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, OfficerResponsePage.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView titleCheck;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleCheck = itemView.findViewById(R.id.tv_title_check);
        }
    }
}

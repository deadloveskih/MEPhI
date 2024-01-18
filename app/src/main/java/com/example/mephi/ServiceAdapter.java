package com.example.mephi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ViewHolder> {
    Context context;
    ArrayList<Service> ServicesPacks;

    public ServiceAdapter(Context context, ArrayList<Service> ServicesPacks) {
        this.context = context;
        this.ServicesPacks = ServicesPacks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.service_first_pack, parent, false);
        return new ServiceAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Service service = ServicesPacks.get(position);
        holder.heading.setText(service.Header);
    }

    @Override
    public int getItemCount() {
        return ServicesPacks.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView heading;

        public ViewHolder(View itemView) {
            super(itemView);
            heading = itemView.findViewById(R.id.Header);
        }
    }
}
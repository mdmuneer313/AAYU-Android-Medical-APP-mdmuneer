package com.example.muneer.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muneer.Model.Aid;
import com.example.muneer.R;

import java.util.ArrayList;

public class AidAdapter  extends RecyclerView.Adapter<AidAdapter.MyViewHolder>{
ArrayList<Aid> aidlist;
    Context context;
    public AidAdapter(Context c,ArrayList<Aid> a)
    {
        context=c;
        aidlist =a;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.diseas_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final String diseasename= aidlist.get(position).getDiseasname();
        final String drugname= aidlist.get(position).getDrugname();
        final String description= aidlist.get(position).getDescripition();
        final String hints= aidlist.get(position).getHints();

        holder.Diseasname.setText(aidlist.get(position).getDiseasname());

    }

    @Override
    public int getItemCount() {
        return aidlist.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView Diseasname;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Diseasname=itemView.findViewById(R.id.Diseasnameid1);
        }
    }
}

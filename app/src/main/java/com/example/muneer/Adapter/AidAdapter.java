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
ArrayList<Aid> Aidlist;
    Context context;
    public AidAdapter(Context c,ArrayList<Aid> a)
    {
        context=c;
        Aidlist=a;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.aid_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final String diseasename=Aidlist.get(position).getDiseasname();
        final String drugname=Aidlist.get(position).getDrugname();
        final String description=Aidlist.get(position).getDescription();
        final String hints=Aidlist.get(position).getHints();


        holder.Diseasname.setText(Aidlist.get(position).getDiseasname());

    }

    @Override
    public int getItemCount() {
        return Aidlist.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView Diseasname;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Diseasname=itemView.findViewById(R.id.diseasnameid);
        }
    }
}

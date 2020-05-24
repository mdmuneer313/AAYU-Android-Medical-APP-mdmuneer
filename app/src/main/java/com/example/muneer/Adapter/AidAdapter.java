package com.example.muneer.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    class MyViewHolder extends RecyclerView.ViewHolder
    {

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

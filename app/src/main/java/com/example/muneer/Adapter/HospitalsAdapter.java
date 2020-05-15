package com.example.muneer.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muneer.Model.Hospital;
import com.example.muneer.R;

import java.util.ArrayList;


public class HospitalsAdapter extends RecyclerView.Adapter<HospitalsAdapter.MyViewHolder>{
Context context;
ArrayList<Hospital> hospitals;
public HospitalsAdapter(Context c, ArrayList<Hospital> h)
{
    context=c;
    hospitals=h;

}

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.hospials_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.hspName.setText(hospitals.get(position).getHpname());
        holder.hspCity.setText(hospitals.get(position).getCity());
        holder.hspAddress.setText(hospitals.get(position).getAddress());
        holder.hspRating.setText(hospitals.get(position).getHprating());
        holder.hspContact_no.setText(hospitals.get(position).getContact_No());



    }

    @Override
    public int getItemCount() {
        return hospitals.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
{
    TextView hspName,hspAddress,hspCity,hspContact_no,hspRating;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        hspName=itemView.findViewById(R.id.Hpname);
        hspCity=itemView.findViewById(R.id.Hpcity);
        hspAddress=itemView.findViewById(R.id.Hpaddress);
        hspRating=itemView.findViewById(R.id.Hprating);
        hspContact_no=itemView.findViewById(R.id.HpContact_no);



    }
}





}

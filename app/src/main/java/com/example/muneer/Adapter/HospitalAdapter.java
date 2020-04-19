package com.example.muneer.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muneer.Model.Hospital;
import com.example.muneer.R;

import java.util.List;

public class HospitalAdapter extends RecyclerView.Adapter<HospitalAdapter.ViewHolder> {

    private List<Hospital> mHospital;
    private Context mContext;
    public HospitalAdapter(Context mContext, List<Hospital> mHospital){
        this.mHospital = mHospital;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.hospials_item,parent,false);

        return new HospitalAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Hospital hospital = mHospital.get(position);
        holder.HospitalName.setText(hospital.getHpname());
        holder.HospitalCity.setText(hospital.getCity());
        //holder.HospitalRating.setRating(home.getHprating());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView HospitalName;
        public TextView HospitalCity;
        public RatingBar HospitalRating;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            HospitalName= itemView.findViewById(R.id.Hpname);
            HospitalCity=itemView.findViewById(R.id.Hpcity);
            HospitalRating=itemView.findViewById(R.id.Hprating);
        }
    }
}

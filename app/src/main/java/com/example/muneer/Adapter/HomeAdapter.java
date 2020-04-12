package com.example.muneer.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muneer.Model.Home;
import com.example.muneer.R;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private List<Home> mHome;
    private Context mContext;
    public HomeAdapter(Context mContext, List<Home> mHome){
        this.mHome = mHome;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.hospials_item,parent,false);

        return new HomeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Home home=mHome.get(position);
        holder.HospitalName.setText(home.getHpname());
        holder.HospitalCity.setText(home.getCity());
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

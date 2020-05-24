package com.example.muneer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muneer.Adapter.AidAdapter;
import com.example.muneer.Adapter.HospitalsAdapter;
import com.example.muneer.Model.Aid;
import com.example.muneer.Model.Hospital;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Aidfragment extends Fragment {
    private RecyclerView recyclerView;
    private AidAdapter aidAdapter;
    private ArrayList<Aid> aidList;

    SearchView SearchBar;
    DatabaseReference reference;
    FirebaseDatabase database;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_aid, container, false);

        recyclerView = view.findViewById(R.id.aid_recyclerview);
        SearchBar=view.findViewById(R.id.search_diseas);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        aidList = new ArrayList<>();

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("AID");

        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        if(reference!=null)
        {
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists())
                    {
                        aidList=new ArrayList<>();
                        for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                        {
                            aidList.add(dataSnapshot1.getValue(Aid.class));

                        }
                        aidAdapter=new AidAdapter(getContext(),aidList);
                        recyclerView.setAdapter(aidAdapter);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            })
        }
    }
}




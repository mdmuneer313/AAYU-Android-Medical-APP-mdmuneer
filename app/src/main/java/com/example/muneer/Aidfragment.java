package com.example.muneer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muneer.Adapter.AidAdapter;
import com.example.muneer.Model.Aid;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Aidfragment extends Fragment {
    private RecyclerView recyclerView;
    private AidAdapter aidAdapter;
    private ArrayList<Aid> aidlist;
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
        aidlist = new ArrayList<>();

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("AID");


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();


    }

}

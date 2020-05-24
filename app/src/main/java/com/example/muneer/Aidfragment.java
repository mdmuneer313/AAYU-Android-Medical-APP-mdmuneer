package com.example.muneer;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muneer.Adapter.AidAdapter;
import com.example.muneer.Model.Aid;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Aidfragment extends Fragment {
    private RecyclerView recyclerView;
    private AidAdapter aidAdapter;
    private ArrayList<Aid> aidList;

    EditText SearchBar;
    DatabaseReference reference;
    FirebaseDatabase database;

    CardView Pandamics,CommonDiseas;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_aid, container, false);

       /* recyclerView = view.findViewById(R.id.aid_recyclerview);
        SearchBar=view.findViewById(R.id.search_diseas);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        aidList = new ArrayList<>();

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("AID");

          reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists())
                    {

                        aidList=new ArrayList<>();
                        aidList.clear();
                        for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                        {
                            // aidList.add(dataSnapshot1.getValue(Aid.class));
                            Aid aid = dataSnapshot1.getValue(Aid.class);
                            aidList.add(aid);

                        }
                        aidAdapter=new AidAdapter(getContext(),aidList);
                        recyclerView.setAdapter(aidAdapter);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            }); */

       Pandamics=view.findViewById(R.id.covidid);
       CommonDiseas=view.findViewById(R.id.commondiseas);

       Pandamics.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i=new Intent(getContext(),DiseasDetails.class);
               startActivity(i);
           }
       });

       CommonDiseas.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i=new Intent(getContext(),DiseasDetails.class);
               startActivity(i);
           }
       });


        return view;

    }

    @Override
    public void onStart() {
        super.onStart();

    }
}




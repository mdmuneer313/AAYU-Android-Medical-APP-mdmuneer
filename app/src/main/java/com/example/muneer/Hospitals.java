package com.example.muneer;

import android.os.Bundle;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muneer.Adapter.HospitalsAdapter;
import com.example.muneer.Model.Hospital;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.muddzdev.styleabletoast.StyleableToast;

import java.util.ArrayList;

public class Hospitals extends AppCompatActivity {

    RecyclerView hospital_recycle;
    SearchView hospital_search;
    DatabaseReference reference;
    FirebaseDatabase database;
    ArrayList<Hospital> HspList;
    HospitalsAdapter hspAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitals);


        hospital_recycle=findViewById(R.id.recycler_hp);
        hospital_recycle.setHasFixedSize(true);
        hospital_recycle.setLayoutManager(new LinearLayoutManager(this));
        HspList=new ArrayList<Hospital>();

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Hospital");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                    Hospital h=dataSnapshot1.getValue(Hospital.class);
                    HspList.add(h);
                }
                hspAdapter=new HospitalsAdapter(Hospitals.this,HspList);
                hospital_recycle.setAdapter(hspAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                StyleableToast.makeText(Hospitals.this, "Something went Wrong......",R.style.exampleToast).show();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();


    }

}


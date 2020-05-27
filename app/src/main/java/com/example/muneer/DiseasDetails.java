package com.example.muneer;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muneer.Adapter.AidAdapter;
import com.example.muneer.Model.Aid;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.muddzdev.styleabletoast.StyleableToast;

import java.util.ArrayList;

public class DiseasDetails extends AppCompatActivity {
    RecyclerView diseas_recycle;
    SearchView SearchBar;
    DatabaseReference reference;
    FirebaseDatabase database;
    ArrayList<Aid> aidList;
    AidAdapter aidAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diseas_details);

        diseas_recycle=findViewById(R.id.diseas_recyclerview);
        SearchBar=findViewById(R.id.diseas_search);
        diseas_recycle.setHasFixedSize(true);
        diseas_recycle.setLayoutManager(new LinearLayoutManager(this));
        aidList =new ArrayList<Aid>();

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Aid");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    aidList =new ArrayList<>();
                    for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                    {
                        Aid a=dataSnapshot1.getValue(Aid.class);
                        aidList.add(a);
                        //aidList.add(dataSnapshot1.getValue(Aid.class));

                    }
                    aidAdapter=new AidAdapter(DiseasDetails.this, aidList);
                    diseas_recycle.setAdapter(aidAdapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                StyleableToast.makeText(DiseasDetails.this, "Something went Wrong......",R.style.exampleToast).show();
            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
      /*  if(reference!=null)
        {
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists())
                    {
                        aidList =new ArrayList<>();
                        for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                        {
                            aidList.add(dataSnapshot1.getValue(Aid.class));

                        }
                        aidAdapter=new AidAdapter(DiseasDetails.this, aidList);
                        diseas_recycle.setAdapter(aidAdapter);
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    StyleableToast.makeText(DiseasDetails.this, "Something went Wrong......",R.style.exampleToast).show();
                }
            });
        }

       */


    }


}


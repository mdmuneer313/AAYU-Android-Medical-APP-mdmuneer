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

    }
    @Override
    protected void onStart() {
        super.onStart();
        if(reference!=null)
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

        if(SearchBar !=null)
        {
            SearchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    search(s);
                    return true;
                }
            });
        }

    }

    public void  search(String str)
    {
        ArrayList<Aid> mylist=new ArrayList<>();
        for(Aid object: aidList)
        {
            if(object.getDiseasname().toLowerCase().contains(str.toLowerCase()))
            {
                mylist.add(object);
            }
        }

        // hspAdapter=new HospitalsAdapter(Hospitals.this,mylist);
       AidAdapter adapter=new AidAdapter(DiseasDetails.this,mylist);
       diseas_recycle.setAdapter(adapter);
    }

}


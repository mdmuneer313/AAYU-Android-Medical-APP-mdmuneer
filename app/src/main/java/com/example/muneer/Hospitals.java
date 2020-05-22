package com.example.muneer;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
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
   SearchView SearchBar;
    DatabaseReference reference;
    FirebaseDatabase database;
    ArrayList<Hospital> HspList;
    HospitalsAdapter hspAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitals);


        hospital_recycle=findViewById(R.id.recycler_hp);
        SearchBar=findViewById(R.id.hospital_search);
       hospital_recycle.setHasFixedSize(true);
       hospital_recycle.setLayoutManager(new LinearLayoutManager(this));
       HspList=new ArrayList<Hospital>();

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Hospital");

    /*    reference.addValueEventListener(new ValueEventListener() {
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

       if(hospital_search !=null)
        {
            hospital_search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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
        } */
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
                        HspList=new ArrayList<>();
                        for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                        {
                            HspList.add(dataSnapshot1.getValue(Hospital.class));

                        }
                      hspAdapter=new HospitalsAdapter(Hospitals.this,HspList);
                        hospital_recycle.setAdapter(hspAdapter);
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    StyleableToast.makeText(Hospitals.this, "Something went Wrong......",R.style.exampleToast).show();
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
        ArrayList<Hospital> mylist=new ArrayList<>();
        for(Hospital object:HspList)
        {
            if(object.getHpname().toLowerCase().contains(str.toLowerCase()) || object.getCity().toLowerCase().contains(str.toLowerCase()))
            {
                mylist.add(object);
            }
        }

        // hspAdapter=new HospitalsAdapter(Hospitals.this,mylist);
        HospitalsAdapter adapter=new HospitalsAdapter(Hospitals.this,mylist);
        hospital_recycle.setAdapter(adapter);
    }

}


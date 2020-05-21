package com.example.muneer;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Detailview extends AppCompatActivity {
DatabaseReference ref;
TextView HospitalName,HospitalCity,blood,eyes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailview);
        HospitalName=findViewById(R.id.hospitalname);
        HospitalCity=findViewById(R.id.hospitalcity);
        blood=findViewById(R.id.bloodid);
        eyes=findViewById(R.id.eyeid);

        ref = FirebaseDatabase.getInstance().getReference("Hospital");
        String hname=getIntent().getStringExtra("Hname");
        String city=getIntent().getStringExtra("City");
        String bloodtool=getIntent().getStringExtra("Blood");
        String eyetool=getIntent().getStringExtra("Eyes");;



        /* ref.child(key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               // Object object=dataSnapshot.child("city").getValue();
                String name=dataSnapshot.child("hpname").getValue().toString();
                String city=dataSnapshot.child("City").getValue().toString();
                HospitalName.setText(name);
                HospitalCity.setText(city);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        }); */
        HospitalName.setText(hname);
        HospitalCity.setText(city);
        blood.setText(bloodtool);
        eyes.setText(eyetool);

    }
}

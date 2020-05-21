package com.example.muneer;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Detailview extends AppCompatActivity {
DatabaseReference ref;
TextView HospitalName,HospitalCity,Hospitaladdress,HospitalContact,Hospitalrating,blood,eyes,cancers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailview);
        HospitalName=findViewById(R.id.hospitalname);
        HospitalCity=findViewById(R.id.hospitalcity);
        cancers=findViewById(R.id.cancerid);
        blood=findViewById(R.id.bloodid);
        HospitalCity=findViewById(R.id.hospitalcity);
        Hospitalrating=findViewById(R.id.hospitalrating);
        Hospitaladdress=findViewById(R.id.hospitaladdress);
        HospitalContact=findViewById(R.id.hospitalcontact);
        eyes=findViewById(R.id.eyeid);
        cancers=findViewById(R.id.cancerid);

        ref = FirebaseDatabase.getInstance().getReference("Hospital");
        String hname=getIntent().getStringExtra("Hname");
        String city=getIntent().getStringExtra("City");
        String address=getIntent().getStringExtra("address");
        String rating=getIntent().getStringExtra("rating");
        String contact_no=getIntent().getStringExtra("contact_no");
        String bloodtool=getIntent().getStringExtra("Blood");
        String cancertool=getIntent().getStringExtra("Cancer");
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
        Hospitaladdress.setText(address);
        HospitalContact.setText(contact_no);
        Hospitalrating.setText(rating);
        blood.setText(bloodtool);
        eyes.setText(eyetool);
        cancers.setText(cancertool);

    }
}

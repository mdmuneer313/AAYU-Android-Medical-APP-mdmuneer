package com.example.muneer;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Detailview extends AppCompatActivity {
DatabaseReference ref;
//ActionBar actionBar;

TextView HospitalName,HospitalCity,Hospitaladdress,HospitalContact,Hospitalrating,blood,eyes,cancers,ears,hearts,kidneys;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailview);

       // getSupportActionBar().setTitle((Html.fromHtml("<font color=\"#0000\">" + "Details" + "</font>")));
       // actionBar=getSupportActionBar();
       // actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#009688")));



        HospitalName=findViewById(R.id.hospitalname);
        HospitalCity=findViewById(R.id.hospitalcity);
        HospitalCity=findViewById(R.id.hospitalcity);
        Hospitalrating=findViewById(R.id.hospitalrating);
        Hospitaladdress=findViewById(R.id.hospitaladdress);
        HospitalContact=findViewById(R.id.hospitalcontact);

        cancers=findViewById(R.id.cancerid);
        blood=findViewById(R.id.bloodid);
        eyes=findViewById(R.id.eyeid);
        cancers=findViewById(R.id.cancerid);
        ears=findViewById(R.id.earid);
        hearts=findViewById(R.id.heartid);
        kidneys=findViewById(R.id.kidneytid);


        ref = FirebaseDatabase.getInstance().getReference("Hospital");
        String hname=getIntent().getStringExtra("Hname");
        String city=getIntent().getStringExtra("City");
        String address=getIntent().getStringExtra("address");
        String rating=getIntent().getStringExtra("rating");
        String contact_no=getIntent().getStringExtra("contact_no");
        String bloodtool=getIntent().getStringExtra("Blood");
        String cancertool=getIntent().getStringExtra("Cancer");
        String eyetool=getIntent().getStringExtra("Eyes");;
        String eartool=getIntent().getStringExtra("Ear");
        String hearttool=getIntent().getStringExtra("Heart");
        String kidneytool=getIntent().getStringExtra("Kidney");;


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
        ears.setText(eartool);
        hearts.setText(hearttool);
        kidneys.setText(kidneytool);

    }
}

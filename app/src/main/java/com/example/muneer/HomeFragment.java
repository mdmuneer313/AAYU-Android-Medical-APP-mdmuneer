package com.example.muneer;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    //private RecyclerView recyclerView;
   // private HomeAdapter homeAdapter;
   // private List<Home> homeList;
    CardView profiledetails,hospitalDetails;


    public HomeFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_home, container, false);
       // recyclerView = view.findViewById(R.id.recycler_hps);
       // recyclerView.setHasFixedSize(true);
       // recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
      // homeList = new ArrayList<>();
      // homeAdapter=new HomeAdapter(getContext(),homeList);
      //  recyclerView.setAdapter(homeAdapter);
       // readUsers();
        profiledetails=view.findViewById(R.id.profile_details);
        hospitalDetails=view.findViewById(R.id.hospitals_details);
        profiledetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I=new Intent(getContext(),Account.class);
                startActivity(I);
            }
        });

        hospitalDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I=new Intent(getContext(),Hospitals.class);
                startActivity(I);
            }
        });


        return  view;

    }
 /*   private void readUsers() {

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Hospital");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                homeList.clear();
               if (dataSnapshot.exists()) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        Home home = snapshot.getValue(Home.class);
                        homeList.add(home);
                    }
                    homeAdapter=new HomeAdapter(getContext(),homeList);
                    recyclerView.setAdapter(homeAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    } */



}

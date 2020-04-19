package com.example.muneer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;

import de.hdodenhof.circleimageview.CircleImageView;

public class AboutFragment extends Fragment {
CircleImageView androidstudio,firebase;
    public AboutFragment() {
        // Required empty public constructor
    }
    Button LogoutBtn;
    FirebaseAuth mAuth;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_about, container, false);
androidstudio= view.findViewById(R.id.muneerpic);
firebase=view.findViewById(R.id.aswithpic);


        return view;
    }


}

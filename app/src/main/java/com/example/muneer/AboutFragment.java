package com.example.muneer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;

import de.hdodenhof.circleimageview.CircleImageView;

public class AboutFragment extends Fragment {
CircleImageView androidstudio,firebase;
CardView github;

    public AboutFragment() {
        // Required empty public constructor
    }
    Button LogoutBtn;
    FirebaseAuth mAuth;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_about, container, false);
        github=view.findViewById(R.id.ggithublik);
        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://github.com/mdmuneer313/muneer"));
                startActivity(intent);
            }
        });
//androidstudio= view.findViewById(R.id.Androidstudio);
//firebase=view.findViewById(R.id.firebase);

        return view;
    }


}

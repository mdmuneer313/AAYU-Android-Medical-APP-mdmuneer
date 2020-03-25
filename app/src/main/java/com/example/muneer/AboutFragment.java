package com.example.muneer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;

public class AboutFragment extends Fragment {

    public AboutFragment() {
        // Required empty public constructor
    }
    Button LogoutBtn;
    FirebaseAuth mAuth;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflater.inflate(R.layout.fragment_about, container, false);
      //  LogoutBtn = view.findViewById(R.id.loginbutton);

        /*LogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutfunct();
            }
        }); */

        return inflater.inflate(R.layout.fragment_about, container, false);
    }

/*
    private void logoutfunct() {
        FirebaseAuth.getInstance().signOut();//logout
        startActivity(new Intent(getActivity(),LoginFragment.class));
   getActivity().finish();

    }
*/

}

/*LogoutBtn = view.findViewById(R.id.loginbutton);
        LogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAuth.getCurrentUser() != null)
                    mAuth.signOut();
                Intent intent = new Intent(getActivity(), LoginFragment.class);
                startActivity(intent);
            }
        });
*/
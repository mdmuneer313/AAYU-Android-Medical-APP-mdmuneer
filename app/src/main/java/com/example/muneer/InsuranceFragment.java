package com.example.muneer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class InsuranceFragment extends Fragment {
    Button lic,hdfc,max,kotak,bajaj;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_insurance, container, false);
        lic=view.findViewById(R.id.LIClink);
        hdfc=view.findViewById(R.id.HDFClink);
        max=view.findViewById(R.id.MAXlink);
        kotak=view.findViewById(R.id.KOTAKlink);
        bajaj=view.findViewById(R.id.BAJAJlink);

        lic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.licindia.in/Products/Health-Plans"));
                startActivity(intent);
            }
        });

        hdfc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.hdfcergo.com/health-insurance"));
                startActivity(intent);
            }
        });

        max.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.maxlifeinsurance.com/health-insurance-plans"));
                startActivity(intent);
            }
        });

        kotak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.kotakgeneralinsurance.com/health-insurance"));
                startActivity(intent);
            }
        });

        bajaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.bajajallianz.com/health-insurance-plans.html"));
                startActivity(intent);
            }
        });

        return view;

    }
}

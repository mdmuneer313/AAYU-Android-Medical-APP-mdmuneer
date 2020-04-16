package com.example.muneer;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Nav_Bottom extends AppCompatActivity {
ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav__bottom);
        boolean finish = getIntent().getBooleanExtra("finish", false);
        if (finish) {
            startActivity(new Intent(getApplicationContext(), LoginFragment.class));
            finish();
            return;
        }
        getSupportActionBar().setTitle((Html.fromHtml("<font color=\"#0000\">" + "AYU" + "</font>")));
        actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#009688")));
        BottomNavigationView bottomNav = findViewById(R.id.nav_bottom);
        bottomNav.setOnNavigationItemSelectedListener(navListner);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
        }

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListner=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            getSupportActionBar().setTitle((Html.fromHtml("<font color=\"#0000\">" + "Home" + "</font>")));

                            getFragment(new HomeFragment());
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_Aid:
                            getSupportActionBar().setTitle((Html.fromHtml("<font color=\"#0000\">" + "Aid" + "</font>")));
                            getFragment(new Aidfragment());
                            selectedFragment = new Aidfragment();
                            break;
                        case R.id.nav_insurance:
                            getSupportActionBar().setTitle((Html.fromHtml("<font color=\"#0000\">" + "Insurance" + "</font>")));
                            getFragment(new InsuranceFragment());
                            selectedFragment = new InsuranceFragment();
                            break;
                        case R.id.nav_chat:
                            getSupportActionBar().setTitle((Html.fromHtml("<font color=\"#0000\">" + "Chat" + "</font>")));
                            getFragment(new ChatFragment());
                            selectedFragment = new ChatFragment();
                            break;
                        case R.id.nav_about:
                            getSupportActionBar().setTitle((Html.fromHtml("<font color=\"#0000\">" + "About" + "</font>")));
                            getFragment(new AboutFragment());
                            selectedFragment = new AboutFragment();
                            break;
                           /*
                            Intent b = new Intent(Nav_Bottom.this,Dashboard.class);

                            startActivity(b);
                            break;*/

                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.account_profile, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            startActivity(new Intent(Nav_Bottom.this, Account.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void getFragment(Fragment fragment)
    {
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=manager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container,new AboutFragment());
        fragmentTransaction.commit();
    }

}

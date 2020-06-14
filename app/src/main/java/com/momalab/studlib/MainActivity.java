package com.momalab.studlib;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.momalab.studlib.DrawerActivity.demande;
import com.momalab.studlib.DrawerActivity.email;
import com.momalab.studlib.DrawerActivity.moyenne;
import com.momalab.studlib.Speciality.Chemie;
import com.momalab.studlib.Speciality.Physique;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    CardView phy, ch, math, info, bio;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //////////toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //////drawer layout
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        phy = findViewById(R.id.physique);
        phy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, Physique.class);
                startActivity(intent);
            }
        });
        ch = findViewById(R.id.chemie);
        ch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, Chemie.class);
                startActivity(intent);
            }
        });
        math = findViewById(R.id.math);
        info = findViewById(R.id.info);
        bio = findViewById(R.id.biologie);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.moyenne) {
            Intent intent = new Intent(this, moyenne.class);
            startActivity(intent);
        } else if (id == R.id.nav_dem) {
            Intent intent = new Intent(this, demande.class);
            startActivity(intent);
        } else if (id == R.id.nav_sup) {

        } else if (id == R.id.nav_send) {
            Intent intent = new Intent(this, email.class);
            startActivity(intent);

        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

package com.momalab.studlib;

import com.google.android.material.tabs.TabLayout;
import com.momalab.studlib.Adapter.PagerAdapter;
import com.momalab.studlib.ModuleContent.Cours;
import com.momalab.studlib.ModuleContent.Exam;
import com.momalab.studlib.ModuleContent.Td;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class Contenent extends AppCompatActivity implements Cours.OnFragmentInteractionListener, Td.OnFragmentInteractionListener, Exam.OnFragmentInteractionListener {
ArrayList<String> gridList,uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenent);
        gridList=new ArrayList<>();
        uri=new ArrayList<>();
        TabLayout tabLayout=findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Cours"));
        tabLayout.addTab(tabLayout.newTab().setText("TD"));
        tabLayout.addTab(tabLayout.newTab().setText("Examen"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager=findViewById(R.id.viewpager);
        PagerAdapter pagerAdapter=new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onFragmentInteraction(ArrayList<String> list) {

    }
}

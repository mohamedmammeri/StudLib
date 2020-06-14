package com.momalab.studlib.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.momalab.studlib.ModuleContent.Cours;
import com.momalab.studlib.ModuleContent.Exam;
import com.momalab.studlib.ModuleContent.Td;

import java.util.ArrayList;

public class PagerAdapter extends FragmentStatePagerAdapter {
    private int mNbr;
    private static ArrayList<String> s1;
    private static ArrayList<String> s2;
    private static ArrayList<String> t1;
    private static ArrayList<String> t2;
    private static ArrayList<String> e1;
    private static ArrayList<String> e2;
    public PagerAdapter(FragmentManager fm,int nbr) {
        super(fm);
       this.mNbr=nbr;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                Cours cours=new Cours();
                return cours.newInstance(s1,s2);
            case 1:
                Td td=new Td();
                return td.newInstance(t1,t2);
            case 2:
                Exam exam=new Exam();
                return exam.newInstance(e1,e2);
             default:
                    return null;

        }
    }

    @Override
    public int getCount() {
        return mNbr;
    }

    public static void setS(ArrayList<String> sa,ArrayList<String> u,ArrayList<String> ta,ArrayList<String> ut,ArrayList<String> eli,ArrayList<String> eu) {
        s1 = sa;s2=u;
        t1 = ta;t2=ut;
        e1=eli;e2=eu;
    }
}

package com.momalab.studlib.ModuleContent;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.momalab.studlib.R;

import java.util.ArrayList;


public class Cours extends Fragment {
    private ArrayList<String> mGridList;
    private ArrayList<String> mUri;
    private OnFragmentInteractionListener mListener;

    public Cours() {
        // Required empty public constructor
    }

    public static Cours newInstance(ArrayList<String> string,ArrayList<String> uri){
        Cours cours=new Cours();
        Bundle bundle=new Bundle();
        bundle.putStringArrayList("gridList",string);
        bundle.putStringArrayList("uri",uri);
        cours.setArguments(bundle);

    return cours;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_cours, container, false);
        return v;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments()!=null) {
            mGridList = getArguments().getStringArrayList("gridList");
            mUri=getArguments().getStringArrayList("uri");
        }
        ListView coursList=view.findViewById(R.id.coursList);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(getContext(),R.layout.courstdexam,R.id.txtcours,mGridList);
        coursList.setAdapter(adapter);
        coursList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(mUri.get(position)));
                startActivity(intent);
                }

        });

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(ArrayList<String> list);
    }
}

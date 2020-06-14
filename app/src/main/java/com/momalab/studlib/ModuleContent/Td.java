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

public class Td extends Fragment {
    private ArrayList<String> mTdList;
    private ArrayList<String> mTdUri;
    private OnFragmentInteractionListener mListener;

    public Td() {
    }



    public static Td newInstance(ArrayList<String> string,ArrayList<String> uri){
        Td td=new Td();
        Bundle bundle=new Bundle();
        bundle.putStringArrayList("tdList",string);
        bundle.putStringArrayList("tduri",uri);
        td.setArguments(bundle);

        return td;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View v=inflater.inflate(R.layout.fragment_td, container, false);
        return v;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments()!=null) {
            mTdList = getArguments().getStringArrayList("tdList");
            mTdUri=getArguments().getStringArrayList("tduri");
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<>(getContext(),R.layout.courstdexam,R.id.txtcours,mTdList);
        ListView listView=view.findViewById(R.id.tdList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(mTdUri.get(position)));
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
        void onFragmentInteraction(ArrayList<String> uri);
    }

}

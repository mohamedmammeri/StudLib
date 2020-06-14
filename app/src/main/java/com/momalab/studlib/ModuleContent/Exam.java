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


public class Exam extends Fragment {
    private ArrayList<String> mExamList;
    private ArrayList<String> mExamUri;

    private OnFragmentInteractionListener mListener;

    public Exam() {
    }


    public static Exam newInstance(ArrayList<String> param1, ArrayList<String> param2) {
        Exam fragment = new Exam();
        Bundle args = new Bundle();
        args.putStringArrayList("exma", param1);
        args.putStringArrayList("uri", param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_exam, container, false);
    }

    public void onButtonPressed(ArrayList<String> uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            mExamList = getArguments().getStringArrayList("exma");
            mExamUri = getArguments().getStringArrayList("uri");
        }
        ListView mListView=view.findViewById(R.id.examList);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(getContext(),R.layout.courstdexam,R.id.txtcours,mExamList);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(mExamUri.get(position)));
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

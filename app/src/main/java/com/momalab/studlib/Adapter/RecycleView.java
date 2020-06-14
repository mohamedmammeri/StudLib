package com.momalab.studlib.Adapter;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.momalab.studlib.R;

import java.util.ArrayList;

public class RecycleView extends RecyclerView.Adapter<RecycleView.Holder> {
    private ArrayList<String> myunitList;
    private ArrayList<Integer> mycoefList;
    private ArrayList<Double> myexamList;
    private ArrayList<Integer> myevalList;
    private ArrayList<Double> myccList;
    private static ArrayList<Double> myMoyList;


    public void setArrayList(ArrayList unitList, ArrayList coefList, ArrayList examList, ArrayList evalList, ArrayList ccList) {
        myunitList = unitList;
        mycoefList = coefList;
        myexamList = examList;
        myevalList = evalList;
        myccList = ccList;
        myMoyList=new ArrayList<>();

    }

    public class Holder extends RecyclerView.ViewHolder {
       public TextView unit,coef,exam,eval,cc,moy;
        public Holder(@NonNull View itemView) {
            super(itemView);
            unit=itemView.findViewById(R.id.Runite);
            coef=itemView.findViewById(R.id.Rcoeff);
            exam=itemView.findViewById(R.id.Rexam);
            eval=itemView.findViewById(R.id.Reval);
            cc=itemView.findViewById(R.id.Rcc);
            moy=itemView.findViewById(R.id.Rmoy);

        }
    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        View view=inflater.inflate(R.layout.recyclerview_adapter,viewGroup,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
    holder.unit.setText(myunitList.get(i));
    holder.coef.setText(String.valueOf(mycoefList.get(i)));
    holder.exam.setText(String.valueOf(myexamList.get(i)));
    holder.eval.setText(String.valueOf(myevalList.get(i)));
    holder.cc.setText(String.valueOf(myccList.get(i)));
    double moyenne=(myexamList.get(i)*myevalList.get(i)/100)+(myccList.get(i)*(100-myevalList.get(i))/100);
    holder.moy.setText(String.format(String.valueOf(moyenne)));
    myMoyList.add(moyenne);

    }

    @Override
    public int getItemCount() {
        return myexamList.size();
    }

    public static ArrayList<Double> getMyMoyList() {
        return myMoyList;
    }
}

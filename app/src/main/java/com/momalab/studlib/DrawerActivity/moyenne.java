package com.momalab.studlib.DrawerActivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.momalab.studlib.Adapter.RecycleView;
import com.momalab.studlib.InputFilterMinMax;
import com.momalab.studlib.R;

import java.util.ArrayList;


public class moyenne extends AppCompatActivity {
    TextView MoyGenerale, Somme;
    EditText unit, coef, exam, eval, cc;
    Button ajout, calculer, recommamcer;
    ArrayList<String> unitList;
    ArrayList<Integer> coefList, evalList;
    ArrayList<Double> examList, ccList, moyList;
    String unitVal = "";
    int cT = 0;
    double sum = 0;
    double moyenGeneral = 0;
    RecycleView recylceViewAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moyenne);
        MoyGenerale = findViewById(R.id.moyGenerale);
        Somme = findViewById(R.id.somme);
        ajout = findViewById(R.id.ajout);
        calculer = findViewById(R.id.calculer);
        recommamcer = findViewById(R.id.recomancer);
        unit = findViewById(R.id.unit);
        coef = (EditText) findViewById(R.id.coeff);
        coef.setFilters(new InputFilter[]{new InputFilterMinMax("0", "7")});
        exam = (EditText) findViewById(R.id.exam);
        exam.setFilters(new InputFilter[]{new InputFilterMinMax("0", "20")});
        eval = (EditText) findViewById(R.id.eval);
        eval.setFilters(new InputFilter[]{new InputFilterMinMax("0", "100")});
        cc = (EditText) findViewById(R.id.cc);
        cc.setFilters(new InputFilter[]{new InputFilterMinMax("0", "20")});
        unitList = new ArrayList<>();
        coefList = new ArrayList<>();
        examList = new ArrayList<>();
        evalList = new ArrayList<>();
        ccList = new ArrayList<>();
        recylceViewAdapter = new RecycleView();
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recylceViewAdapter.setArrayList(unitList, coefList, examList, evalList, ccList);
        ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int coefVal = 0, evalVal = 100;
                double examVal = 0;
                double ccVal = 0;
                if (!unit.getText().toString().equals("")) {
                    unitVal = unit.getText().toString();
                }
                unitList.add(unitVal);
                if (!coef.getText().toString().equals("")) {
                    coefVal = Integer.parseInt(coef.getText().toString());
                }
                coefList.add(coefVal);
                if (!exam.getText().toString().equals("")) {
                    examVal = Double.parseDouble(exam.getText().toString());
                }
                examList.add(examVal);
                if (!eval.getText().toString().equals("")) {
                    evalVal = Integer.parseInt(eval.getText().toString());
                }
                evalList.add(evalVal);
                if (!cc.getText().toString().equals("")) {
                    ccVal = Double.parseDouble(cc.getText().toString());
                }
                ccList.add(ccVal);
                recylceViewAdapter.setArrayList(unitList, coefList, examList, evalList, ccList);
                recyclerView.setAdapter(recylceViewAdapter);
                unit.getText().clear();
                coef.getText().clear();
                exam.getText().clear();
                cc.getText().clear();
                eval.getText().clear();
            }
        });
        calculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cT = 0;
                double sum = 0;
                double moyenGeneral = 0;
                moyList = RecycleView.getMyMoyList();
                if (coefList.size() != 0) {
                    for (int i = 0; i < coefList.size(); i++) {
                        cT += coefList.get(i);
                        sum += moyList.get(i)*coefList.get(i);
                    }
                    moyenGeneral = sum / cT;
                }
                Somme.setText(String.valueOf(sum));
                MoyGenerale.setText(String.format(String.valueOf(moyenGeneral)));
                if(moyenGeneral<10){MoyGenerale.setBackgroundColor(getResources().getColor(R.color.red));}
                if (moyenGeneral>=10){MoyGenerale.setBackgroundColor(getResources().getColor(R.color.green));}


            }
        });
        recommamcer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unitList = new ArrayList<>();
                coefList = new ArrayList<>();
                examList = new ArrayList<>();
                evalList = new ArrayList<>();
                ccList = new ArrayList<>();
                recylceViewAdapter.setArrayList(unitList, coefList, examList, evalList, ccList);
                recyclerView.setAdapter(recylceViewAdapter);
                cT = 0;
                sum = 0;
                moyenGeneral = 0;
                Somme.setText(String.valueOf(sum));
                MoyGenerale.setText(String.format(String.valueOf(moyenGeneral)));
            }
        });
        recyclerView.setAdapter(recylceViewAdapter);
    }

}

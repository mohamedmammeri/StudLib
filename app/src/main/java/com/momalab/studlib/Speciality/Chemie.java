package com.momalab.studlib.Speciality;

import android.content.Intent;
        import androidx.appcompat.app.AppCompatActivity;
        import android.os.Bundle;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;
        import androidx.appcompat.widget.SearchView;
        import android.view.WindowManager;
        import android.view.inputmethod.EditorInfo;

import com.momalab.studlib.Adapter.ModuleAdapter;
import com.momalab.studlib.Contenent;
import com.momalab.studlib.R;

import java.util.ArrayList;
        import java.util.Arrays;

public class Chemie extends AppCompatActivity implements SearchView.OnQueryTextListener , ModuleAdapter.ItemClickListener{

    private ModuleAdapter adapter;
    androidx.appcompat.widget.SearchView search;
    private String[] module;
    private ArrayList<String> a = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        search = findViewById(R.id.search_module);
        module = new String[]{"L1:S1:", "Mathematique 1/Analyse et algèbre", "Physique 1/Mécanique du point", "Chémie1/Structure de la matière", "TP Mécanique", "TP Chémie", "Informatique 1", "Environnement"
                , "L1:S2:", "Mathematique 2/Analyse et algèbre 2", "Physique 2/Electricité", "Chémie2/Thermodynamique et cinétique chimique", "TP Electricité", "TP Chémie 2", "Informatique 2", "Energie renouvelable"
        };

        a.addAll(Arrays.asList(module));
        setRecyclerView();
        search.setImeOptions(EditorInfo.IME_ACTION_DONE);
        search.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        adapter.getFilter().filter(s);
        return false;
    }

    private void setRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.listOfmodule);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new ModuleAdapter(a,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClickListener(int index) {
        Intent intent=new Intent(this, Contenent.class);
        startActivity(intent);
    }
}


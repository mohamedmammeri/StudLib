package com.momalab.studlib.Adapter;

import android.graphics.Color;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.momalab.studlib.R;

import java.util.ArrayList;
import java.util.List;

public class ModuleAdapter extends RecyclerView.Adapter<ModuleAdapter.Holder> implements Filterable {
    private ArrayList<String> myModuleList;
    private ArrayList<String> myFullList;
    final private ItemClickListener mItemClickListener;

    public interface ItemClickListener {
        void onItemClickListener(int j);
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView module;

        public Holder(@NonNull View itemView) {
            super(itemView);
            module = itemView.findViewById(R.id.moduleText);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int index = getAdapterPosition();
            int j=0;
            for(int i=0;i<myFullList.size();i++){
                if(myModuleList.get(index).equals(myFullList.get(i))){
                   j=myFullList.indexOf(myFullList.get(i));
                }
            }

            mItemClickListener.onItemClickListener(j);
        }
    }

    public ModuleAdapter(ArrayList<String> a, ItemClickListener listener) {
        this.myModuleList = a;
        myFullList = new ArrayList<>(a);
        mItemClickListener = listener;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listview_item, viewGroup, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        if (myFullList.get(i).contains(":S")) {
            holder.module.setBackgroundColor(Color.parseColor("#22316b"));
            holder.module.setTextColor(Color.parseColor("#ffffff"));
        } else {
            holder.module.setBackgroundColor(Color.parseColor("#ffffff"));
            holder.module.setTextColor(Color.parseColor("#000000"));
        }
        holder.module.setText(myModuleList.get(i));
    }

    @Override
    public int getItemCount() {
        return myModuleList.size();
    }

    @Override
    public Filter getFilter() {
        return myFilter;
    }

    private Filter myFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<String> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(myFullList);
            } else {
                String word = constraint.toString().toLowerCase().trim();
                for (int i = 0; i < myFullList.size(); i++) {
                    if (myFullList.get(i).toLowerCase().contains(word)) {
                        filteredList.add(myFullList.get(i));
                    }
                }


            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            myModuleList.clear();
            myModuleList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

}

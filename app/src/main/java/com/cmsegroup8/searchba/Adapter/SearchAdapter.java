package com.cmsegroup8.searchba.Adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cmsegroup8.searchba.Model.Trees;
import com.cmsegroup8.searchba.R;

import java.util.List;

class SearchViewHolder extends RecyclerView.ViewHolder{

    public TextView name;

    public SearchViewHolder(View itemView){
        super(itemView);
        name= itemView.findViewById(R.id.name);
    }
}

public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder> {

    private Context context;
    private List<Trees> trees;

    public SearchAdapter(Context context, List<Trees> trees) {
        this.context = context;
        this.trees = trees;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.layout_item,parent,false);
        return new SearchViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        holder.name.setText(trees.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return trees.size();
    }
}

package com.example.nikecodingexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nikecodingexample.R;
import com.example.nikecodingexample.model.Definition;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class NikeAdapter extends RecyclerView.Adapter<NikeAdapter.NikeViewHolder> {

    Context context;
    ArrayList<Definition> definitionsList;

    public NikeAdapter(Context context, ArrayList<Definition> defs) {
        this.context = context;
        this.definitionsList = defs;
    }

    @NonNull
    @Override
    public NikeAdapter.NikeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.definition_list_item, parent, false);
        return new  NikeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NikeAdapter.NikeViewHolder holder, int position) {
        holder.tvDefinition.setText(definitionsList.get(position).getDefinition());
        holder.tvPermalink.setText(definitionsList.get(position).getPermalink());

        Picasso.get().load(definitionsList.get(position).getThumbs_up()).into(holder.ivThumbs_up);
        Picasso.get().load(definitionsList.get(position).getThumbs_down()).into(holder.ivThumbs_down);
    }

    @Override
    public int getItemCount() {
        return definitionsList.size();
    }

    public class NikeViewHolder extends RecyclerView.ViewHolder{

        TextView tvDefinition;
        TextView tvPermalink;
        ImageView ivThumbs_up;
        ImageView ivThumbs_down;

        public NikeViewHolder(@NonNull View itemView) {
            super(itemView);

            tvDefinition = itemView.findViewById(R.id.tvDefinition);
            tvPermalink = itemView.findViewById(R.id.tvPermalink);
            ivThumbs_up = itemView.findViewById(R.id.ivThumbs_up);
            ivThumbs_down = itemView.findViewById(R.id.ivThumbs_down);


        }
    }
}

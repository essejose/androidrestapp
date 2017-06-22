package com.essejose.androidrestapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.essejose.androidrestapp.R;
import com.essejose.androidrestapp.model.Android;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by essejose on 21/06/2017.
 */

public class AndroidAdpter extends RecyclerView.Adapter<AndroidAdpter.AndroidViewHolder>{

    private List<Android> androids;


    public AndroidAdpter(List<Android> androids){
        this.androids = androids;
    }

    @Override
    public AndroidViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater =  LayoutInflater.from(parent.getContext());

        View meuLayout = inflater.inflate(R.layout.android_row,
                parent,false);


        return new AndroidViewHolder(meuLayout);
    }

    @Override
    public void onBindViewHolder(AndroidViewHolder holder, int position) {

        holder.tvTitulo.setText(androids.get(position).getNome());
        holder.tvSubtitulo.setText(androids.get(position).getApi());

        Picasso.with(holder.itemView.getContext())
                .load(androids.get(position).getUrlImagem())
                .placeholder(android.R.drawable.star_on)
                .into(holder.ivLogo);
    }

    @Override
    public int getItemCount() {
        return androids.size();
    }

    public  class AndroidViewHolder extends RecyclerView.ViewHolder{

        public ImageView ivLogo;
        public TextView tvTitulo;
        public TextView tvSubtitulo;

        public AndroidViewHolder(View itemView) {
            super(itemView);

            ivLogo      = (ImageView) itemView.findViewById(R.id.ivLogo);
            tvTitulo    = (TextView) itemView.findViewById(R.id.tvTitulo);
            tvSubtitulo = (TextView) itemView.findViewById(R.id.tvSubtitulo);

        }
    }

    public  void update(List<Android> androids){
        this.androids = androids;
        notifyDataSetChanged();
    }

}

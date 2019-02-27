package com.example.clabuyakchai.cryptocurrency.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.clabuyakchai.cryptocurrency.R;
import com.example.clabuyakchai.cryptocurrency.data.local.entity.Favorite;
import com.example.clabuyakchai.cryptocurrency.data.model.CurrencyLatest;
import com.example.clabuyakchai.cryptocurrency.ui.holder.CurrencyHolder;

import java.util.List;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyHolder> {
    private List<CurrencyLatest> latests;
    private FavoriteCallBack listener;

    public CurrencyAdapter(List<CurrencyLatest> latests, FavoriteCallBack listener) {
        this.latests = latests;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CurrencyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        final CurrencyHolder holder = new CurrencyHolder(view);

        //listener
        holder.getCurrencyFavorite()
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = holder.getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            latests.get(position).setFavorite(!latests.get(position).isFavorite());
                            listener.changeFavoriteState(new Favorite(Integer.parseInt(latests.get(position).getId())));
                            notifyItemChanged(position);
                        }
                    }
                });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CurrencyHolder holder, int position) {
        holder.bind(latests.get(position));
    }

    @Override
    public int getItemCount() {
        return latests.size();
    }
}

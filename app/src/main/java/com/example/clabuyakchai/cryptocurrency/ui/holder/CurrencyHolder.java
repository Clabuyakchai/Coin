package com.example.clabuyakchai.cryptocurrency.ui.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.clabuyakchai.cryptocurrency.R;
import com.example.clabuyakchai.cryptocurrency.data.model.CurrencyLatest;

public class CurrencyHolder extends RecyclerView.ViewHolder {

    private ImageView currencyIcon;
    private TextView currencySymbol;
    private TextView currencyPrice;
    private TextView currencyPercentChange;
    private ImageView currencyFavorite;

    public CurrencyHolder(View itemView) {
        super(itemView);

        currencyIcon = itemView.findViewById(R.id.currency_icon);
        currencySymbol = itemView.findViewById(R.id.currency_symbol);
        currencyPrice = itemView.findViewById(R.id.currency_price);
        currencyPercentChange = itemView.findViewById(R.id.currency_percent_change);
        currencyFavorite = itemView.findViewById(R.id.currency_favorite);
    }

    public void bind(CurrencyLatest latest) {
        currencySymbol.setText(latest.getSymbol());
        currencyPrice.setText(String.valueOf(latest.getPrice()));
        currencyPercentChange.setText(String.valueOf(latest.getPercentChange()));
        Glide.with(currencyIcon.getContext()).load(latest.getLogo()).into(currencyIcon);
        currencyFavorite.setImageResource(latest.isFavorite() ?
                R.drawable.ic_favorite_red : R.drawable.ic_favorite_border);
    }

    public ImageView getCurrencyFavorite() {
        return currencyFavorite;
    }
}

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
    private ImageView currencyLike;

    public CurrencyHolder(View itemView) {
        super(itemView);

        currencyIcon = itemView.findViewById(R.id.currency_icon);
        currencySymbol = itemView.findViewById(R.id.currency_symbol);
        currencyPrice = itemView.findViewById(R.id.currency_price);
        currencyPercentChange = itemView.findViewById(R.id.currency_percent_change);
        currencyLike = itemView.findViewById(R.id.currency_favorite);
    }

    //TODO
    public void bind(CurrencyLatest latest) {
        currencySymbol.setText(latest.getSymbol());
        currencyPrice.setText(String.format("\u0024%.2f", latest.getPrice()));
        currencyPercentChange.setText(String.format("%.2f", latest.getPercentChange()) + "\u0025");
        Glide.with(currencyIcon.getContext()).load(latest.getLogo()).into(currencyIcon);
        setCurrencyLike(latest.isFavorite());
    }

    public ImageView getCurrencyLike() {
        return currencyLike;
    }

    public void setCurrencyLike(Boolean isFavorite) {
        currencyLike.setImageResource(isFavorite ?
                R.drawable.ic_favorite_red : R.drawable.ic_favorite_border_gray);
    }
}

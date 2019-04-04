package com.example.clabuyakchai.cryptocurrency.ui.holder;

import android.content.Context;
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
    private ImageView currencyUpOrDown;
    private TextView currencyPrice;
    private TextView currencyPercentChange;
    private ImageView currencyLike;

    public CurrencyHolder(View itemView) {
        super(itemView);

        currencyIcon = itemView.findViewById(R.id.currency_icon);
        currencySymbol = itemView.findViewById(R.id.currency_symbol);
        currencyUpOrDown = itemView.findViewById(R.id.currency_up_or_down);
        currencyPrice = itemView.findViewById(R.id.currency_price);
        currencyPercentChange = itemView.findViewById(R.id.currency_percent_change);
        currencyLike = itemView.findViewById(R.id.currency_favorite);
    }

    //TODO
    public void bind(CurrencyLatest latest) {
        Context context = currencyPrice.getContext();
        currencySymbol.setText(latest.getSymbol());
        currencyUpOrDown.setImageResource(latest.getPercentChange() > 0 ? R.drawable.ic_arrow_upward_green : R.drawable.ic_arrow_downward_red);
        currencyPrice.setText(String.format(context.getResources().getString(R.string.format_price), latest.getPrice()));
        currencyPercentChange.setText(context.getResources().getString(R.string.symbol_percent,
                String.format(context.getResources().getString(R.string.format_percent_change), latest.getPercentChange())));
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

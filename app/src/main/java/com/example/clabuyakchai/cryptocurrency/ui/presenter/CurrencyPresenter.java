package com.example.clabuyakchai.cryptocurrency.ui.presenter;

import com.example.clabuyakchai.cryptocurrency.data.local.entity.Favorite;

public interface CurrencyPresenter {
    void updateFavorite(Favorite favorite);
    void onSortByMarketCap();
    void onSortByUSDClick();
    void onSortByVolumeClick();
    void onCountFavoriteClick();
    void onStartProgressBar();
    void onStopProgressBar();
}

package com.example.clabuyakchai.cryptocurrency.ui.presenter;

import com.example.clabuyakchai.cryptocurrency.data.local.entity.Favorite;

public interface CurrencyPresenter {
    void updateFavorite(Favorite favorite);
    void onSortByUSDClick();
    void onSortByVolumeClick();
    void onCountFavoriteClick();
}

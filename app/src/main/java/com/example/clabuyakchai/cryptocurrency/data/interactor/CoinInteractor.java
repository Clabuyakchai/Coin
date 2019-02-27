package com.example.clabuyakchai.cryptocurrency.data.interactor;

import com.example.clabuyakchai.cryptocurrency.data.local.entity.Favorite;
import com.example.clabuyakchai.cryptocurrency.data.model.CurrencyLatest;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface CoinInteractor {
    Single<List<CurrencyLatest>> temp(String sort);
    Completable updateFavoriteInDb(Favorite favorite);
    Single<List<Favorite>> getFavorite();
}

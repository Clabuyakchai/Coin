package com.example.clabuyakchai.cryptocurrency.data.repository;

import com.example.clabuyakchai.cryptocurrency.data.local.entity.Favorite;
import com.example.clabuyakchai.cryptocurrency.data.model.CurrencyLatest;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface CoinRepository {
    Single<List<CurrencyLatest>> getCurrencyFromApi(String sort);
    Completable updateFavoriteInDb(Favorite favorite);
    Single<List<Favorite>> getFavoriteFromDb();
}

package com.example.clabuyakchai.cryptocurrency.data.repository;

import android.arch.persistence.room.EmptyResultSetException;

import com.example.clabuyakchai.cryptocurrency.data.local.AppDatabase;
import com.example.clabuyakchai.cryptocurrency.data.local.entity.Favorite;
import com.example.clabuyakchai.cryptocurrency.data.model.CurrencyLatest;
import com.example.clabuyakchai.cryptocurrency.data.remote.CryptoApi;
import com.example.clabuyakchai.cryptocurrency.data.remote.model.info.Coin;
import com.example.clabuyakchai.cryptocurrency.data.remote.model.info.Info;
import com.example.clabuyakchai.cryptocurrency.data.remote.model.latest.Latest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class CoinRepositoryImpl implements CoinRepository {

    private final CryptoApi cryptoApi;
    private final AppDatabase appDatabase;

    @Inject
    public CoinRepositoryImpl(CryptoApi cryptoApi, AppDatabase appDatabase) {
        this.cryptoApi = cryptoApi;
        this.appDatabase = appDatabase;
    }

    @Override
    public Single<List<CurrencyLatest>> getCurrencyFromApi(String sort) {
        Single<List<CurrencyLatest>> remote = cryptoApi.getCryptoLatest(sort)
                .subscribeOn(Schedulers.io())
                .flatMap(crypto -> {
                    List<CurrencyLatest> currencyLatest = mapCurrencyLatest(crypto);
                    return cryptoApi.getCryptoInfo(query(currencyLatest))
                            .flatMap(info -> Single.just(mapInfoToCurrencyLatest(info, currencyLatest)));
                });

        Single<List<Favorite>> local = appDatabase.favoriteDao().getFavorite()
                .subscribeOn(Schedulers.io());

        return Single.zip(remote, local, this::addFavoriteInCurrencyLatest).subscribeOn(Schedulers.io());
    }

    private List<CurrencyLatest> mapCurrencyLatest(Latest latest) {
        List<CurrencyLatest> latests = new ArrayList<>();

        for (int i = 0; i < latest.getData().size(); i++) {
            latests.add(new CurrencyLatest(
                    String.valueOf(latest.getData().get(i).getId()),
                    latest.getData().get(i).getSymbol(),
                    latest.getData().get(i).getQuote().getUSD().getPrice(),
                    latest.getData().get(i).getQuote().getUSD().getPercentChange1h()));
        }

        return latests;
    }

    private List<CurrencyLatest> mapInfoToCurrencyLatest(Info info, List<CurrencyLatest> latests) {
        for (int i = 0; i < info.getData().size(); i++) {
            Coin coin = info.getData().get(latests.get(i).getId());
            latests.get(i).setLogo(coin.getLogo());
        }
        return latests;
    }

    private String query(List<CurrencyLatest> latests) {
        String SEPARATOR = ",";
        StringBuilder builder = new StringBuilder();
        for (CurrencyLatest latest : latests) {
            builder.append(latest.getId());
            builder.append(SEPARATOR);
        }
        String csv = builder.toString();
        return csv.substring(0, csv.length() - SEPARATOR.length());
    }

    private List<CurrencyLatest> addFavoriteInCurrencyLatest(List<CurrencyLatest> currencyLatests, List<Favorite> favorites) {
        for (int i = 0; i < favorites.size(); i++) {
            for (int j = 0; j < currencyLatests.size(); j++) {
                if (currencyLatests.get(j).getId().equals(String.valueOf(favorites.get(i).getIdCoin()))) {
                    currencyLatests.get(j).setFavorite(true);
                }
            }
        }

        return currencyLatests;
    }

    private Completable insertFavoriteInDb(Favorite favorite) {
        return Completable.fromAction(() -> appDatabase.favoriteDao().insert(favorite))
                .subscribeOn(Schedulers.io());
    }

    private Completable deleteFavoriteInDb(Favorite favorite) {
        return Completable.fromAction(() -> appDatabase.favoriteDao().delete(favorite))
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Completable updateFavoriteInDb(Favorite favorite) {
        return appDatabase.favoriteDao().getFavoriteById(favorite.getIdCoin())
                .subscribeOn(Schedulers.io())
                .flatMapCompletable(fav -> deleteFavoriteInDb(favorite))
                .onErrorResumeNext(throwable -> insertFavoriteInDb(favorite));
    }

    public Single<List<Favorite>> getFavoriteFromDb() {
        return appDatabase.favoriteDao().getFavorite().subscribeOn(Schedulers.io());
    }
}

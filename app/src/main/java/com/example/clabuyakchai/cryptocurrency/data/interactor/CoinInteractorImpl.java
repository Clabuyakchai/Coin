package com.example.clabuyakchai.cryptocurrency.data.interactor;

import com.example.clabuyakchai.cryptocurrency.data.local.entity.Favorite;
import com.example.clabuyakchai.cryptocurrency.data.model.CurrencyLatest;
import com.example.clabuyakchai.cryptocurrency.data.repository.CoinRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;

public class CoinInteractorImpl implements CoinInteractor {

    private final CoinRepository repository;

    @Inject
    public CoinInteractorImpl(CoinRepository repository) {
        this.repository = repository;
    }

    @Override
    public Single<List<CurrencyLatest>> getCurrencyFromApi(String sort){
        return repository.getCurrencyFromApi(sort);
    }

    @Override
    public Completable updateFavoriteInDb(Favorite favorite){
        return repository.updateFavoriteInDb(favorite);
    }

    @Override
    public Single<List<Favorite>> getFavoriteFromDb(){
        return repository.getFavoriteFromDb();
    }
}

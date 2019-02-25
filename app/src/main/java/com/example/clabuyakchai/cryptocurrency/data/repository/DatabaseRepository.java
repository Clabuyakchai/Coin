package com.example.clabuyakchai.cryptocurrency.data.repository;

import com.example.clabuyakchai.cryptocurrency.data.db.AppDatabase;
import com.example.clabuyakchai.cryptocurrency.data.db.entity.Favorite;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class DatabaseRepository implements IDatabaseRepository{
    private final AppDatabase appDatabase;

    @Inject
    public DatabaseRepository(AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
    }

    public void insert(Favorite favorite) {
        Completable.fromAction(() -> appDatabase.favoriteDao().insert(favorite));
    }

    public void delete(Favorite favorite) {
        Completable.fromAction(() -> appDatabase.favoriteDao().delete(favorite))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

    public void changeFavoriteById(Favorite favorite) {
        appDatabase.favoriteDao().getFavoriteById(favorite.getIdCoin())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    if (s == null) {
                        insert(s);
                    } else {
                        delete(s);
                    }
                }, Throwable::printStackTrace);


    }

    public Single<List<Favorite>> getFavorite(){
        return appDatabase.favoriteDao().getFavorite();
    }
}

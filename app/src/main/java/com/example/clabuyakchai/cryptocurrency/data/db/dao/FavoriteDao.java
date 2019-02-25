package com.example.clabuyakchai.cryptocurrency.data.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.clabuyakchai.cryptocurrency.data.db.entity.Favorite;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

@Dao
public interface FavoriteDao {
    @Insert
    void insert(Favorite favorite);

    @Update
    void update(Favorite favorite);

    @Delete
    void delete(Favorite favorite);

    @Query("SELECT * FROM favorite WHERE id = :id")
    Maybe<Favorite> getFavoriteById(int id);

    @Query("SELECT * FROM favorite")
    Single<List<Favorite>> getFavorite();
}

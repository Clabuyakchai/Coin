package com.example.clabuyakchai.cryptocurrency.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.clabuyakchai.cryptocurrency.data.local.dao.FavoriteDao;
import com.example.clabuyakchai.cryptocurrency.data.local.entity.Favorite;

@Database(entities = {Favorite.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FavoriteDao favoriteDao();
}
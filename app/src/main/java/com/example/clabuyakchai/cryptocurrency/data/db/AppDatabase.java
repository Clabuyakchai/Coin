package com.example.clabuyakchai.cryptocurrency.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.clabuyakchai.cryptocurrency.data.db.dao.FavoriteDao;
import com.example.clabuyakchai.cryptocurrency.data.db.entity.Favorite;

@Database(entities = {Favorite.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FavoriteDao favoriteDao();
}
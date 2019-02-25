package com.example.clabuyakchai.cryptocurrency.data.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "favorite")
public class Favorite {
    @PrimaryKey
    @ColumnInfo(name = "id")
    private int idCoin;

    public Favorite() {
    }

    public Favorite(int idCoin) {
        this.idCoin = idCoin;
    }

    public int getIdCoin() {
        return idCoin;
    }

    public void setIdCoin(int idCoin) {
        this.idCoin = idCoin;
    }
}

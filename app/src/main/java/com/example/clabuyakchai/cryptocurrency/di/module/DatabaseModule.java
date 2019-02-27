package com.example.clabuyakchai.cryptocurrency.di.module;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.clabuyakchai.cryptocurrency.data.local.AppDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    @Provides
    @Singleton
    public AppDatabase provideAppDatavase(Context context){
        return Room.databaseBuilder(context, AppDatabase.class, "db")
                .build();
    }
}

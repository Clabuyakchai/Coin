package com.example.clabuyakchai.cryptocurrency.di.module;

import android.content.Context;

import com.example.clabuyakchai.cryptocurrency.AndroidSampleApplication;
import com.example.clabuyakchai.cryptocurrency.data.interactor.CoinInteractor;
import com.example.clabuyakchai.cryptocurrency.data.interactor.CoinInteractorImpl;
import com.example.clabuyakchai.cryptocurrency.data.local.AppDatabase;
import com.example.clabuyakchai.cryptocurrency.data.remote.CryptoApi;
import com.example.clabuyakchai.cryptocurrency.data.repository.CoinRepository;
import com.example.clabuyakchai.cryptocurrency.data.repository.CoinRepositoryImpl;
import com.example.clabuyakchai.cryptocurrency.ui.presenter.CurrencyPresenterImpl;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class ApplicationModule {
    @Singleton
    @Binds
    public abstract Context provideContext(AndroidSampleApplication androidSampleApplication);

    @Singleton
    @Provides
    public static CoinRepository provideCoinRepository(CryptoApi cryptoApi, AppDatabase appDatabase){
        return new CoinRepositoryImpl(cryptoApi, appDatabase);
    }

    @Singleton
    @Provides
    public static CoinInteractor provideCoinInteractor(CoinRepository coinRepository){
        return new CoinInteractorImpl(coinRepository);
    }

    @Singleton
    @Provides
    public static CurrencyPresenterImpl provideCurrencyPresenter(CoinInteractor coinInteractor){
        return new CurrencyPresenterImpl(coinInteractor);
    }
}

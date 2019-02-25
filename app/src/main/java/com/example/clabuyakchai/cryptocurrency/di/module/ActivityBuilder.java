package com.example.clabuyakchai.cryptocurrency.di.module;

import com.example.clabuyakchai.cryptocurrency.di.scope.ActivityScope;
import com.example.clabuyakchai.cryptocurrency.ui.activity.currency.CurrencyActivity;
import com.example.clabuyakchai.cryptocurrency.ui.activity.currency.CurrencyActivityModule;
import com.example.clabuyakchai.cryptocurrency.ui.activity.login.LoginActivity;
import com.example.clabuyakchai.cryptocurrency.ui.activity.login.LoginActivityModule;
import com.example.clabuyakchai.cryptocurrency.ui.fragment.currency.CurrencyFragmentProvider;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {
    @ActivityScope
    @ContributesAndroidInjector(modules = {LoginActivityModule.class})
    abstract LoginActivity bindLoginActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = {CurrencyActivityModule.class, CurrencyFragmentProvider.class})
    abstract CurrencyActivity bindCryptoActivity();
}

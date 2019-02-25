package com.example.clabuyakchai.cryptocurrency.ui.fragment.currency;

import com.example.clabuyakchai.cryptocurrency.di.scope.FragmentScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface CurrencyFragmentProvider {
    @FragmentScope
    @ContributesAndroidInjector(modules = {CurrencyFragmentModule.class})
    CurrencyFragment provideCurrencyFragmentFactory();
}

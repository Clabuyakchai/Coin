package com.example.clabuyakchai.cryptocurrency;

import com.example.clabuyakchai.cryptocurrency.di.component.AppComponent;
import com.example.clabuyakchai.cryptocurrency.di.component.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class AndroidSampleApplication extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().create(this);
    }
}

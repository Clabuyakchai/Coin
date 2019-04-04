package com.example.clabuyakchai.cryptocurrency.di.component;

import com.example.clabuyakchai.cryptocurrency.AndroidSampleApplication;
import com.example.clabuyakchai.cryptocurrency.di.module.ActivityBuilder;
import com.example.clabuyakchai.cryptocurrency.di.module.ApplicationModule;
import com.example.clabuyakchai.cryptocurrency.di.module.DatabaseModule;
import com.example.clabuyakchai.cryptocurrency.di.module.PresenterModule;
import com.example.clabuyakchai.cryptocurrency.di.module.RemoteModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBuilder.class,
        RemoteModule.class,
        DatabaseModule.class,
        ApplicationModule.class,
        PresenterModule.class})
public interface AppComponent extends AndroidInjector<AndroidSampleApplication> {
    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<AndroidSampleApplication> {
    }
}
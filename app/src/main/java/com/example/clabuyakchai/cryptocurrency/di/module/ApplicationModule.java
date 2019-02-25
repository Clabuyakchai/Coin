package com.example.clabuyakchai.cryptocurrency.di.module;

import android.content.Context;

import com.example.clabuyakchai.cryptocurrency.AndroidSampleApplication;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class ApplicationModule {
    @Singleton
    @Binds
    public abstract Context provideContext(AndroidSampleApplication androidSampleApplication);
}

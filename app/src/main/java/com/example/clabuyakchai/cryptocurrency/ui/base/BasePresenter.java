package com.example.clabuyakchai.cryptocurrency.ui.base;

import android.support.annotation.CallSuper;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BasePresenter<T extends MvpView> extends MvpPresenter<T> {
    protected CompositeDisposable compositeDisposable;

    @CallSuper
    public void onViewCreated() {
        this.compositeDisposable = new CompositeDisposable();
    }

    @CallSuper
    public void onViewDestroy() {
        compositeDisposable.dispose();
    }
}

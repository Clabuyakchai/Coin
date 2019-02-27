package com.example.clabuyakchai.cryptocurrency.ui.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.example.clabuyakchai.cryptocurrency.data.interactor.CoinInteractor;
import com.example.clabuyakchai.cryptocurrency.data.local.entity.Favorite;
import com.example.clabuyakchai.cryptocurrency.ui.base.BasePresenter;
import com.example.clabuyakchai.cryptocurrency.ui.fragment.currency.CurrencyView;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

@InjectViewState
public class CurrencyPresenterImpl extends BasePresenter<CurrencyView> implements CurrencyPresenter {

    private final CoinInteractor coinInteractor;

    @Inject
    public CurrencyPresenterImpl(CoinInteractor coinInteractor) {
        this.coinInteractor = coinInteractor;
    }

    @Override
    public void onViewCreated() {
        requestToServer("market_cap");
    }

    private void requestToServer(String sort) {
        Disposable disposable = coinInteractor.temp(sort)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> getViewState().showCrypto(s), Throwable::printStackTrace);
        compositeDisposable.add(disposable);
    }

    @Override
    public void updateFavorite(Favorite favorite) {
        Disposable disposable = coinInteractor.updateFavoriteInDb(favorite)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
        compositeDisposable.add(disposable);
    }

    @Override
    public void onSortByUSDClick() {
        requestToServer("price");
    }

    @Override
    public void onSortByVolumeClick() {
        requestToServer("volume_24h");
    }

    @Override
    public void onCountFavoriteClick() {
        Disposable disposable = coinInteractor.getFavorite()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> getViewState().showSnackBar(String.valueOf(s.size())));
        compositeDisposable.add(disposable);
    }

    @Override
    public void onViewDestroy() {
        super.onViewDestroy();
    }
}

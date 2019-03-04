package com.example.clabuyakchai.cryptocurrency.ui.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.example.clabuyakchai.cryptocurrency.data.interactor.CoinInteractor;
import com.example.clabuyakchai.cryptocurrency.data.local.entity.Favorite;
import com.example.clabuyakchai.cryptocurrency.ui.base.BasePresenter;
import com.example.clabuyakchai.cryptocurrency.ui.fragment.currency.CurrencyView;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

import static com.example.clabuyakchai.cryptocurrency.util.SortUtil.MARKET_CAP;
import static com.example.clabuyakchai.cryptocurrency.util.SortUtil.PRICE;
import static com.example.clabuyakchai.cryptocurrency.util.SortUtil.SortDef;
import static com.example.clabuyakchai.cryptocurrency.util.SortUtil.VOLUME_24H;

@InjectViewState
public class CurrencyPresenterImpl extends BasePresenter<CurrencyView> implements CurrencyPresenter {

    private final CoinInteractor coinInteractor;

    @Inject
    public CurrencyPresenterImpl(CoinInteractor coinInteractor) {
        this.coinInteractor = coinInteractor;
    }

    @Override
    public void onViewCreated() {
        requestToServer(MARKET_CAP);
    }

    private void requestToServer(@SortDef String sort) {
        Disposable disposable = coinInteractor.getCurrencyFromApi(sort)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> getViewState().showCurrency(s), Throwable::printStackTrace);
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
    public void onSortByMarketCap() {
        requestToServer(MARKET_CAP);
    }

    @Override
    public void onSortByUSDClick() {
        requestToServer(PRICE);
    }

    @Override
    public void onSortByVolumeClick() {
        requestToServer(VOLUME_24H);
    }

    @Override
    public void onCountFavoriteClick() {
        Disposable disposable = coinInteractor.getFavoriteFromDb()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> getViewState().showSnackBar(String.valueOf(s.size())));
        compositeDisposable.add(disposable);
    }

    @Override
    public void onViewDestroy() {
        super.onViewDestroy();
    }
}

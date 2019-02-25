package com.example.clabuyakchai.cryptocurrency.ui.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.example.clabuyakchai.cryptocurrency.data.db.entity.Favorite;
import com.example.clabuyakchai.cryptocurrency.ui.base.BasePresenter;
import com.example.clabuyakchai.cryptocurrency.ui.fragment.currency.ICurrencyView;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

@InjectViewState
public class CurrencyPresenter extends BasePresenter<ICurrencyView> {

//    @Inject
//    CurrencyModel model;
//
//    @Inject
//    public CurrencyPresenter() {
//    }
//
//    private void requestToServer(){
//        Disposable disposable = model.temp()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(s -> getViewState().showCrypto(s), Throwable::printStackTrace);
//        compositeDisposable.add(disposable);
//    }
//
//    public void setFavorite(Favorite favorite){
//        model.changeFavorite(favorite);
//    }

    @Override
    public void onViewCreated() {
//        requestToServer();
    }

    @Override
    public void onViewDestroy() {
        super.onViewDestroy();
    }
}

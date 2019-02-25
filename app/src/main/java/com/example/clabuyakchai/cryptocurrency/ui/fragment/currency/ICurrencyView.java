package com.example.clabuyakchai.cryptocurrency.ui.fragment.currency;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.clabuyakchai.cryptocurrency.data.model.CurrencyLatest;
import com.example.clabuyakchai.cryptocurrency.ui.base.IBaseView;

import java.util.List;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface ICurrencyView extends IBaseView {
    void showCrypto(List<CurrencyLatest> latests);
}

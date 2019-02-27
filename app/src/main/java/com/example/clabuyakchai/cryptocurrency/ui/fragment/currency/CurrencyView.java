package com.example.clabuyakchai.cryptocurrency.ui.fragment.currency;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.clabuyakchai.cryptocurrency.data.model.CurrencyLatest;
import com.example.clabuyakchai.cryptocurrency.ui.base.BaseView;

import java.util.List;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface CurrencyView extends BaseView {
    void showCrypto(List<CurrencyLatest> latests);
    @StateStrategyType(OneExecutionStateStrategy.class)
    void showSnackBar(String line);
}

package com.example.clabuyakchai.cryptocurrency.ui.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.example.clabuyakchai.cryptocurrency.ui.base.BasePresenter;
import com.example.clabuyakchai.cryptocurrency.ui.fragment.login.ILoginView;

@InjectViewState
public class LoginPresenter extends BasePresenter<ILoginView> {
    @Override
    public void onViewCreated() {

    }

    @Override
    public void onViewDestroy() {
        super.onViewDestroy();
    }
}

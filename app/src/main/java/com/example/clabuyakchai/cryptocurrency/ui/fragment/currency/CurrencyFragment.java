package com.example.clabuyakchai.cryptocurrency.ui.fragment.currency;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.clabuyakchai.cryptocurrency.R;
import com.example.clabuyakchai.cryptocurrency.data.db.entity.Favorite;
import com.example.clabuyakchai.cryptocurrency.data.model.CurrencyLatest;
import com.example.clabuyakchai.cryptocurrency.ui.adapter.CurrencyAdapter;
import com.example.clabuyakchai.cryptocurrency.ui.adapter.FavoriteCallBack;
import com.example.clabuyakchai.cryptocurrency.ui.base.BaseFragment;
import com.example.clabuyakchai.cryptocurrency.ui.presenter.CurrencyPresenter;

import java.util.List;

import javax.inject.Inject;

public class CurrencyFragment extends BaseFragment implements ICurrencyView, FavoriteCallBack {

    private RecyclerView recyclerView;
    private CurrencyAdapter adapter;
    @Inject
    @InjectPresenter
    CurrencyPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_currency, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),
                DividerItemDecoration.VERTICAL));

        presenter.onViewCreated();
        return view;
    }

    public static CurrencyFragment newInstance() {
        return new CurrencyFragment();
    }

    @ProvidePresenter
    CurrencyPresenter getPresenter() {
        return presenter;
    }

    @Override
    public void showCrypto(List<CurrencyLatest> latests) {
        setRecyclerView(latests);
    }

    private void setRecyclerView(List<CurrencyLatest> latests){
        adapter = new CurrencyAdapter(latests, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void changeFavoriteState(Favorite favorite) {
        presenter.setFavorite(favorite);
    }

    @Override
    public void onDestroy() {
        presenter.onViewDestroy();
        super.onDestroy();
    }
}
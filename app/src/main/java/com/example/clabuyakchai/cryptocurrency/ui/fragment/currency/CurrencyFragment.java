package com.example.clabuyakchai.cryptocurrency.ui.fragment.currency;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.clabuyakchai.cryptocurrency.R;
import com.example.clabuyakchai.cryptocurrency.data.local.entity.Favorite;
import com.example.clabuyakchai.cryptocurrency.data.model.CurrencyLatest;
import com.example.clabuyakchai.cryptocurrency.ui.adapter.CurrencyAdapter;
import com.example.clabuyakchai.cryptocurrency.ui.adapter.FavoriteCallBack;
import com.example.clabuyakchai.cryptocurrency.ui.base.BaseFragment;
import com.example.clabuyakchai.cryptocurrency.ui.presenter.CurrencyPresenterImpl;

import java.util.List;

import javax.inject.Inject;

public class CurrencyFragment extends BaseFragment implements CurrencyView, FavoriteCallBack {

    private RecyclerView recyclerView;
    private CurrencyAdapter adapter;

    @Inject
    @InjectPresenter
    CurrencyPresenterImpl presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

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
    CurrencyPresenterImpl providePresenter() {
        return presenter;
    }

    @Override
    public void showCrypto(List<CurrencyLatest> latests) {
        setRecyclerView(latests);
    }

    private void setRecyclerView(List<CurrencyLatest> latests) {
        adapter = new CurrencyAdapter(latests, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void changeFavoriteState(Favorite favorite) {
        presenter.updateFavorite(favorite);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_coin, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_sort_by_usd:
                //TODO
                presenter.onSortByUSDClick();
                return true;
            case R.id.menu_sort_by_volume:
                presenter.onSortByVolumeClick();
                return true;
            case R.id.menu_favorite:
                    presenter.onCountFavoriteClick();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void showSnackBar(String line) {
        Snackbar.make(getView(), line, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy() {
        presenter.onViewDestroy();
        super.onDestroy();
    }
}
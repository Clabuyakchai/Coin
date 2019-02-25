package com.example.clabuyakchai.cryptocurrency.data.repository;

import com.example.clabuyakchai.cryptocurrency.data.model.CurrencyLatest;

import java.util.List;

import io.reactivex.Single;

public interface IRemoteRepository {
    Single<List<CurrencyLatest>> temp();
}

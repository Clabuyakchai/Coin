package com.example.clabuyakchai.cryptocurrency.data.repository;

import com.example.clabuyakchai.cryptocurrency.data.model.CurrencyLatest;
import com.example.clabuyakchai.cryptocurrency.data.remote.CryptoApi;
import com.example.clabuyakchai.cryptocurrency.data.remote.model.info.Coin;
import com.example.clabuyakchai.cryptocurrency.data.remote.model.info.Info;
import com.example.clabuyakchai.cryptocurrency.data.remote.model.latest.Latest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class RemoteRepository implements IRemoteRepository {
    private final CryptoApi cryptoApi;

    @Inject
    public RemoteRepository(CryptoApi cryptoApi) {
        this.cryptoApi = cryptoApi;
    }

    @Override
    public Single<List<CurrencyLatest>> temp() {
        return cryptoApi.getCryptoLatest()
                .subscribeOn(Schedulers.io())
                .flatMap(crypto -> {
                    List<CurrencyLatest> currencyLatest = mapCurrencyLatest(crypto);
                    return cryptoApi.getCryptoInfo(query(currencyLatest))
                            .flatMap(info -> Single.just(mapInfoToCurrencyLatest(info, currencyLatest)));
                });
    }

    private List<CurrencyLatest> mapCurrencyLatest(Latest latest) {
        List<CurrencyLatest> latests = new ArrayList<>();

        for (int i = 0; i < latest.getData().size(); i++) {
            latests.add(new CurrencyLatest(
                    String.valueOf(latest.getData().get(i).getId()),
                    latest.getData().get(i).getSymbol(),
                    latest.getData().get(i).getQuote().getUSD().getPrice(),
                    latest.getData().get(i).getQuote().getUSD().getPercentChange1h()));
        }

        return latests;
    }

    private List<CurrencyLatest> mapInfoToCurrencyLatest(Info info, List<CurrencyLatest> latests) {
        for (int i = 0; i < info.getData().size(); i++) {
            Coin coin = info.getData().get(latests.get(i).getId());
            latests.get(i).setLogo(coin.getLogo());
        }
        return latests;
    }

    private String query(List<CurrencyLatest> latests) {
        String SEPARATOR = ",";
        StringBuilder builder = new StringBuilder();
        for (CurrencyLatest latest : latests) {
            builder.append(latest.getId());
            builder.append(SEPARATOR);
        }
        String csv = builder.toString();
        return csv.substring(0, csv.length() - SEPARATOR.length());
    }
}

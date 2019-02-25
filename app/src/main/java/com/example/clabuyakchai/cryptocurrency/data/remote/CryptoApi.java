package com.example.clabuyakchai.cryptocurrency.data.remote;

import com.example.clabuyakchai.cryptocurrency.data.remote.model.info.Info;
import com.example.clabuyakchai.cryptocurrency.data.remote.model.latest.Latest;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CryptoApi {
    @Headers("X-CMC_PRO_API_KEY:bd059841-89f5-4f03-bb83-495352e0ce24")
    @GET("/v1/cryptocurrency/listings/latest?limit=10")
    Single<Latest> getCryptoLatest();

    @Headers("X-CMC_PRO_API_KEY:bd059841-89f5-4f03-bb83-495352e0ce24")
    @GET("/v1/cryptocurrency/info")
    Single<Info> getCryptoInfo(@Query("id") String id);
}

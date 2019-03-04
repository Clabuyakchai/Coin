package com.example.clabuyakchai.cryptocurrency.util;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class SortUtil {
    @Retention(RetentionPolicy.SOURCE)
    @StringDef({MARKET_CAP, PRICE, VOLUME_24H})
    public @interface SortDef {
    }

    public static final String MARKET_CAP = "market_cap";
    public static final String PRICE = "price";
    public static final String VOLUME_24H = "volume_24h";
}

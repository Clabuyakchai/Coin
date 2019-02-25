package com.example.clabuyakchai.cryptocurrency.data.model;

public class CurrencyLatest {
    private String id;
    private String symbol;
    private Double price;
    private Double percentChange;
    private String logo;
    private boolean isFavorite;

    public CurrencyLatest(String id, String symbol, Double price, Double percentChange) {
        this.id = id;
        this.symbol = symbol;
        this.price = price;
        this.percentChange = percentChange;
        this.isFavorite = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(Double percentChange) {
        this.percentChange = percentChange;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        this.isFavorite = favorite;
    }
}

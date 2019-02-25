
package com.example.clabuyakchai.cryptocurrency.data.remote.model.info;

import com.example.clabuyakchai.cryptocurrency.data.remote.model.Status;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class Info {

    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("data")
    @Expose
    private Map<String, Coin> data;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Map<String, Coin> getData() {
        return data;
    }

    public void setData(Map<String, Coin> data) {
        this.data = data;
    }
}

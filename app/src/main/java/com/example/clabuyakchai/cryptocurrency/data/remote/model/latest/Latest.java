
package com.example.clabuyakchai.cryptocurrency.data.remote.model.latest;

import java.util.List;

import com.example.clabuyakchai.cryptocurrency.data.remote.model.Status;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Latest {

    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

}

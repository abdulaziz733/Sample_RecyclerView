package com.listne.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by abdul on 6/13/2017.
 */

public class ListNe extends BaseApiModel {

    @SerializedName("result")
    @Expose
    private List<Ne> result = null;

    public List<Ne> getResult() {
        return result;
    }

    public void setResult(List<Ne> result) {
        this.result = result;
    }
}

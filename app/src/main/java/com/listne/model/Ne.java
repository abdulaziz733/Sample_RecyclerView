package com.listne.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by abdul on 6/13/2017.
 */

public class Ne {
    @SerializedName("id_ne")
    @Expose
    private Integer idNe;
    @SerializedName("ne")
    @Expose
    private String ne;

    public Integer getIdNe() {
        return idNe;
    }

    public void setIdNe(Integer idNe) {
        this.idNe = idNe;
    }

    public String getNe() {
        return ne;
    }

    public void setNe(String ne) {
        this.ne = ne;
    }
}

package com.listne.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.listne.model.ListNe;
import com.listne.utils.Constant;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by abdul on 6/13/2017.
 */

public interface ApiInterface {


    @GET(Constant.LIST_NE)
    Call<ListNe> getListNe();



}

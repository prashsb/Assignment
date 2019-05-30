package com.winjit.assignement.Api;

import com.winjit.assignement.model.Rest_model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("db")
    Call<Rest_model> getData();

}

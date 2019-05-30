package com.winjit.assignement;

import android.util.Log;

import com.winjit.assignement.Api.ApiClient;
import com.winjit.assignement.Api.ApiInterface;
import com.winjit.assignement.model.Rest_model;
import com.winjit.assignement.model.state_data;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataListModel implements MainInterfaces.Model {

    private final String TAG = "MainData";

    @Override
    public void getMainData(final OnFinishedListener onFinishedListener) {


        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<Rest_model> call = apiService.getData();
        call.enqueue(new Callback<Rest_model>() {
            @Override
            public void onResponse(Call<Rest_model> call, Response<Rest_model> response) {
                List<state_data> data = response.body().getMainData();
                Log.d(TAG, "Number of applicants received: " + data.size());
                onFinishedListener.onFinished(data);
            }

            @Override
            public void onFailure(Call<Rest_model> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
                onFinishedListener.onFailure(t);
            }
        });


    }
}

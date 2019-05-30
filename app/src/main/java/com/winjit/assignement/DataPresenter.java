package com.winjit.assignement;

import android.util.Log;

import com.winjit.assignement.model.state_data;

import java.util.List;

public class DataPresenter implements MainInterfaces.Presenter, MainInterfaces.Model.OnFinishedListener {


    private MainInterfaces.View DataListView;

    private MainInterfaces.Model DataListModel;

    public DataPresenter(MainInterfaces.View dataListView) {
        DataListView = dataListView;
        DataListModel = new DataListModel();
    }

    @Override
    public void onFinished(List<state_data> mainData) {
        DataListView.setDataToMap(mainData);
        Log.i("TAG","getting data size  "+mainData.size());
        if (DataListView != null){
            DataListView.hideProgress();
        }


    }

    @Override
    public void onFailure(Throwable t) {
        DataListView.onResponseFailure(t);
        Log.i("TAG","getting data fail  "+t.getLocalizedMessage());
        if (DataListView != null){
            DataListView.hideProgress();
        }
    }

    @Override
    public void onDestroy() {
        this.DataListView = null;
    }

    @Override
    public void requestDataFromServer() {

        if (DataListView != null){
            DataListView.showProgress();
        }

        DataListModel.getMainData(this);
        Log.i("TAG","getting data");
    }
}

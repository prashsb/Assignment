package com.winjit.assignement;

import com.winjit.assignement.model.Rest_model;
import com.winjit.assignement.model.state_data;

import java.util.List;

public interface MainInterfaces {


    interface Model {

        interface OnFinishedListener {
            void onFinished(List<state_data> mainData);

            void onFailure(Throwable t);
        }

        void getMainData(OnFinishedListener onFinishedListener);

    }

    interface View {

        void showProgress();

        void hideProgress();

        void setDataToMap (List<state_data> data);

        void onResponseFailure(Throwable throwable);

    }

    interface Presenter {

        void onDestroy();


        void requestDataFromServer();

    }



}

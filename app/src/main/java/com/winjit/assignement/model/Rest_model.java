package com.winjit.assignement.model;

import java.util.ArrayList;
import java.util.List;

public class Rest_model {
   private List<state_data > MainData = new ArrayList<>();

    public Rest_model(List<state_data> mainData) {
        MainData = mainData;
    }

    public Rest_model() {
    }

    public List<state_data> getMainData() {
        return MainData;
    }
}

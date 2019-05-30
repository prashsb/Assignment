package com.winjit.assignement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.winjit.assignement.model.applicants_data;

import java.lang.reflect.Type;
import java.util.List;


public class Applicants_details extends AppCompatActivity {



    RecyclerView recyclerview;
    Applicant_adapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.applicants_detail);
        recyclerview = findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager manager=new LinearLayoutManager(this);
        recyclerview.setLayoutManager(manager);
        recyclerview.setHasFixedSize(true);
        adapter = new Applicant_adapter(this);
        recyclerview.setAdapter(adapter);

        Gson gson = new Gson();
        Type listOfdoctorType = new TypeToken<List<applicants_data>>() {}.getType();
        List<applicants_data> data = gson.fromJson(getIntent().getStringExtra("EXTRA"),listOfdoctorType);
        adapter.setData(data);

    }
}

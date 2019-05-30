package com.winjit.assignement;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.google.maps.android.data.kml.KmlContainer;
import com.google.maps.android.data.kml.KmlLayer;
import com.winjit.assignement.model.applicants_data;
import com.winjit.assignement.model.state_data;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends FragmentActivity implements MainInterfaces.View, OnMapReadyCallback
, GoogleMap.OnMarkerClickListener {


    private DataPresenter dataPresenter;
    private GoogleMap mMap;
    private List<state_data> data;
    private List<Marker> markers = new ArrayList<>();
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataPresenter = new DataPresenter(this);
        dataPresenter.requestDataFromServer();


    }

    @Override
    public void showProgress() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        View view=MainActivity.this.getLayoutInflater().inflate(R.layout.loading,null);
        alert.setView(view);
        dialog = alert.create();
        dialog.show();
    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setDataToMap(List<state_data> data) {
        this.data = data;
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onResponseFailure(Throwable throwable) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMarkerClickListener(this);
        try {
            KmlLayer layer =new KmlLayer(googleMap,R.raw.india,MainActivity.this);
            layer.addLayerToMap();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

       for (int i=0; i<data.size(); i++){
           state_data state_data=data.get(i);
           LatLng lt = new LatLng(state_data.getLatitude(), state_data.getLongitude());
          Marker marker = mMap.addMarker(new MarkerOptions().position(lt).title(String.valueOf(state_data.getTotal())).snippet(state_data.getState()));
          markers.add(marker);
       }
        LatLng delhi = new LatLng(21.1458, 79.0882);
        CameraPosition build = new CameraPosition.Builder().target(delhi).zoom(5.0f).bearing(0.0f).tilt(0.0f).build();
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(build));
        if (dialog!=null){
            dialog.dismiss();
        }
    }

    @Override
    public boolean onMarkerClick(Marker marker) {

        Intent intent = new Intent(MainActivity.this,Applicants_details.class);
        Gson gson = new Gson();


        state_data appData = data.get(markers.indexOf(marker));
        String rh = gson.toJson(appData.getData());
        intent.putExtra("EXTRA",rh);
        startActivity(intent);

        return false;
    }
}

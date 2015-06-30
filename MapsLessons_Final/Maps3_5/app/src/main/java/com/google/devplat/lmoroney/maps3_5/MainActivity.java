/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.devplat.lmoroney.maps3_5;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;


public class MainActivity extends ActionBarActivity implements OnMapReadyCallback {

    GoogleMap m_map;
    boolean mapReady = false;


    MarkerOptions home;
    MarkerOptions oldHome;
    MarkerOptions building101;
    MarkerOptions trueYoga;
    MarkerOptions taishinBank;
    MarkerOptions homeTom;


    LatLng homeLL = new LatLng(24.938486, 121.503394);
    LatLng oldHomeLL = new LatLng(25.028104, 121.499944);
    LatLng building101LL = new LatLng(25.033720, 121.564811);
    LatLng trueYogaLL = new LatLng(25.041626, 121.564047);
    LatLng taishinBankLL = new LatLng(25.037573, 121.550077);
    LatLng homeTomLL = new LatLng(25.073208, 121.469505);


    static final CameraPosition HOME = CameraPosition.builder()
            .target(new LatLng(24.938486, 121.503394))
            .zoom(11)
            .bearing(0)
            .tilt(90)
            .build();

    static final CameraPosition SEATTLE = CameraPosition.builder()
            .target(new LatLng(47.6204, -122.2491))
            .zoom(10)
            .bearing(0)
            .tilt(45)
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        home = new MarkerOptions()
                .position(new LatLng(24.938486, 121.503394))
                .title("Home")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));

        oldHome = new MarkerOptions()
                .position(new LatLng(25.028104, 121.499944))
                .title("Old Home")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));

        building101 = new MarkerOptions()
                .position(new LatLng(25.033720, 121.564811))
                .title("101")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));

        trueYoga = new MarkerOptions()
                .position(new LatLng(25.041626, 121.564047))
                .title("True Yoga")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));

        taishinBank = new MarkerOptions()
                .position(new LatLng(25.037573, 121.550077))
                .title("Taishin Bank")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));

        homeTom = new MarkerOptions()
                .position(new LatLng(25.073208, 121.469505))
                .title("Hometom")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        mapReady = true;
        m_map = map;

        m_map.addMarker(home);
        m_map.addMarker(oldHome);
        m_map.addMarker(building101);
        m_map.addMarker(trueYoga);
        m_map.addMarker(taishinBank);
        m_map.addMarker(homeTom);

        map.moveCamera(CameraUpdateFactory.newCameraPosition(HOME));

        map.addPolyline(new PolylineOptions().geodesic(true)
                        .add(homeLL)
//                        .add(oldHomeLL)
//                        .add(homeTomLL)
                        .add(taishinBankLL)
                        .add(trueYogaLL)
                        .add(homeLL)
        );

        //map.addPolygon(new PolygonOptions().add(homeLL, oldHomeLL, trueYogaLL, homeLL).fillColor(Color.GREEN));

        //map.addCircle(new CircleOptions()
        //.center(homeLL)
        //.radius(5000)
        //.strokeColor(Color.GREEN)
        //.fillColor(Color.argb(64,0,255,0)));

    }


}

package com.example.hamrobook_ebookstore;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.example.hamrobook_ebookstore.model.LatitudeLongitude;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        List<LatitudeLongitude> latitudeLongitudes = new ArrayList<>();
        latitudeLongitudes.add(new LatitudeLongitude(27.706366, 85.330136, "Softwarica College of IT and E-Commerce"));

        CameraUpdate center, zoom;
        for (int i = 0; i < latitudeLongitudes.size(); i++) {
            center = CameraUpdateFactory.newLatLng(new LatLng(latitudeLongitudes.get(i).getLat(), latitudeLongitudes.get(i).getLon()));
            zoom = CameraUpdateFactory.zoomTo(16);
            mMap.addMarker(new MarkerOptions().position(new LatLng(latitudeLongitudes.get(i).getLat(),
                    latitudeLongitudes.get(i).getLon())).title(latitudeLongitudes.get(i).getMarker()));

            mMap.moveCamera(center);
            mMap.animateCamera(zoom);
            mMap.getUiSettings().setZoomControlsEnabled(true);
        }
    }
}
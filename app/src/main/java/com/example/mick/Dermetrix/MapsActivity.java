package com.example.mick.Dermetrix;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng Sebacia = new LatLng(34.005757, -84.093159);
        mMap.addMarker(new MarkerOptions().position(Sebacia).title("Marker in Sebacia"));
        float zoomLevel = 16.0f; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Sebacia, zoomLevel));

        LatLng Derm = new LatLng(34.001594, -84.161444);
        mMap.addMarker(new MarkerOptions().position(Derm).title("Marker in North Atlanta Dermatology"));

        LatLng Derm1 = new LatLng(34.023491, -84.189837);
        mMap.addMarker(new MarkerOptions().position(Derm1).title("Marker in Dermatology Center of Atlanta"));

        LatLng Derm2 = new LatLng(33.966605, -84.224488);
        mMap.addMarker(new MarkerOptions().position(Derm2).title("Marker in Dermatology Associates"));

    }
}
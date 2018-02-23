package com.example.yurip.livehealth.view;

import android.Manifest;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.yurip.livehealth.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

public class HospitalActivity extends FragmentActivity
        implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener{

    private static final int LOCATION_REQUEST_CODE = 101;
    private GoogleMap mMap;
    private GoogleApiClient googleApiClient;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);

        googleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();

    }

    @Override
    protected void onStart() {
        super.onStart();
        googleApiClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        googleApiClient.disconnect();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == LOCATION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PERMISSION_GRANTED) {
                checkLocationAndAddToMap();
            } else
                Toast.makeText(this, "Location Permission Denied", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        prepareMap();
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        checkLocationAndAddToMap();
    }

    private void prepareMap() {
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void checkLocationAndAddToMap() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PERMISSION_GRANTED && ActivityCompat
                .checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) !=
                PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission
                    .ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, LOCATION_REQUEST_CODE);
            return;
        }

        FusedLocationProviderApi fusedLocationProviderApi = LocationServices.FusedLocationApi;
        Location location = fusedLocationProviderApi.getLastLocation(googleApiClient);

        if (location == null) {
            Toast.makeText(this, "O GPS não conseguiu localizar sua posição atual",
                    Toast.LENGTH_SHORT).show();
        } else {
            MarkerOptions markerOptions = new MarkerOptions().position(new LatLng
                    (location.getLatitude(), location.getLongitude())).title("Estou aqui!");

            mMap.addMarker(markerOptions);
        }

    }

}

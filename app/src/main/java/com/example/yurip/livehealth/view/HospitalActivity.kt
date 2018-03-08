package com.example.yurip.livehealth.view

import android.Manifest
import android.support.v4.app.ActivityCompat
import android.support.v4.app.FragmentActivity
import android.os.Bundle
import android.widget.Toast

import com.example.yurip.livehealth.R
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

import android.content.pm.PackageManager.PERMISSION_GRANTED
import org.androidannotations.annotations.EActivity

@EActivity(R.layout.activity_hospital)
open class HospitalActivity : FragmentActivity(), OnMapReadyCallback, GoogleApiClient
.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private var mMap: GoogleMap? = null
    private var googleApiClient: GoogleApiClient? = null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        googleApiClient = GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build()
    }

    override fun onStart() {
        super.onStart()
        googleApiClient!!.connect()
    }

    override fun onStop() {
        super.onStop()
        googleApiClient!!.disconnect()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>,
                                            grantResults: IntArray) {
        if (requestCode == LOCATION_REQUEST_CODE) {
            if (grantResults.size > 0 && grantResults[0] == PERMISSION_GRANTED) {
                checkLocationAndAddToMap()
            } else
                Toast.makeText(this, "Location Permission Denied", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onConnected(bundle: Bundle?) {
        prepareMap()
    }

    override fun onConnectionSuspended(i: Int) {

    }

    override fun onConnectionFailed(connectionResult: ConnectionResult) {

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        checkLocationAndAddToMap()
    }

    private fun prepareMap() {
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun checkLocationAndAddToMap() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PERMISSION_GRANTED && ActivityCompat
                        .checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission
                    .ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION), LOCATION_REQUEST_CODE)
            return
        }

        val fusedLocationProviderApi = LocationServices.FusedLocationApi
        val location = fusedLocationProviderApi.getLastLocation(googleApiClient)

        if (location == null) {
            Toast.makeText(this, "O GPS não conseguiu localizar sua posição atual",
                    Toast.LENGTH_SHORT).show()
        } else {
            val markerOptions = MarkerOptions().position(LatLng(location.latitude, location.longitude)).title("Estou aqui!")

            mMap!!.addMarker(markerOptions)
        }

    }

    companion object {
        private val LOCATION_REQUEST_CODE = 101
    }

}

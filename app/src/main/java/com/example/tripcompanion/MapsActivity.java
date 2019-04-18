package com.example.tripcompanion;

import android.location.LocationListener;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    EditText e1;
    //LocationRequest request;
    LatLng latLngCurrent;
    GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        //e1 = (EditText)findViewById(R.id.editText);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

   /* public void findRestaurents(View v){
      StringBuilder stringBuilder = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch?json?");
      stringBuilder.append("location="+latLngCurrent.latitude + ","+latLngCurrent.longitude);
      stringBuilder.append("&radius="+1000);
      stringBuilder.append("&keyword="+"restaurent");
      stringBuilder.append("&key="+getResources().getString(R.string.google_places_key));

      String url = stringBuilder.toString();

      Object dataTransfer[] = new Object[2];
      dataTransfer[0] = mMap;
      dataTransfer[1] = url;

      GetNearByPlaces getNearByPlaces = new GetNearByPlaces(this);
      getNearByPlaces.execute(dataTransfer);
    }*/

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
        googleMap.getUiSettings().setZoomGesturesEnabled(true);

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        // Add sample location marker
        //final LatLng TutorialsPoint = new LatLng(21 , 57);
        //mMap.addMarker(new MarkerOptions().position(TutorialsPoint).title("TutorialsPoint"));
    }
}

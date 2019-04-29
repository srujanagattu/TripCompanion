package com.example.tripcompanion;

import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private FusedLocationProviderClient mClient;
    private GoogleMap mMap;
    EditText e1;
    //LocationRequest request;
    LatLng latLngCurrent;
    GoogleApiClient client;
    double longitude;
    double latitude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        //e1 = (EditText)findViewById(R.id.editText);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        requestPermission();
        mClient = LocationServices.getFusedLocationProviderClient(this);

        if (ActivityCompat.checkSelfPermission(MapsActivity.this, ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ) {

            return;
        }
        mClient.getLastLocation().addOnSuccessListener(MapsActivity.this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location!= null){
                    //TextView textView = findViewById(R.id.textlocation);
                    latitude = location.getLatitude();
                    longitude = location.getLongitude();

                    Log.d("location", location.toString());
                    Log.d("location latitude", String.valueOf(location.getLatitude()));
                    Log.d("location longitude", String.valueOf(location.getLongitude()));
                    //textView.setText(location.toString());
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_tripcompanion,menu);
        return true;
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
        LatLng currentLocation = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(currentLocation).title("Your Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(currentLocation));

        //Add sample location marker
        //final LatLng TutorialsPoint = new LatLng(21 , 57);
        //mMap.addMarker(new MarkerOptions().position(TutorialsPoint).title("TutorialsPoint"));
    }
    private void requestPermission(){
        ActivityCompat.requestPermissions(this, new String[]{ACCESS_FINE_LOCATION},1);
        ActivityCompat.requestPermissions(this, new String[]{ACCESS_COARSE_LOCATION},1);
    }
}

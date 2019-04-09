package com.example.tripcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class TripOptions extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trip_options);
    }
    public void FourthAct(View v){
        Intent intent=new Intent(this,Destination.class);
        startActivity(intent);
    }
    public void MapAct(View v){
        Intent intent=new Intent(this,MapsActivity.class);
        startActivity(intent);
    }
}

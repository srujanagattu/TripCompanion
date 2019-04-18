package com.example.tripcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TripOptions extends AppCompatActivity {
    String test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trip_options);
        Intent ini=getIntent();
        test=ini.getStringExtra("user_id");
    }
    @Override
    public void onBackPressed() {

       // Toast.makeText(TripOptions.this, "Back Button is being Pressed!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), Login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        super.onBackPressed();




    }
    public void FourthAct(View v){
        Intent intent=new Intent(this,Destination.class);
        Log.d("dfsdf","dristif"+test);
        intent.putExtra("user_id", test);
        startActivity(intent);
    }
    public void MapAct(View v){
        Intent intent=new Intent(this,MapsActivity.class);
        startActivity(intent);
    }
}

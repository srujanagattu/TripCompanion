package com.example.tripcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TripOptions extends AppCompatActivity {
    String test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trip_options);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent ini=getIntent();
        test=ini.getStringExtra("user_id");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_tripcompanion,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.account:
                Intent ini=getIntent();
                test=ini.getStringExtra("user_id");
                Intent intent = new Intent(this, UserDetails.class);
                Log.d("df","test id"+test);

                intent.putExtra("objectId",test);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Account item is selected",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.logout:
                Intent intent1 = new Intent(this, Login.class);

                startActivity(intent1);
                return true;
            case R.id.friend:
                Intent intent2 = new Intent(this, friend.class);
                intent2.putExtra("objectId",test);
                startActivity(intent2);
                Toast.makeText(getApplicationContext(),"Friend item is selected",Toast.LENGTH_SHORT).show();

                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
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

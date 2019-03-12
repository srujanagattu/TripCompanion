package com.example.tripcompanion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void ThirdAct(View v){
        Intent intent=new Intent(this,TripOptions.class);
        startActivity(intent);
    }
    public void SignupAct(View v){
        Intent ini=new Intent(this,SignUp.class);
        startActivity(ini);
    }
}

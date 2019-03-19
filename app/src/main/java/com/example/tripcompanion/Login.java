package com.example.tripcompanion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void GoToTripOptionsActivity(View v){
        //Toast.makeText(getApplicationContext(),"Clicked",Toast.LENGTH_LONG).show();
        EditText username;
        EditText password;
        username = (EditText) findViewById(R.id.username);
        String user = username.getText().toString();
        password = (EditText) findViewById(R.id.password);
        String pass = password.getText().toString();

        Log.d("Username", "The username and password user entered" + user +"  "+ pass);
        if(user.equals("username") && pass.equals("password") ) {
            Intent intent=new Intent(this,TripOptions.class);
            startActivity(intent);
        } else{

            Toast.makeText(getApplicationContext(),"user name = username and password = password",Toast.LENGTH_LONG).show();
        }

    }
    public void GoToSignupActivity(View v){
        Intent ini=new Intent(this,SignUp.class);
        startActivity(ini);
    }

}

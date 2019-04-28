package com.example.tripcompanion;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.ParseInstallation;

import java.util.List;

public class Login extends AppCompatActivity {
    int flag = 0;
    Toast toast;
    String test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Parse.initialize(this);
        ParseInstallation.getCurrentInstallation().saveInBackground();

        setContentView(R.layout.activity_login);
    }
    public void displayToast(String message) {
        if (toast != null)
            toast.cancel();
        toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
        toast.show();
    }
    protected void onPause() {
        if (toast != null)
            toast.cancel();
        super.onPause();
    }
    public void GoToTripOptionsActivity(View v) {
        final ParseQuery < ParseObject > query = ParseQuery.getQuery("Trip");
        // Fetches all the Movie objects
        query.findInBackground(new FindCallback < ParseObject > () {
            @Override
            public void done(List < ParseObject > tripList, ParseException e) {

                String userName;
                String password;
                if (e == null) {
                    Log.d("Parse", "Trips retrieved:" + tripList.size());
                    // Do something with the found objects
                    for (int i = 0; i < tripList.size(); i++) {
                        userName = (String) tripList.get(i).get("name");
                        password = (String) tripList.get(i).get("password");
                        EditText username1;
                        EditText password1;
                        username1 = (EditText) findViewById(R.id.username);
                        String user = username1.getText().toString().trim().toLowerCase();

                        password1 = (EditText) findViewById(R.id.password);
                        String pass = password1.getText().toString().trim().toLowerCase();

                        Log.d("Username", "The username and password user entered" + user + "  " + pass);
                        if (user.equals(userName) && pass.equals(password)) {
                            test = tripList.get(i).getObjectId();
                            Log.d("dfsdf", "dsfsdf" + test);
                            onPause();
                            GoToTripActivity();

                        } else {
                            if (flag == 0) {
                                displayToast("Please enter correct details!");
                            }
                        }
                    }
                } else {
                    Log.d("Parse", "Error: " + e.getMessage());
                }
            }
        });


        //      Cursor cursor = db.getRecords(user);
        //        String userName = "";
        //        String password2= "";
        //        if (cursor.moveToFirst()){
        //            do{
        //                userName = cursor.getString(cursor.getColumnIndex("email"));
        //                password2 = cursor.getString(cursor.getColumnIndex("password"));
        //                // do what ever you want here
        //                System.out.println(userName+""+password2);
        //            }while(cursor.moveToNext());
        //        }
        //        cursor.close();



    } //end of login method
    public void GoToTripActivity() {
        onPause();
        flag = 1;
        Intent intent = new Intent(this, TripOptions.class);
        Log.d("dfsdf", "dristif" + test);
        intent.putExtra("user_id", test);
        startActivity(intent);




    }
    public void GoToSignupActivity(View v) {
        Intent ini = new Intent(this, SignUp.class);
        startActivity(ini);
    }

}
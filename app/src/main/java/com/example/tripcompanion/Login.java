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

public class Login extends AppCompatActivity {


    SQLHelperClass db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new SQLHelperClass(Login.this);
        setContentView(R.layout.activity_login);
    }

    public void GoToTripOptionsActivity(View v){

        EditText username;
        EditText password;
        username = (EditText) findViewById(R.id.username);
        String user = username.getText().toString().trim().toLowerCase();
        password = (EditText) findViewById(R.id.password);
        String pass = password.getText().toString().trim().toLowerCase();

        Log.d("Username", "The username and password user entered" + user +"  "+ pass);
        if(!user.equals("") && !pass.equals("") ) {


            Intent intent=new Intent(this,TripOptions.class);
            startActivity(intent);
        } else{

            Toast.makeText(getApplicationContext(),"Enter User name  and password ",Toast.LENGTH_LONG).show();
        }

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



    }//end of login method
    public void GoToSignupActivity(View v){
        Intent ini=new Intent(this,SignUp.class);
        startActivity(ini);
    }

}

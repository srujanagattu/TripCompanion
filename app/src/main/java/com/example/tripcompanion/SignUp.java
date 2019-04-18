package com.example.tripcompanion;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.ParseInstallation;
import com.parse.SaveCallback;

public class SignUp extends AppCompatActivity {
  //  SQLHelperClass db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Parse.initialize(this);
        ParseInstallation.getCurrentInstallation().saveInBackground();
        setContentView(R.layout.signup);

    }

    public void GoBackToLogin(View v) {
        EditText uname = (EditText) findViewById(R.id.name);
        EditText email = (EditText) findViewById(R.id.email);
        EditText password = (EditText) findViewById(R.id.password);
        EditText password1 = (EditText) findViewById(R.id.confrimPassword);
        EditText age = (EditText) findViewById(R.id.age);
        EditText gender = (EditText) findViewById(R.id.gender);
        EditText phoneNumber = (EditText) findViewById(R.id.phonenumber);
        EditText favrt = (EditText) findViewById(R.id.food);

        String name = uname.getText().toString().trim().toLowerCase();
        String mail = email.getText().toString().trim().toLowerCase();
        String pwd = password.getText().toString().trim().toLowerCase();
        String pwd1 = password1.getText().toString().trim().toLowerCase();
        String age1 = age.getText().toString().trim().toLowerCase();
        int agee = Integer.parseInt(age1);
        String gender1 = gender.getText().toString().trim().toLowerCase();
        String phone = phoneNumber.getText().toString().trim().toLowerCase();
        String food1 = favrt.getText().toString().trim().toLowerCase();
        String location = "Kansas";

        if (name.isEmpty() || mail.isEmpty() || pwd.isEmpty()||pwd1.isEmpty()  )

        {

            Toast.makeText(getApplicationContext(),"Enter valid Name, Email and Password!",Toast.LENGTH_LONG).show();
        }

        else if(!pwd.equals(pwd1)){

                Toast.makeText(getApplicationContext(),"Passwords doesnot match!",Toast.LENGTH_LONG).show();
            }
        else if(!(agee>1 && agee<100)){
  Toast.makeText(getApplicationContext(),"Enter valid age!",Toast.LENGTH_LONG).show();

    }
            else {
            ParseObject trip = new ParseObject("Trip");
            trip.put("name", name);
            trip.put("email", mail);
            trip.put("password", pwd);
            trip.put("confirmPassword", pwd1);
            trip.put("age", agee);
            trip.put("gender", gender1);
            trip.put("phoneNumber", phone);
            trip.put("favouriteDish", food1);
            trip.put("state","");
            trip.put("city","");
            trip.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    System.out.println("Saved Callback");
                   gotoAnoActivity();
                }
            });

            }


//        if (mail.isEmpty() )
//        {
//            Toast.makeText(getApplicationContext(),"Enter valid email !",Toast.LENGTH_LONG).show();
//        }
//
//        else{
//            Intent intent = new Intent(this, Login.class);
//            startActivity(intent);
//        }



    }//end of button click


//    @Override
//    protected void onStart() {
//        super.onStart();
//        db.openDB();
//        Toast toast = Toast.makeText(getApplicationContext(), "DB is connected", Toast.LENGTH_SHORT);
//        toast.show();
//    }
    public void gotoAnoActivity(){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

public boolean validate() {
    EditText uname = (EditText) findViewById(R.id.name);
    EditText email = (EditText) findViewById(R.id.email);
    EditText password = (EditText) findViewById(R.id.password);
    EditText password1 = (EditText) findViewById(R.id.confrimPassword);
    EditText age = (EditText) findViewById(R.id.age);
    String age1 = age.getText().toString().trim().toLowerCase();
    int agee = Integer.parseInt(age1);
    String name = uname.getText().toString().trim().toLowerCase();
    String mail = email.getText().toString().trim().toLowerCase();
    String pwd = password.getText().toString().trim().toLowerCase();
    String pwd1 = password1.getText().toString().trim().toLowerCase();
 return false;
}


////
////    else {
////        Toast.makeText(getApplicationContext(), "Please check name,email,password", Toast.LENGTH_LONG).show();
////        return false;
////    }
////    }else if(!pwd.equals(pwd1)){
////        Toast.makeText(getApplicationContext(),"Password doesnot match!!",Toast.LENGTH_LONG).show();
////        return false;
////    }
////    else if(!(agee>1 && agee<100)){
////        Toast.makeText(getApplicationContext(),"Enter valid age!",Toast.LENGTH_LONG).show();
////        return false;
////    }
////    else{
////
////        Toast.makeText(getApplicationContext(),"User Name, Email  and Password are required!!",Toast.LENGTH_LONG).show();
////        return false;
////    }
//
//
//    }//end of class
}

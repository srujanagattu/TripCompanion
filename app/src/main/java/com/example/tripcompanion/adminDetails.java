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
import android.widget.TextView;
import android.widget.Toast;

import com.parse.DeleteCallback;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class adminDetails  extends AppCompatActivity {
    String name;
    String email;
    int age;
    String gender;
    String favrouiteFood;
    String phoneNumber;
    String objId;
    TextView gen;
    TextView emaill;
    TextView ageTv;
    TextView fTv;
    TextView phoneTv;
    TextView nameTx;
    String test1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.admindetails);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent ini=getIntent();
        objId=ini.getStringExtra("objectId");
        Intent inii=getIntent();
        test1=inii.getStringExtra("user_id");

        // name=ini.getStringExtra("NAME");

        Parse.initialize(this);
        ParseInstallation.getCurrentInstallation().saveInBackground();
        getPeopleValue();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_admin,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){

            case R.id.logout:
                Intent intent1 = new Intent(this, Login.class);

                startActivity(intent1);
                return true;


            default:
                return super.onOptionsItemSelected(item);

        }
    }


    public void getPeopleValue(){


        nameTx=findViewById(R.id.namevalTv2);
        gen=findViewById(R.id.genderTv5);
        emaill=findViewById(R.id.emailValTv);
        ageTv=findViewById(R.id.ageValTv4);
        phoneTv=findViewById(R.id.phValTv7);
        fTv=findViewById(R.id.foodValTv6);


        ParseQuery<ParseObject> query = ParseQuery.getQuery("Trip");

        Log.d("value","object  Id:"+objId);
        query.whereEqualTo("objectId",objId);
        Log.d("value","name name "+name);
        query.getInBackground(objId, new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject ob, com.parse.ParseException e) {
                if (e == null) {
                    name=ob.getString("name");
                    gender=ob.getString("gender");
                    age=ob.getInt("age");
                    String age1=Integer.toString(age);
                    email=ob.getString("email");
                    phoneNumber=ob.getString("phoneNumber");
                    favrouiteFood=ob.getString("favouriteDish");
                    // state=ob.getString("state");
                    Log.d("Gender","dsf"+gender);
                    Log.d("age","dsf"+age);
                    gen.setText(gender);
                    emaill.setText(email);
                    ageTv.setText(age1);
                    phoneTv.setText(phoneNumber);
                    fTv.setText(favrouiteFood);
                    nameTx.setText(name);





                }
            }
        });

    }


    public void removeFriend(View v) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Trip");
// Query parameters based on the item name
        query.whereEqualTo("objectId", objId);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(final List<ParseObject> object, ParseException e) {
                if (e == null) {
                    object.get(0).deleteInBackground(new DeleteCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                // Success
                                Log.d("message:","success");
                            goback();
                            } else {
                                // Failed
                                Log.d("message:","failed");
                            }
                        }
                    });
                } else {
                    // Something is wrong
                }
            }
        });

    }
    public void goback(){
        Intent intent = new Intent(this, adminact.class);



        startActivity(intent);
    }

}


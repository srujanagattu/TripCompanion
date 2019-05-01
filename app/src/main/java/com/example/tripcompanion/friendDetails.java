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

import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class friendDetails extends AppCompatActivity {
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
        setContentView(R.layout.frienddetails);
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
        inflater.inflate(R.menu.menu_tripcompanion,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.account:

                Intent intent = new Intent(this, UserDetails.class);
                Log.d("df","test id in fd:"+test1);

                intent.putExtra("objectId",test1);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Account item is selected",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.logout:
                Intent intent1 = new Intent(this, Login.class);

                startActivity(intent1);
                return true;
            case R.id.friend:
                Intent intent2 = new Intent(this, friend.class);
                intent2.putExtra("objectId",test1);
                startActivity(intent2);
                Toast.makeText(getApplicationContext(),"Friend item is selected",Toast.LENGTH_SHORT).show();

                return true;
            case R.id.TripOption:
                Intent intent3 = new Intent(this, TripOptions.class);
                intent3.putExtra("user_id",test1);
                startActivity(intent3);
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


    public void removeFriend(View v){
        Toast.makeText(getApplicationContext(),"Removed Friend: "+name,Toast.LENGTH_SHORT).show();

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Trip");
        Log.d("jnsjdjzsn","err"+objId);

        query.whereEqualTo("objectId",objId);
        query.getInBackground(objId, new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject ob, com.parse.ParseException e) {
                if (e == null) {


                    ob.put("mapObjId","xyz");


                    ob.saveInBackground();
                   // Toast.makeText(getApplicationContext(),"Added New Friend: "+name,Toast.LENGTH_SHORT).show();

                }
            }
        });



    }
}


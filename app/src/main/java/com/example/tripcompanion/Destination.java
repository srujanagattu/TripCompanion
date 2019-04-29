package com.example.tripcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

public class Destination extends AppCompatActivity {
String test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.destination);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
                Toast.makeText(getApplicationContext(),"Account item is selected",Toast.LENGTH_SHORT).show();
                return true;
             default:
                 return super.onOptionsItemSelected(item);

        }
    }
//    public void PeopleList(View v){
//        Intent intent=new Intent(this,PeopleList.class);
//ed=(EditText) findViewById(R.id.editText3);
//String str=ed.getText().toString();
//intent.putExtra("placeName",str);
//        startActivity(intent);
//    }
public void myDest(View v){
    Intent ini=getIntent();
    test=ini.getStringExtra("user_id");

    ParseQuery<ParseObject> query = ParseQuery.getQuery("Trip");
    Log.d("jnsjdjzsn","err"+test);

query.whereEqualTo("objectId",test);
    query.getInBackground(test, new GetCallback<ParseObject>() {
        @Override
        public void done(ParseObject ob, com.parse.ParseException e) {
            if (e == null) {

                EditText state;
                EditText city;
                state=(EditText) findViewById(R.id.editText);
                city=(EditText) findViewById(R.id.editText3);
                String myState=state.getText().toString();
                String mycity=city.getText().toString();
      ob.put("state",myState);
      ob.put("city",mycity);

                ob.saveInBackground();
                goToPeopleist();

            }
        }
    });
                               }

// Retrieve the object by id
//    query.getInBackground(new GetCallback<ParseObject>() {
//        public void done(ParseObject ob, ParseException e) {
//            if (e == null) {
//
//                EditText state;
//                EditText city;
//                state=(EditText) findViewById(R.id.editText);
//                city=(EditText) findViewById(R.id.editText3);
//                String myState=state.getText().toString();
//                String mycity=city.getText().toString();
//      ob.put("state",myState);
//      ob.put("city",mycity);
//
//                ob.saveInBackground();
//                goToPeopleist();
//
//            }
//        }
//    });







    public void goToPeopleist() {

        Intent intent = new Intent(this, PeopleList.class);
        intent.putExtra("user_id", test);
        startActivity(intent);
    }
}

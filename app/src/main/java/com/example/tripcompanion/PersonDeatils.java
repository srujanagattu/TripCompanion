package com.example.tripcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class PersonDeatils extends AppCompatActivity {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.persondeatils);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent ini=getIntent();
        objId=ini.getStringExtra("objectId");
        name=ini.getStringExtra("NAME");

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
                Toast.makeText(getApplicationContext(),"Account item is selected",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }


    public void getPeopleValue(){


        TextView nameTx=findViewById(R.id.namevalTv2);
         gen=findViewById(R.id.genderTv5);
         emaill=findViewById(R.id.emailValTv);
         ageTv=findViewById(R.id.ageValTv4);
         phoneTv=findViewById(R.id.phValTv7);
         fTv=findViewById(R.id.foodValTv6);

        nameTx.setText(name);
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Trip");

        Log.d("value","object  Id:"+objId);
        query.whereEqualTo("objectId",objId);
        Log.d("value","name name "+name);
        query.getInBackground(objId, new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject ob, com.parse.ParseException e) {
                if (e == null) {

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





                }
            }
        });

    }

}


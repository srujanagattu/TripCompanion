package com.example.tripcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class PeopleList extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        String[] friends1={"Srujana","Dristi"};
        String[] friends2={"Gopi","Krihsna","Dr.Hoot"};


        super.onCreate(savedInstanceState);
        setContentView(R.layout.peoplelist);
        Intent ini=getIntent();
       String name=ini.getStringExtra("placeName");
       if(name.toUpperCase().equals("MISSOURI")){
           ListAdapter ad=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,friends1);
           ListView lv=(ListView)findViewById(R.id.listView);
           lv.setAdapter(ad);
       }
        else if(name.toUpperCase().equals("KANSAS")){
           ListAdapter ad=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,friends2);
           ListView lv=(ListView)findViewById(R.id.listView);
           lv.setAdapter(ad);
        }
           else{
           TextView tv=findViewById(R.id.textView);
           tv.setText("Sorry! you do not have any friends!!");
       }

    }
}

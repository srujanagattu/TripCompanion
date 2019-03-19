package com.example.tripcompanion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class PeopleList extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.peoplelist);
        String[] friends={"Srujana","Dristi","Gopi","Krihsna","Dr.Hoot"};
        ListAdapter ad=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,friends);
        ListView lv=(ListView)findViewById(R.id.listView);
        lv.setAdapter(ad);
    }
}

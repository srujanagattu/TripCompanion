package com.example.tripcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Destination extends AppCompatActivity {
    EditText ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.destination);
    }
    public void PeopleList(View v){
        Intent intent=new Intent(this,PeopleList.class);
ed=(EditText) findViewById(R.id.editText);
String str=ed.getText().toString();
intent.putExtra("placeName",str);
        startActivity(intent);
    }
}

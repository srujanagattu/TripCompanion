package com.example.tripcompanion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.support.annotation.RequiresApi;

public class SQLHelperClass extends SQLiteOpenHelper {

    private static final String userTable = "myTrip.db";
    private static final int version = 1;


    private static final String Table1 = "userTable";
    private static final String user_name = "user_name";
    private static final String gender = "gender";
    private static final String age = "age";
    private static final String email = "email";
    private static final String password = "password";
    private static final String phone_number = "phone_number";
    private static final String location = "location";

    SQLiteDatabase myDB;

    public SQLHelperClass(Context context) {
        super(context, userTable, null, version);
        ContentValues values = new ContentValues();
        values.put(user_name,uname);
        values.put(gender,gen);
        values.put(age,age1);
        values.put(email,email1);
        values.put(password,password1);
        values.put(phone_number,phone_number1);
        values.put(location,location1);
        return myDB.insert(userTable, null, values);
    }

    public long update(String email1){

        ContentValues values = new ContentValues();

        values.put(email,email1);

        String where = email + "="+email1;
        return myDB.update(userTable, values,where,null);
    }


    public long delete(String email1){

        ContentValues values = new ContentValues();
        values.put(email,email1);
        String where = email + "="+email1;
        return myDB.delete(userTable,where,null);
    }

    public Cursor getRecords(String email1){
        String where = "where"+email + "="+email1;
        String query = "select * from "+userTable+where;
       return myDB.rawQuery(query,null);
    }

}//end of class


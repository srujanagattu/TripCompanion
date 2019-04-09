package com.example.tripcompanion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SQLHelperClass extends SQLiteOpenHelper {

    private static final String userTable = "myTrip1.db";
    private static final int version = 1;


    private static final String Table1 = "user";
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
       // myDB = new SQLiteDatabase(SQz);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String createTable1 = "CREATE TABLE "+ Table1 + "(" +
            user_name + "TEXT," +
            gender + "TEXT," +
            age + "TEXT," +
            email + "TEXT," +
            password + "TEXT," +
            phone_number + "TEXT," +
            location + "TEXT" +
            ")";

    db.execSQL(createTable1);


    }//end of on create method

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {




    }//end of onUpgrade method

    public void openDB(){
       myDB = getWritableDatabase();

    }

    public void closeDB() {
        if (myDB != null && myDB.isOpen()) {
            myDB.close();
        }
    }

    public long insert(String uname ,String gen,String age1,String email1,String password1,String phone_number1,String location1){

        ContentValues values = new ContentValues();
        values.put(user_name,uname);
        values.put(gender,gen);
        values.put(age,age1);
        values.put(email,email1);
        values.put(password,password1);
        values.put(phone_number,phone_number1);
        values.put(location,location1);
        return myDB.insert(Table1, null, values);
    }

    public long update(String email1){

        ContentValues values = new ContentValues();

        values.put(email,email1);

        String where = email + "="+email1;
        return myDB.update(Table1, values,where,null);
    }


    public long delete(String email1){

        ContentValues values = new ContentValues();
        values.put(email,email1);
        String where = email + "="+email1;
        return myDB.delete(Table1,where,null);
    }

    public Cursor getRecords(String email1){
        String where = "where"+email + "="+email1;
        String query = "select * from "+Table1+where;
       return myDB.rawQuery(query,null);
    }

}//end of class


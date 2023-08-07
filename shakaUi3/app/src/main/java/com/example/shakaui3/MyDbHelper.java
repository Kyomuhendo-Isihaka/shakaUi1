package com.example.shakaui3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDbHelper extends SQLiteOpenHelper {

    private SignUpActivity signUpActivity;

    private final Context context;
    private static  final String DATABASE_NAME = "shaka.db";
    private static final int DATABASE_VERSION = 2;


    private static final String TABLE_NAME = "shaka_store";
    private static final String COL_ID ="id";
    private static final String COL_NAME = "username";

    private static final String COL_EMAIL = "userEmail";
     private static final String COL_PASSWORD = "userPassword";




    public MyDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION );
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NAME + " TEXT," + COL_EMAIL + " TEXT," + COL_PASSWORD + " TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void signUp( String username, String userEmail, String userPassword){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COL_NAME, username);
        cv.put(COL_EMAIL, userEmail);
        cv.put(COL_PASSWORD, userPassword);
        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(context, "SignUp Success", Toast.LENGTH_SHORT).show();
        }
    }

    public Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db!=null){
            cursor=db.rawQuery(query, null);
        }
        return cursor;
    }
}

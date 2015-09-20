package com.example.sasha.myapplication_currentcourses.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sasha on 14.09.15.
 */
public class DBHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "Bank.db";
    private static final int DATABASE_VERSION = 1;

    private static DBHelper instance;

    public static synchronized DBHelper getHelper(Context context) {
        if (instance == null)
            instance = new DBHelper(context);
        return instance;
    }


    public DBHelper(Context context) {
        super(context ,DATABASE_NAME ,null , DATABASE_VERSION );


    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLParams.CREATE_TABLE_ORGANIZATIONS);
        db.execSQL(SQLParams.CREATE_TABLE_CURRENCIES);
    }
    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {

            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
}

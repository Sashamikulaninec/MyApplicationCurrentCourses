package com.example.sasha.myapplication_currentcourses.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by sasha on 14.09.15.
 */
public class DBHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "Bank.db";
    private static final int DATABASE_VERSION = 1;


    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLParams.CREATE_TABLE_ORGANIZATIONS);
        db.execSQL(SQLParams.CREATE_TABLE_CURRENCIES);
        Log.v("test", "Database created");
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
        db.execSQL(SQLParams.SQL_DROP_TABLE_ORG);
        db.execSQL(SQLParams.SQL_DROP_TABLE_CURRENCIES);
        onCreate(db);

    }
}

package com.example.sasha.myapplication_currentcourses.db;

import android.provider.BaseColumns;

/**
 * Created by sasha on 14.09.15.
 */
public class SQLParams implements BaseColumns {
    public static final String ORG_ID               = "org_id";
    public static final String TEXT_TYPE            = "TEXT";
    public static final String ORG_TABLE_NAME       = "org";
    public static final String COLUMN_TITLE         = "title";
    public static final String COLUMN_REG_ID        = "reg_id";
    public static final String COLUMN_CITY_ID       = "city_id";
    public static final String COLUMN_PHONE         = "phone";
    public static final String COLUMN_ADDRESS       = "address";
    public static final String COLUMN_LINK          = "link";
    public static final String COLUMN_ORG_ID        = "org_id";
    public static final String TABLE_CURRENCIES     = "currencies";
    public static final String CURRENCIES_ORG_ID    = "currencies_org_id";
    public static final String COLUMN_NAME          = "name";
    public static final String COLUMN_ASK           = "ask";
    public static final String COLUMN_BID           = "bid";


    public static final String CREATE_TABLE_ORGANIZATIONS =
            "CREATE TABLE IF NOT EXISTS "  + ORG_TABLE_NAME + " (" + ORG_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_TITLE        + " " + TEXT_TYPE + " ," +
                    COLUMN_PHONE        + " " + TEXT_TYPE + " ," +
                    COLUMN_REG_ID       + " " + TEXT_TYPE + " ," +
                    COLUMN_CITY_ID      + " " + TEXT_TYPE + " ," +
                    COLUMN_ADDRESS      + " " +TEXT_TYPE  + " ," +
                    COLUMN_LINK         + " " +TEXT_TYPE  + " )" ;




    public static final String CREATE_TABLE_CURRENCIES = "CREATE TABLE IF NOT EXISTS " +
            TABLE_CURRENCIES    + " (" + CURRENCIES_ORG_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_NAME         + " " +TEXT_TYPE + " ," +
            COLUMN_ASK          + " " +TEXT_TYPE + " ," +
            COLUMN_BID          + " " +TEXT_TYPE + " ," +
            COLUMN_ORG_ID       + " " +TEXT_TYPE + " ," +
            " FOREIGN KEY ("    + COLUMN_ORG_ID  + ") REFERENCES "+ ORG_TABLE_NAME + " ("+ ORG_ID +" ))" ;


    public static final String SQL_DROP_TABLE_ORG =
            "DROP TABLE IF EXISTS " + ORG_TABLE_NAME;


    public static final String SQL_DROP_TABLE_CURRENCIES =
            "DROP TABLE IF EXISTS " + TABLE_CURRENCIES;

}

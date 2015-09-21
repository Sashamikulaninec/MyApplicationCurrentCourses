package com.example.sasha.myapplication_currentcourses;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.sasha.myapplication_currentcourses.db.DBHelper;
import com.example.sasha.myapplication_currentcourses.db.SQLParams;
import com.example.sasha.myapplication_currentcourses.model.Currencies;
import com.example.sasha.myapplication_currentcourses.model.Organizations;
import com.github.kevinsawicki.http.HttpRequest;

import java.util.ArrayList;

/**
 * Created by sasha on 14.09.15.
 */
public class AsyncJSON extends AsyncTask<String, Void, ArrayList<Organizations>> {
    ArrayList<Organizations> organizationses;
    public static final String SERVER_URL = "http://resources.finance.ua/ru/public/currency-cash.json";
    public static final String TAG = "wwewe";
    public DBHelper mDBHelper;

    private Context mContext;
    Organizations organizations;
    ProgressBar progressBar;

    public AsyncJSON(Context context, ProgressBar _pbLoading) {
        mContext = context;
        progressBar = _pbLoading;
    }

    @Override
    protected void onPreExecute() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    protected ArrayList<Organizations> doInBackground(String... params) {
        mDBHelper = new DBHelper(mContext, "Bank.db", null, 1);


        JSONObject jsonObject;
        HttpRequest request = HttpRequest.get(params[0]);

        if (request.code() == 200) {
            String response = request.body();
            try {

                jsonObject = new JSONObject(response);
                organizationses = jsonParser(jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return organizationses;

    }

    @Override
    protected void onPostExecute(ArrayList<Organizations> organizationses) {
        progressBar.setVisibility(View.INVISIBLE);

    }

    public ArrayList<Organizations> jsonParser(JSONObject jsonObject) {
        ArrayList<Organizations> organizationses = new ArrayList<Organizations>();
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        db.execSQL(SQLParams.SQL_DROP_TABLE_ORG);
        db.execSQL(SQLParams.CREATE_TABLE_ORGANIZATIONS);
        db.execSQL(SQLParams.SQL_DROP_TABLE_CURRENCIES);
        db.execSQL(SQLParams.CREATE_TABLE_CURRENCIES);
        try {

            JSONArray organizations = jsonObject.getJSONArray("organizations");

            for (int i = 0; i < organizations.length(); i++) {
                ArrayList<Currencies> currencieses = new ArrayList<Currencies>();

                String cityname;
                String regionName;

                JSONObject all_cities = jsonObject.getJSONObject("cities");
                JSONObject all_regions = jsonObject.getJSONObject("regions");
                JSONObject all_currencies = jsonObject.getJSONObject("currencies");

                String c = "";
                String r = "";
                String title;
                String phone;
                String address;
                String link;

                JSONObject val = organizations.getJSONObject(i);

                title = val.getString("title");
                phone = val.getString("phone");
                cityname = getCityName(all_cities, organizations.getJSONObject(i), c, i);
                regionName = getRegionName(all_regions, organizations.getJSONObject(i), r, i);
                address = val.getString("address");
                link = val.getString("link");

                Log.v(TAG, cityname + "   title");
                Log.v(TAG, phone + "phone");
                Log.v(TAG, address + "address");
                Log.v(TAG,link + "link");

                Organizations organizations1 = new Organizations( title, phone, regionName, cityname, address, link);
                organizationses.add(organizations1);
                writeToDbOrg( title, phone, regionName, cityname, address, link);
                getCurrencies(all_currencies, organizations.getJSONObject(i),currencieses);


            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        db.close();

        return organizationses;
    }

    public String getCityName( JSONObject all_cities ,JSONObject jsonObject, String s, int i) throws JSONException {

        String cities = jsonObject.getString("cityId");
        s = all_cities.getString(cities);
        return s;

    }

    public String getRegionName( JSONObject all_regions, JSONObject jsonObject,  String s, int i) throws JSONException {
        String regions = jsonObject.getString("regionId");
        s = all_regions.getString(regions);
         return s;
    }

    public void getCurrencies(JSONObject all_currencies, JSONObject jsonObject, ArrayList<Currencies> c) throws JSONException {


        JSONObject currencies = jsonObject.getJSONObject("currencies");

        for (int j = 0; j < currencies.length(); j++){

            String valname = all_currencies.getString(currencies.names().get(j).toString());
        JSONObject orgCurrencies = currencies.getJSONObject(currencies.names().get(j).toString());
        String orgCurrenciesAsk = orgCurrencies.getString("ask");
        String orgCurrenciesBid = orgCurrencies.getString("bid");

        //c.add(new Currencies(String.valueOf(j), valname, orgCurrenciesAsk, orgCurrenciesBid));
        writeToDbCurrensies( valname , orgCurrenciesAsk,orgCurrenciesBid);

        }
    }

    public void writeToDbCurrensies( String s, String r, String e) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(SQLParams.COLUMN_NAME, s);
        cv.put(SQLParams.COLUMN_ASK, r);
        cv.put(SQLParams.COLUMN_BID, e);
        db.insert(SQLParams.TABLE_CURRENCIES, null, cv);
    }

    public void writeToDbOrg( String t, String p, String r, String c, String a, String l) {

        SQLiteDatabase db = mDBHelper.getWritableDatabase();


        ContentValues cv = new ContentValues();
        cv.put(SQLParams.COLUMN_TITLE, t);
        cv.put(SQLParams.COLUMN_PHONE, p);
        cv.put(SQLParams.COLUMN_REG_ID, r);
        cv.put(SQLParams.COLUMN_CITY_ID, c);
        cv.put(SQLParams.COLUMN_ADDRESS, a);
        cv.put(SQLParams.COLUMN_LINK, l);

        db.insert(SQLParams.ORG_TABLE_NAME, null, cv);


    }


}




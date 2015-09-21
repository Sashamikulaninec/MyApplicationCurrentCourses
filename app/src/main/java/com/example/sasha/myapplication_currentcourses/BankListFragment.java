package com.example.sasha.myapplication_currentcourses;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import java.util.ArrayList;

import com.example.sasha.myapplication_currentcourses.db.DBHelper;
import com.example.sasha.myapplication_currentcourses.db.SQLParams;
import com.example.sasha.myapplication_currentcourses.model.Currencies;
import com.example.sasha.myapplication_currentcourses.model.Organizations;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by sasha on 14.09.15.
 */
public class BankListFragment extends Fragment {
    protected RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Organizations> mData;
    private ProgressBar progressBar;
    private DBHelper mDBHelper;
    public static final String TAG = "w";
    private Organizations organizations;




    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bank_list_fragment, null);

        mData = getData();
        mLayoutManager = new GridLayoutManager(getActivity(), 1);
        mAdapter       = new MyRecyclerBankAdapter(getActivity(), mData);
        mRecyclerView  = (RecyclerView) v.findViewById(R.id.rvList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);
        return v;
    }

    public List<Organizations> getData() {

        List<Organizations> list = new ArrayList<Organizations>();
        readFromDb(list);

        return list;
    }


    public void readFromDb (List list) {
        SQLiteDatabase db = mDBHelper.getReadableDatabase();
        String MY_QUERY = "SELECT * FROM " +
                SQLParams.ORG_TABLE_NAME;

        Cursor c = db.rawQuery(MY_QUERY, null);
        int titleIndex = c.getColumnIndex(SQLParams.COLUMN_TITLE);
        int regionIdIndex = c.getColumnIndex(SQLParams.COLUMN_REG_ID);
        int cityIdIndex = c.getColumnIndex(SQLParams.COLUMN_CITY_ID);
        int phoneIndex = c.getColumnIndex(SQLParams.COLUMN_PHONE);
        int addressIndex = c.getColumnIndex(SQLParams.COLUMN_ADDRESS);
        int linkIndex = c.getColumnIndex(SQLParams.COLUMN_LINK);
        c.moveToFirst();
        while (c.moveToNext()) {
            organizations = new Organizations(c.getString(titleIndex), c.getString(regionIdIndex), c.getString(cityIdIndex), c.getString(phoneIndex), c.getString(addressIndex), c.getString(linkIndex));
            list.add(organizations);

        }
        db.close();

    }


}

package com.example.sasha.myapplication_currentcourses;

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

    public static JSONObject jsonObject;
    public static JSONObject getJsonObject() {
        return jsonObject;
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bank_list_fragment, null);
        List<Organizations> list = new ArrayList<Organizations>();
        progressBar = (ProgressBar) v.findViewById(R.id.progress);
        AsyncJSON loader = new AsyncJSON(getActivity(), progressBar);
        loader.execute(AsyncJSON.SERVER_URL);

        // TODO readFromDB(list), mData;
        mData = list;
        mLayoutManager = new GridLayoutManager(getActivity(), 1);
        mAdapter       = new MyRecyclerBankAdapter(getActivity(), mData);
        mRecyclerView  = (RecyclerView) v.findViewById(R.id.rvList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);
        return v;
    }






}

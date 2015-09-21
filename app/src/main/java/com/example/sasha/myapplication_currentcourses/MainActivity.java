package com.example.sasha.myapplication_currentcourses;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.sasha.myapplication_currentcourses.db.DBHelper;


public class MainActivity extends FragmentActivity {
    BankListFragment bankListFragment;
    private DBHelper mDBHelper;
    AsyncJSON loader;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (isNetworkConnected() == true) {
            progressBar = (ProgressBar) findViewById(R.id.progress);

            AsyncJSON loader = new AsyncJSON(this,progressBar);
            mDBHelper = new DBHelper(this, "Bank.db", null, 1);

            loader.execute(AsyncJSON.SERVER_URL);


        }else {
            Toast.makeText(this,"Please turn on wifi", Toast.LENGTH_LONG).show();
        }
            bankListFragment = new BankListFragment();

            android.support.v4.app.FragmentManager fragMan = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction ft = fragMan.beginTransaction();
            ft.add(R.id.fragment2, bankListFragment);
            ft.commit();


    }

    private boolean isNetworkConnected() {

        ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        if (ni == null) {

            return false;
        } else
            return true;


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

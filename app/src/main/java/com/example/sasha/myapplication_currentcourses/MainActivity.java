package com.example.sasha.myapplication_currentcourses;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.sasha.myapplication_currentcourses.db.DBHelper;


public class MainActivity extends FragmentActivity {
    BankListFragment bankListFragment;
    public DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bankListFragment  = new BankListFragment();


        android.support.v4.app.FragmentManager fragMan = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ft  = fragMan.beginTransaction();
        ft.add(R.id.fragment2, bankListFragment);
        ft.commit();
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

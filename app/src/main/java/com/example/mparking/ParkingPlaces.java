package com.example.mparking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingPlaces extends AppCompatActivity {
    RecyclerView mRecyclerView;
    MyAdapter1 mAdapter;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities);
        Intent intent = getIntent();
        String extra = intent.getStringExtra("ime_korisnik");
        String extra1 = intent.getStringExtra("ime_grad");
        String extra2 = intent.getStringExtra("datum");
        String extra3 = intent.getStringExtra("vreme");
        db = openOrCreateDatabase("korisnici", MODE_PRIVATE, null);
        ArrayList<String> lista = new ArrayList<>();
        if (extra1.equals("Скопје")) {
            Cursor c = db.rawQuery("SELECT parking FROM " + " parkinzi WHERE grad='Скопје'", null);
            if (c.getCount() == 0) {
                return;
            }

            while (c.moveToNext()) {
                lista.add(c.getString(0));
            }
        }
        else if (extra1.equals("Струмица")) {
            Cursor c = db.rawQuery("SELECT parking FROM " + " parkinzi WHERE grad='Струмица'", null);
            if (c.getCount() == 0) {
                return;
            }

            while (c.moveToNext()) {
                lista.add(c.getString(0));
            }
        }
        else if (extra1.equals("Куманово")) {
            Cursor c = db.rawQuery("SELECT parking FROM " + " parkinzi WHERE grad='Куманово'", null);
            if (c.getCount() == 0) {
                return;
            }

            while (c.moveToNext()) {
                lista.add(c.getString(0));
            }
        }
        else if (extra1.equals("Дојран")) {
            Cursor c = db.rawQuery("SELECT parking FROM " + " parkinzi WHERE grad='Дојран'", null);
            if (c.getCount() == 0) {
                return;
            }

            while (c.moveToNext()) {
                lista.add(c.getString(0));
            }
        }
        else if (extra1.equals("Прилеп")) {
            Cursor c = db.rawQuery("SELECT parking FROM " + " parkinzi WHERE grad='Прилеп'", null);
            if (c.getCount() == 0) {
                return;
            }

            while (c.moveToNext()) {
                lista.add(c.getString(0));
            }
        }

        String[] niza = new String[lista.size()];
        niza = lista.toArray(niza);
        List<String> values = Arrays.asList(niza);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new MyAdapter1(values, extra, extra1, extra2, extra3, R.layout.my_row1, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
}
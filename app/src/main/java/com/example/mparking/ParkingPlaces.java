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
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingPlaces extends AppCompatActivity {
    RecyclerView mRecyclerView;
    MyAdapter1 mAdapter;
    DBHelper db;
    String extra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_places);
        db = new DBHelper(this);
        Intent intent = getIntent();
        extra = intent.getStringExtra("ime_korisnik");
        String extra1 = intent.getStringExtra("ime_grad");
        String extra2 = intent.getStringExtra("datum");
        String extra3 = intent.getStringExtra("vreme");
        ArrayList<String> lista = db.getParkings(extra1);
        String[] niza = new String[lista.size()];
        niza = lista.toArray(niza);
        List<String> values = Arrays.asList(niza);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.parkingPlaces);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new MyAdapter1(values, extra, extra1, extra2, extra3, db, R.layout.my_row1, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    // отворање на активноста "Мои резервации"
    public boolean onOptionsItemSelected (MenuItem item)
    {
        int id = item.getItemId();
        if (id == R.id.moi_rezervacii)
        {
            Intent intent = new Intent(this, MoiRezervacii.class);
            intent.putExtra("korisnicko_ime", extra);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
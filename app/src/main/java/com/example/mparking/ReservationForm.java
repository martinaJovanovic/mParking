package com.example.mparking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Fragment;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;

public class ReservationForm extends AppCompatActivity {
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_form);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        Fragment frag1 =  getFragmentManager().findFragmentById(R.id.fragment1);
        Fragment frag2 =  getFragmentManager().findFragmentById(R.id.fragment2);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    // отворање нова активност "ParkingPlaces" со клик на копчето "Следно"
    public void clickNext(View view) {
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        Intent intent = getIntent();
        String ime_grad = intent.getStringExtra("ime_grad");
        String korisnicko_ime = intent.getStringExtra("ime_korisnik");
        String vreme = spinner.getSelectedItem().toString();
        DatePicker dp = (DatePicker) findViewById(R.id.datePicker);
        int day = dp.getDayOfMonth();
        int month = dp.getMonth() + 1;
        int year = dp.getYear();
        String den = String.valueOf(day);
        String mesec = String.valueOf(month);
        String godina = String.valueOf(year);
        String datum = den + "." + mesec + "." + godina;
        Intent Intent = new Intent (this, ParkingPlaces.class);
        Intent.putExtra("datum", datum);
        Intent.putExtra("vreme", vreme);
        Intent.putExtra("ime_korisnik", korisnicko_ime);
        Intent.putExtra("ime_grad", ime_grad);
        startActivity(Intent);
    }
}
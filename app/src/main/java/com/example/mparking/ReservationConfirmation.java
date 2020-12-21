package com.example.mparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

public class ReservationConfirmation extends AppCompatActivity {

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_confirmation);
        Intent intent = getIntent();
        String datum = intent.getStringExtra("datum");
        String vreme = intent.getStringExtra("vreme");
        String korisnicko_ime = intent.getStringExtra("ime_korisnik");
        String ime_parking = intent.getStringExtra("ime_parking");
        String ime_grad = intent.getStringExtra("ime_grad");
        db = openOrCreateDatabase("korisnici", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS rezervacii(korisnicko_ime VARCHAR, grad VARCHAR, parking VARCHAR, vreme VARCHAR, datum VARCHAR);");
        ContentValues cvalues = new ContentValues();
        cvalues.put("korisnicko_ime", korisnicko_ime);
        cvalues.put("grad", ime_grad);
        cvalues.put("parking", ime_parking);
        cvalues.put("vreme", vreme);
        cvalues.put("datum", datum);
        db.insert("rezervacii", null, cvalues);
    }

    public void navigacijaClick(View view) {
        Intent intent = new Intent(this, ReservationConfirmation2.class);
        startActivity(intent);
    }
}
package com.example.mparking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    EditText ime_input;
    EditText korime_input;
    EditText pass_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=openOrCreateDatabase("korisnici", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS korisnici(ime_prezime VARCHAR, korisnicko_ime VARCHAR, password VARCHAR);");
    }

    public void najavaClick(View view) {
        korime_input = (EditText) findViewById(R.id.k_ime);
        pass_input = (EditText) findViewById(R.id.lozinka);
        Cursor c = db.rawQuery("SELECT * FROM korisnici WHERE korisnicko_ime = '" + korime_input.getText().toString() + "' AND password = '" + pass_input.getText().toString() + "'" , null);
        if (c.moveToFirst()) {
            Intent intent = new Intent(this, Cities.class);
            intent.putExtra("ime_korisnik", korime_input.getText().toString());
            startActivity(intent);
            c.close();
        }
        else{
        Toast.makeText(this, "Невалидно корисничко име и/или лозинка", Toast.LENGTH_LONG).show();
        }
        korime_input.setText("");
        pass_input.setText("");
    }

    public void registracijaClick(View view)
    {
        Intent intent = new Intent(this, RegistracijaActivity.class);
        startActivity(intent);
    }
}
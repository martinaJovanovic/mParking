package com.example.mparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistracijaActivity extends AppCompatActivity
{
    SQLiteDatabase db;
    EditText ime_input;
    EditText korime_input;
    EditText pass_input;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registracija);
        // креирање на базата "корисници", креирање на табелата корисници
        db = openOrCreateDatabase("korisnici", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS korisnici(ime_prezime VARCHAR, korisnicko_ime VARCHAR, password VARCHAR);");
    }

    // внесување податоци во базата
    public void database_input(View view)
    {
        ime_input = (EditText) findViewById(R.id.ime);
        korime_input = (EditText) findViewById(R.id.korime);
        pass_input = (EditText) findViewById(R.id.password);
        if (ime_input.getText().toString().trim().length() == 0 || korime_input.getText().toString().trim().length() == 0 || pass_input.getText().toString().trim().length() == 0)
        {
            Toast.makeText(this, "Немате пополнето поле!", Toast.LENGTH_SHORT).show();
        }
        else
            {
                Cursor c = db.rawQuery("SELECT * FROM korisnici WHERE korisnicko_ime = '" + korime_input.getText().toString() + "'" , null);
                if (c.moveToFirst())
                {
                    Toast.makeText(this, "Постои корисник со таа регистарска ознака на возило!", Toast.LENGTH_LONG).show();
                    c.close();
                }
                else
                    {
                        ContentValues cvalues = new ContentValues();
                        cvalues.put("ime_prezime", ime_input.getText().toString());
                        cvalues.put("korisnicko_ime", korime_input.getText().toString());
                        cvalues.put("password", pass_input.getText().toString());
                        db.insert("korisnici", null, cvalues);
                        Toast.makeText(this, "Успешна регистрација", Toast.LENGTH_SHORT).show();
                        ime_input.setText("");
                        korime_input.setText("");
                        pass_input.setText("");
                    }
            }
    }
}
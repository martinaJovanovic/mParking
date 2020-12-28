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
    DBHelper db;
    EditText ime_input;
    EditText korime_input;
    EditText pass_input;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registracija);
        db = new DBHelper(this);
    }

    // внесување податоци во базата
    public void database_input(View view) {
        ime_input = (EditText) findViewById(R.id.ime);
        korime_input = (EditText) findViewById(R.id.korime);
        pass_input = (EditText) findViewById(R.id.password);
        if (ime_input.getText().toString().trim().length() == 0 || korime_input.getText().toString().trim().length() == 0 || pass_input.getText().toString().trim().length() == 0) {
            Toast.makeText(this, "Немате пополнето поле!", Toast.LENGTH_SHORT).show();
        }
        else {
            if (db.korisnicko_ime(korime_input.getText().toString().trim())) {
                Toast.makeText(this, "Корисничкото име е зафатено!", Toast.LENGTH_SHORT).show();
                korime_input.setText("");
            }
            else {
                db.registracija(ime_input.getText().toString().trim(), korime_input.getText().toString().trim(), pass_input.getText().toString().trim());
                Toast.makeText(this, "Успешна регистрација", Toast.LENGTH_SHORT).show();
                ime_input.setText("");
                korime_input.setText("");
                pass_input.setText("");
            }
        }
    }
}
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
    EditText korime_input;
    EditText pass_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // отворање на базата "korisnici", креирање на табела "gradovi", креирање на табела "parkinzi"
        db=openOrCreateDatabase("korisnici", MODE_PRIVATE, null);
        /*db.execSQL("CREATE TABLE IF NOT EXISTS gradovi(ime_grad VARCHAR);");
        ContentValues cvalues = new ContentValues();
        cvalues.put("ime_grad", "Скопје");
        db.insert("gradovi", null, cvalues);
        cvalues.put("ime_grad", "Струмица");
        db.insert("gradovi", null, cvalues);
        cvalues.put("ime_grad", "Куманово");
        db.insert("gradovi", null, cvalues);
        cvalues.put("ime_grad", "Кавадарци");
        db.insert("gradovi", null, cvalues);
        cvalues.put("ime_grad", "Дојран");
        db.insert("gradovi", null, cvalues);
        cvalues.put("ime_grad", "Прилеп");
        db.insert("gradovi", null, cvalues);
        ContentValues cvalues1 = new ContentValues();
        db.execSQL("CREATE TABLE IF NOT EXISTS parkinzi(parking VARCHAR, grad VARCHAR, kapacitet INT, latitude DOUBLE, longitude DOUBLE);");
        cvalues1.put("parking", "A0");
        cvalues1.put("grad", "Скопје");
        cvalues1.put("kapacitet", 154);
        cvalues1.put("latitude", 41.99906657759975);
        cvalues1.put("longitude", 21.416943171164643);
        db.insert("parkinzi", null, cvalues1);
        cvalues1.put("parking", "A02");
        cvalues1.put("grad", "Скопје");
        cvalues1.put("kapacitet", 155);
        cvalues1.put("latitude", 41.97651255217158);
        cvalues1.put("longitude", 21.375237399873264);
        db.insert("parkinzi", null, cvalues1);
        cvalues1.put("parking", "A3");
        cvalues1.put("grad", "Скопје");
        cvalues1.put("kapacitet", 53);
        cvalues1.put("latitude", 41.99338792293856);
        cvalues1.put("longitude", 21.429668007349175);
        db.insert("parkinzi", null, cvalues1);
        cvalues1.put("parking", "A4");
        cvalues1.put("grad", "Скопје");
        cvalues1.put("kapacitet", 86);
        cvalues1.put("latitude", 41.993017631674654);
        cvalues1.put("longitude", 21.43145550642184);
        db.insert("parkinzi", null, cvalues1);
        cvalues1.put("parking", "A5");
        cvalues1.put("grad", "Скопје");
        cvalues1.put("kapacitet", 39);
        cvalues1.put("latitude", 41.99825560516544);
        cvalues1.put("longitude", 21.429342770131544);
        db.insert("parkinzi", null, cvalues1);
        cvalues1.put("parking", "B2");
        cvalues1.put("grad", "Скопје");
        cvalues1.put("kapacitet", 57);
        cvalues1.put("latitude", 41.99105980357253);
        cvalues1.put("longitude", 21.430453061325057);
        db.insert("parkinzi", null, cvalues1);
        cvalues1.put("parking", "B3");
        cvalues1.put("grad", "Скопје");
        cvalues1.put("kapacitet", 49);
        cvalues1.put("latitude", 41.992662597401576);
        cvalues1.put("longitude", 21.42692327425445);
        db.insert("parkinzi", null, cvalues1);
        cvalues1.put("parking", "B6");
        cvalues1.put("grad", "Скопје");
        cvalues1.put("kapacitet", 12);
        cvalues1.put("latitude", 41.99465944725803);
        cvalues1.put("longitude", 21.428399106765077);
        db.insert("parkinzi", null, cvalues1);
        cvalues1.put("parking", "B7");
        cvalues1.put("grad", "Скопје");
        cvalues1.put("kapacitet", 167);
        cvalues1.put("latitude", 42.000589132339776);
        cvalues1.put("longitude", 21.438135646024303);
        db.insert("parkinzi", null, cvalues1);
        cvalues1.put("parking", "B7");
        cvalues1.put("grad", "Скопје");
        cvalues1.put("kapacitet", 167);
        cvalues1.put("latitude", 42.000589132339776);
        cvalues1.put("longitude", 21.438135646024303);
        db.insert("parkinzi", null, cvalues1);
        cvalues1.put("parking", "B7");
        cvalues1.put("grad", "Скопје");
        cvalues1.put("kapacitet", 167);
        cvalues1.put("latitude", 42.000589132339776);
        cvalues1.put("longitude", 21.438135646024303);
        db.insert("parkinzi", null, cvalues1);
        cvalues1.put("parking", "KA1");
        cvalues1.put("grad", "Куманово");
        cvalues1.put("kapacitet", 100);
        cvalues1.put("latitude", 42.13715036995001);
        cvalues1.put("longitude", 21.72612443073024);
        db.insert("parkinzi", null, cvalues1);
        cvalues1.put("parking", "KA2");
        cvalues1.put("grad", "Куманово");
        cvalues1.put("kapacitet", 100);
        cvalues1.put("latitude", 42.136800073712244);
        cvalues1.put("longitude", 21.71902851630688);
        db.insert("parkinzi", null, cvalues1);
        cvalues1.put("parking", "S12");
        cvalues1.put("grad", "Струмица");
        cvalues1.put("kapacitet", 100);
        cvalues1.put("latitude", 41.438387103916995);
        cvalues1.put("longitude", 22.64000866364183);
        db.insert("parkinzi", null, cvalues1);
        cvalues1.put("parking", "Глобал");
        cvalues1.put("grad", "Струмица");
        cvalues1.put("kapacitet", 100);
        cvalues1.put("latitude", 41.43991203080464);
        cvalues1.put("longitude", 22.639934749708644);
        db.insert("parkinzi", null, cvalues1);*/
    }

    // проверка на корисничко име и лозинка и најава со клик на копчето "Најава"
    public void najavaClick(View view) {
        korime_input = (EditText) findViewById(R.id.k_ime);
        pass_input = (EditText) findViewById(R.id.lozinka);
        // проверка на внесените податоци во база
        Cursor c = db.rawQuery("SELECT * FROM korisnici WHERE korisnicko_ime = '" + korime_input.getText().toString() + "' AND password = '" + pass_input.getText().toString() + "'" , null);
        if (c.moveToFirst()) {
            Intent intent = new Intent(this, Cities.class);
            intent.putExtra("ime_korisnik", korime_input.getText().toString());
            startActivity(intent);
            c.close();
        }
        else {
        Toast.makeText(this, "Невалидно корисничко име и/или лозинка", Toast.LENGTH_LONG).show();
        }
        korime_input.setText("");
        pass_input.setText("");
    }

    // отворање активност "Регистрација"
    public void registracijaClick(View view)
    {
        Intent intent = new Intent(this, RegistracijaActivity.class);
        startActivity(intent);
    }
}
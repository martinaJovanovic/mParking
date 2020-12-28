package com.example.mparking;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "baza", null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Korisnici(ime_prezime VARCHAR, korisnicko_ime VARCHAR, password VARCHAR);");
        db.execSQL("CREATE TABLE Parkinzi(parking VARCHAR, grad VARCHAR, kapacitet INTEGER, latitude DOUBLE, longitude DOUBLE);");
        db.execSQL("CREATE TABLE Rezervacii(ID INTEGER PRIMARY KEY AUTOINCREMENT, korisnicko_ime VARCHAR, grad VARCHAR, parking VARCHAR, vreme VARCHAR, datum VARCHAR);");
        db.execSQL("CREATE TABLE Gradovi (ime_grad VARCHAR)");
        db.execSQL("INSERT INTO Parkinzi VALUES ('A0', 'Скопје', 154, 41.97554712876998, 21.40819542186069);");
        db.execSQL("INSERT INTO Parkinzi VALUES ('A02', 'Скопје', 155, 41.97651255217158, 21.375237399873264);");
        db.execSQL("INSERT INTO Parkinzi VALUES ('A06', 'Скопје', 89, 41.99625581073006, 21.429668007349175);");
        db.execSQL("INSERT INTO Parkinzi VALUES ('A3', 'Скопје', 53, 41.99338792293856, 21.42854538089693);");
        db.execSQL("INSERT INTO Parkinzi VALUES ('A4', 'Скопје', 86, 41.993017631674654, 21.43145550642184);");
        db.execSQL("INSERT INTO Parkinzi VALUES ('A5', 'Скопје', 39, 41.99825560516544, 21.429342770131544);");
        db.execSQL("INSERT INTO Parkinzi VALUES ('A8', 'Скопје', 95, 41.99742960784059, 21.433438693119985);");
        db.execSQL("INSERT INTO Parkinzi VALUES ('B2', 'Скопје', 57, 41.99105980357253, 21.430453061325057);");
        db.execSQL("INSERT INTO Parkinzi VALUES ('B3', 'Скопје', 49, 41.992662597401576, 21.42692327425445);");
        db.execSQL("INSERT INTO Parkinzi VALUES ('B6', 'Скопје', 12, 41.99465944725803, 21.428399106765077);");
        db.execSQL("INSERT INTO Parkinzi VALUES ('C8', 'Скопје', 7, 41.995817502688965, 21.42326432505273);");
        db.execSQL("INSERT INTO Parkinzi VALUES ('C9', 'Скопје', 38, 41.99662939254931, 21.42374902943055);");
        db.execSQL("INSERT INTO Parkinzi VALUES ('C11', 'Скопје', 151, 42.00282573518484, 21.41844737716993);");
        db.execSQL("INSERT INTO Parkinzi VALUES ('C15', 'Скопје', 73, 41.99945333581689, 21.42251660012541);");
        db.execSQL("INSERT INTO Parkinzi VALUES ('C17', 'Скопје', 34, 42.000987195336734, 21.42493876852605);");
        db.execSQL("INSERT INTO Parkinzi VALUES ('C19', 'Скопје', 26, 41.99906657759975, 21.416943171164643);");
        db.execSQL("INSERT INTO Parkinzi VALUES ('C33', 'Скопје', 136, 41.990543121961544, 21.446642384481603);");
        db.execSQL("INSERT INTO Parkinzi VALUES ('C45', 'Скопје', 217, 41.996705280763365, 21.4441694044046);");
        db.execSQL("INSERT INTO Parkinzi VALUES ('C46', 'Скопје', 157, 41.996705280763365, 21.4441694044046);");
        db.execSQL("INSERT INTO Parkinzi VALUES ('C80', 'Скопје', 104, 42.005625885324534, 21.41790579920905);");
        db.execSQL("INSERT INTO Parkinzi VALUES ('C81', 'Скопје', 93, 42.004647989832876, 21.420112318566673);");
        db.execSQL("INSERT INTO Parkinzi VALUES ('D3', 'Скопје', 1652, 41.985249265246026, 21.46720737859555);");
        db.execSQL("INSERT INTO Parkinzi VALUES ('D4', 'Скопје', 839, 41.98528116494668, 21.468253440084734);");
        db.execSQL("INSERT INTO Parkinzi VALUES ('D6', 'Скопје', 113, 41.988677089193715, 21.453002083064387);");
        db.execSQL("INSERT INTO Parkinzi VALUES ('D8', 'Скопје', 63, 41.988387429119335, 21.45237738607879);");
        db.execSQL("INSERT INTO Parkinzi VALUES ('D40', 'Скопје', 55, 42.005395092362136, 21.402492529957936);");
        db.execSQL("INSERT INTO Parkinzi VALUES ('D62', 'Скопје', 33, 42.006918462986455, 21.413927926196887);");
        db.execSQL("INSERT INTO Parkinzi VALUES ('KA1', 'Куманово', 100, 42.13715036995001, 21.72612443073024);");
        db.execSQL("INSERT INTO Parkinzi VALUES ('KA2', 'Куманово', 100, 42.136800073712244, 21.71902851630688);");
        db.execSQL("INSERT INTO Parkinzi VALUES ('S12', 'Струмица', 10, 41.438387103916995, 22.64000866364183);");
        db.execSQL("INSERT INTO Parkinzi VALUES ('Глобал', 'Струмица', 100, 41.43991203080464, 22.639934749708644);");
        db.execSQL("INSERT INTO Parkinzi VALUES ('Автобуска станица', 'Прилеп', 100, 41.34501112405046, 21.5404972178284);");
        db.execSQL("INSERT INTO Parkinzi VALUES ('Гоце Делчев', 'Прилеп', 30, 41.34620319762221, 21.55193415668611);");
        db.execSQL("INSERT INTO Parkinzi VALUES ('Општа болница', 'Кавадарци', 30, 41.444801552121106, 22.017349183618386);");
        db.execSQL("INSERT INTO Parkinzi VALUES ('STAGE BEACH', 'Дојран', 30, 41.19437791484008, 22.71564893371064);");
        db.execSQL("INSERT INTO Parkinzi VALUES ('Хотел Гранит', 'Дојран', 30, 41.19264618421807, 22.71538607724435);");
        db.execSQL("INSERT INTO Gradovi VALUES ('Скопје')");
        db.execSQL("INSERT INTO Gradovi VALUES ('Струмица')");
        db.execSQL("INSERT INTO Gradovi VALUES ('Куманово')");
        db.execSQL("INSERT INTO Gradovi VALUES ('Кавадарци')");
        db.execSQL("INSERT INTO Gradovi VALUES ('Прилеп')");
        db.execSQL("INSERT INTO Gradovi VALUES ('Дојран')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Korisnici");
        db.execSQL("DROP TABLE IF EXISTS Parkinzi");
        db.execSQL("DROP TABLE IF EXISTS Rezervacii");
        db.execSQL("DROP TABLE IF EXISTS Gradovi");
        onCreate(db);
    }

    public boolean korisnicko_ime (String korisnicko_ime)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Korisnici WHERE korisnicko_ime LIKE '" + korisnicko_ime + "'", null);
        if (c.moveToFirst()) {
            return true;
        }
        return false;
    }

    public void registracija (String ime_prezime, String korisnicko_ime, String password)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor c = database.rawQuery("SELECT * FROM Korisnici WHERE korisnicko_ime = '" + korisnicko_ime + "'" , null);
        ContentValues cvalues = new ContentValues();
        cvalues.put("ime_prezime", ime_prezime);
        cvalues.put("korisnicko_ime", korisnicko_ime);
        cvalues.put("password", password);
        database.insert("Korisnici", null, cvalues);
    }

    public boolean proverka (String korime, String pass) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Korisnici WHERE korisnicko_ime = '" + korime + "' AND password = '" + pass + "'" , null);
        if (c.moveToFirst()) {
            c.close();
            return true;
        }
        else {
            return false;
        }
    }

    public ArrayList<String> getCities ()
    {
        SQLiteDatabase database = this.getReadableDatabase();
        ArrayList<String> lista = new ArrayList<>();
        Cursor c = database.rawQuery("SELECT ime_grad FROM " +" Gradovi",null);
        while (c.moveToNext())
        {
            lista.add(c.getString(0));
        }
        c.close();
        return lista;
    }

    public ArrayList<String> getParkings (String city) {
        ArrayList<String> lista = new ArrayList();
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor c = database.rawQuery("SELECT parking FROM Parkinzi WHERE grad LIKE '" + city + "'", null);
        while(c.moveToNext()) {
            lista.add(c.getString(0));
        }
        c.close();
        return lista;
    }

    public int kapacitet (String parking) {
        int kapacitet = 0;
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor c = database.rawQuery("SELECT * FROM Parkinzi WHERE parking LIKE '" + parking + "'", null);
        if(c.moveToFirst()) {
            kapacitet = c.getInt(2);
            c.close();
            return kapacitet;
        }
        else {
            return 0;
        }
    }

    public void rezervacija (String username, String city, String parkingname, String timeslot, String date) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("korisnicko_ime", username);
        contentValues.put("grad", city);
        contentValues.put("parking", parkingname);
        contentValues.put("vreme", timeslot);
        contentValues.put("datum", date);
        database.insert("Rezervacii", null, contentValues);
    }

    public boolean rezervacijaProverka (String korisnicko_ime, String parking, String vreme, String datum) {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor c = database.rawQuery("SELECT * FROM Rezervacii WHERE korisnicko_ime = '" + korisnicko_ime + "' AND parking = '" + parking + "' AND vreme = '" + vreme + "'AND datum = '" + datum + "'" , null);
        if(c.moveToFirst()) {
            return true;
        }
        else {
            return false;
        }
    }

    public int brojRezervacii(String datum, String vreme, String parking) {
        int vkupno = 0;
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor c = database.rawQuery("SELECT * FROM Rezervacii WHERE datum = '" + datum + "' AND vreme = '" + vreme + "' AND parking = '" + parking + "'" , null);
        if(c.moveToFirst()) {
            vkupno = c.getCount();
            c.close();
            return vkupno;
        } else {
            return 0;
        }
    }

    public int brRezervaciipoKorisnik (String korisnicko_ime)
    {
        int vkupno = 0;
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor c = database.rawQuery("SELECT * FROM Rezervacii WHERE korisnicko_ime = '" + korisnicko_ime + "'" , null);
        if(c.moveToFirst()) {
            vkupno = c.getCount();
            c.close();
            return vkupno;
        } else {
            return 0;
        }
    }

    public double getLatitude(String parkingname) {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor c = database.rawQuery("SELECT * FROM Parkinzi WHERE parking LIKE '" + parkingname + "'", null);
        if(c.moveToFirst()) {
            return c.getDouble(3);
        }
        else {
            return 0;
        }
    }

    public double getLongitude(String parkingname) {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor c = database.rawQuery("SELECT * FROM Parkinzi WHERE parking LIKE '" + parkingname + "'", null);
        if(c.moveToFirst()) {
            return c.getDouble(4);
        }
        else {
            return 0;
        }
    }

    public int rezervacijaID (String korisnicko_ime, String grad, String parking, String datum, String vreme)
    {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor c = database.rawQuery("SELECT * FROM Rezervacii WHERE korisnicko_ime = '" + korisnicko_ime + "' AND grad = '" + grad + "' AND parking = '" + parking + "' AND datum = '" + datum + "' AND vreme = '" + vreme + "'" , null);
        if(c.moveToFirst()) {
            return c.getInt(0);
        }
        else {
            return 0;
        }
    }

    public ArrayList<String> getRezervacija (String korisnicko_ime)
    {
        SQLiteDatabase database = this.getReadableDatabase();
        ArrayList<String> lista = new ArrayList<>();
        Cursor c = database.rawQuery("SELECT * FROM Rezervacii WHERE korisnicko_ime = '" + korisnicko_ime +"'" , null);
        while (c.moveToNext())
        {
            lista.add(c.getString(3) +", " + c.getString(2) + "\n" + c.getString(5) +"\n" + c.getString(4) + "ч.");
        }
        return lista;
    }

}

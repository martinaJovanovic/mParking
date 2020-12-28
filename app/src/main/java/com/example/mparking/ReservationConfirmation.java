package com.example.mparking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Fragment;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.Locale;

public class ReservationConfirmation extends AppCompatActivity {

    DBHelper db;
    public double latitude, longitude;
    String ime_parking;
    String korisnicko_ime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_confirmation);
        db = new DBHelper(this);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        Fragment fragment1 = getFragmentManager().findFragmentById(R.id.successFragment);
        Fragment fragment2 = getFragmentManager().findFragmentById(R.id.map);
        Intent intent = getIntent();
        ime_parking = intent.getStringExtra("ime_parking");
        latitude = intent.getDoubleExtra("latitude",0);
        longitude = intent.getDoubleExtra("longitude",0);
        korisnicko_ime = intent.getStringExtra("korisnicko_ime");
    }

    // отворање навигација во Google Maps со клик на копчето "Навигација" во портрет
    public void navigacijaClick(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?daddr=%f,%f (%s)", latitude, longitude, "");
        intent.setData(Uri.parse(uri));
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    // отворање на активноста "Мои резервации"
    @Override
    public boolean onOptionsItemSelected (MenuItem item)
    {
        int id = item.getItemId();
        if (id == R.id.moi_rezervacii)
        {
            Intent intent1 = new Intent(this, MoiRezervacii.class);
            intent1.putExtra("korisnicko_ime", korisnicko_ime);
            startActivity(intent1);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
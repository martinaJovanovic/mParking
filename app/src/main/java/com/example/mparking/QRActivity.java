package com.example.mparking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.Locale;

public class QRActivity extends AppCompatActivity {
    DBHelper db;
    double latitude, longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_r);
        db = new DBHelper(this);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        Intent intent = getIntent();
        String extra = intent.getStringExtra("extra");
        String korisnicko_ime = intent.getStringExtra("korisnicko_ime");
        String[] splitS = extra.split(", ");
        String parking = splitS[0];
        String s = splitS[1];
        String [] splitS1 = s.split("\n");
        String grad = splitS1[0];
        String datum = splitS1[1];
        String vreme1 = splitS1[2];
        String vreme = vreme1.substring(0,7);
        ImageView iv = (ImageView) findViewById(R.id.qrcode);
        int rezervacijaID = db.rezervacijaID(korisnicko_ime, grad, parking, datum, vreme);
        latitude = db.getLatitude(parking);
        longitude = db.getLongitude(parking);
        String rezervacija = Integer.toString(rezervacijaID);
        // генерирање уникатен QR код за ID на резервација
        MultiFormatWriter writer = new MultiFormatWriter();
        try {
            BitMatrix matrix = writer.encode(rezervacija, BarcodeFormat.QR_CODE, 450, 450);
            BarcodeEncoder encoder = new BarcodeEncoder();
            Bitmap bitmap = encoder.createBitmap(matrix);
            iv.setImageBitmap(bitmap);
        }
        catch (WriterException e) {
            e.printStackTrace();
        }
    }

    // отворање навигација во Google Maps со клик на копчето "Навигација"
    public void navigacija(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?daddr=%f,%f (%s)", latitude, longitude, "");
        intent.setData(Uri.parse(uri));
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }
}
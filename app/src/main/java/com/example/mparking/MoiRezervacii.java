package com.example.mparking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoiRezervacii extends AppCompatActivity {
    DBHelper db;
    RecyclerView mRecyclerView;
    MyAdapter2 mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moi_rezervacii);
        db = new DBHelper(this);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        Intent intent = getIntent();
        String korisnicko_ime = intent.getStringExtra("korisnicko_ime");
        ArrayList<String> lista = db.getRezervacija(korisnicko_ime);
        String[] niza = new String[lista.size()];
        niza = lista.toArray(niza);
        List<String> values = Arrays.asList(niza);
        mRecyclerView = (RecyclerView) findViewById(R.id.rezervacii);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new MyAdapter2(values, korisnicko_ime, R.layout.my_row2, this);
        mRecyclerView.setAdapter(mAdapter);
    }
}
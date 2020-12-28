package com.example.mparking;


import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

import javax.crypto.spec.DHGenParameterSpec;

public class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.ViewHolder>
{
    private List<String> myList;
    private int rowLayout;
    private Context mContext;
    private String korisnicko_ime;
    public String vreme;
    public String datum;
    public String grad;
    public DBHelper db;
    public int slob, zaf;
    public String slobodni, zafateni;
    public int brRezervacii;
    public int brRezervaciipoKorisnik;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView parking;
        public TextView slobodni;
        public TextView zafateni;
        public Button button;
        public ViewHolder(View itemView) {
            super(itemView);
            parking = (TextView) itemView.findViewById(R.id.parking);
            button = (Button) itemView.findViewById(R.id.buttonReservation1);
            slobodni = (TextView) itemView.findViewById(R.id.slobodni);
            zafateni = (TextView) itemView.findViewById(R.id.zafateni);
        }
    }

    public MyAdapter1(List<String> myList, String korisnicko_ime, String grad, String datum, String vreme, DBHelper db, int rowLayout, Context context) {
        this.myList = myList;
        this.korisnicko_ime = korisnicko_ime;
        this.grad = grad;
        this.datum = datum;
        this.vreme = vreme;
        this.rowLayout = rowLayout;
        this.mContext = context;
        this.db = db;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        final String entry = myList.get(i);
        int kapacitet = db.kapacitet(entry);
        brRezervacii = db.brojRezervacii(datum, vreme, entry);
        slob = kapacitet - brRezervacii;
        zaf = kapacitet - slob;
        slobodni = Integer.toString(slob);
        zafateni = Integer.toString(zaf);
        viewHolder.parking.setText(entry);
        viewHolder.slobodni.setText(slobodni);
        viewHolder.zafateni.setText(zafateni);
        final double latitude = db.getLatitude(entry);
        final double longitude = db.getLongitude(entry);
        brRezervaciipoKorisnik = db.brRezervaciipoKorisnik(korisnicko_ime);
        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (db.rezervacijaProverka(korisnicko_ime, entry, vreme, datum)) {
                   Toast.makeText(mContext, "Веќе имате резервирација во избраниот термин!", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (brRezervaciipoKorisnik<3){
                    db.rezervacija(korisnicko_ime, grad, entry, vreme, datum);
                    brRezervacii++;
                    Intent intent = new Intent(view.getContext(), ReservationConfirmation.class);
                    intent.putExtra("ime_parking", entry);
                    intent.putExtra("korisnicko_ime", korisnicko_ime);
                    intent.putExtra("ime_grad", grad);
                    intent.putExtra("vreme", vreme);
                    intent.putExtra("datum", datum);
                    intent.putExtra("latitude", latitude);
                    intent.putExtra("longitude", longitude);
                    view.getContext().startActivity(intent);
                    }
                    else{
                        Toast.makeText(mContext, "Максималниот дозволен број на резервации е 3!", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return myList == null ? 0 : myList.size();
    }
}

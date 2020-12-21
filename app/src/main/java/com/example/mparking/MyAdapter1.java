package com.example.mparking;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.ViewHolder>
{
    private List<String> myList;
    private int rowLayout;
    private Context mContext;
    public Button button;
    private String korisnicko_ime;
    public String vreme;
    public String datum;
    public String grad;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView myName;
        public ViewHolder(View itemView) {
            super(itemView);
            myName = (TextView) itemView.findViewById(R.id.parking);
            button = (Button) itemView.findViewById(R.id.buttonReservation1);
        }
    }

    public MyAdapter1(List<String> myList, String korisnicko_ime, String grad, String datum, String vreme, int rowLayout, Context context) {
        this.myList = myList;
        this.korisnicko_ime = korisnicko_ime;
        this.grad = grad;
        this.datum = datum;
        this.vreme = vreme;
        this.rowLayout = rowLayout;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        final String entry = myList.get(i);
        viewHolder.myName.setText(entry);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ReservationConfirmation.class);
                intent.putExtra("ime_parking", entry);
                intent.putExtra("ime_korisnik", korisnicko_ime);
                intent.putExtra("ime_grad", grad);
                intent.putExtra("datum", datum);
                intent.putExtra("vreme", vreme);
                view.getContext().startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return myList == null ? 0 : myList.size();
    }
}

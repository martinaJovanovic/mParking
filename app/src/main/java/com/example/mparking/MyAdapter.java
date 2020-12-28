package com.example.mparking;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>
{
    private ArrayList<String> myList;
    private int rowLayout;
    private Context mContext;
    public Button button;
    private String korisnicko_ime;
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView city;
        public ViewHolder(View itemView) {
            super(itemView);
            city = (TextView) itemView.findViewById(R.id.city);
            button = (Button) itemView.findViewById(R.id.buttonReservation);
        }
    }
    // конструктор
    public MyAdapter(ArrayList<String> myList, String korisnicko_ime, int rowLayout, Context context) {
        this.korisnicko_ime = korisnicko_ime;
        this.myList = myList;
        this.rowLayout = rowLayout;
        this.mContext = context;
    }
    // креирање нови views (повикано од layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);
        return new ViewHolder(v);
    }

    // замена на содржината во view (повикано од layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        final String entry = myList.get(i);
        viewHolder.city.setText(entry);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ReservationForm.class);
                intent.putExtra("ime_grad", entry);
                intent.putExtra("ime_korisnik", korisnicko_ime);
                view.getContext().startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return myList == null ? 0 : myList.size();
    }
}

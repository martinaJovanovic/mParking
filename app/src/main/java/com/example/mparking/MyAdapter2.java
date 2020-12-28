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

import java.util.ArrayList;
import java.util.List;

import javax.crypto.spec.DHGenParameterSpec;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.ViewHolder>
{
    private List<String> myList;
    private int rowLayout;
    private Context mContext;
    public Button buttondetali;
    public String korisnicko_ime;


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView rezervacija;
        public ViewHolder(View itemView) {
            super(itemView);
            rezervacija = (TextView) itemView.findViewById(R.id.rezervacija);
            buttondetali = (Button) itemView.findViewById(R.id.buttondetali);
        }
    }

    public MyAdapter2(List<String> myList, String korisnicko_ime, int rowLayout, Context context) {
        this.myList = myList;
        this.korisnicko_ime = korisnicko_ime;
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
        viewHolder.rezervacija.setText(entry);
        buttondetali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), QRActivity.class);
                intent.putExtra("korisnicko_ime", korisnicko_ime);
                intent.putExtra("extra", entry);
                view.getContext().startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return myList == null ? 0 : myList.size();
    }
}
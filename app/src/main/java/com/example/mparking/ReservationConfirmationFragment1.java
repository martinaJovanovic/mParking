package com.example.mparking;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

public class ReservationConfirmationFragment1 extends Fragment {

    private static final int REQUEST_CODE_MAP_ACTIVITY = 1234;

    public ReservationConfirmationFragment1() {
        // Required empty public constructor
    }


    public static ReservationConfirmationFragment1 newInstance(String param1, String param2) {
        ReservationConfirmationFragment1 fragment = new ReservationConfirmationFragment1();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_LANDSCAPE) {
            Fragment frag = getChildFragmentManager().findFragmentById(R.id.map);
        }
        else {
            // стартување мапа како сопствена активност
            Intent intent = new Intent(getActivity(), ReservationConfirmation2.class);
            startActivityForResult(intent, REQUEST_CODE_MAP_ACTIVITY);
        }
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
     }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reservation_confirmation1, container, false);
    }
}
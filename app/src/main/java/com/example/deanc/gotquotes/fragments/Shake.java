package com.example.deanc.gotquotes.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.deanc.gotquotes.R;

/**
 * Created by DeanC on 6/3/2016.
 */
public class Shake extends android.support.v4.app.Fragment{

    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        view = inflater.inflate(R.layout.shake, null);

        Toast.makeText(getContext(), "Give us a shake!", Toast.LENGTH_LONG);

        return view;
    }
}

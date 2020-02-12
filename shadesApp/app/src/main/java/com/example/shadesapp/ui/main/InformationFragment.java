package com.example.shadesapp.ui.main;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shadesapp.R;


public class InformationFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(
               R.layout.fragment_information,container,false);
       return view;
    }

public void setText(String shadeInfo){
    TextView view = getView().findViewById(R.id.textView);
    view.setText(shadeInfo);
}
}

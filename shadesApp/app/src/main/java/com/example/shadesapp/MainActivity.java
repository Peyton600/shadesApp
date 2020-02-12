package com.example.shadesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.shadesapp.ui.main.InformationActivity;
import com.example.shadesapp.ui.main.InformationFragment;
import com.example.shadesapp.ui.main.ListFragment;

public class MainActivity extends AppCompatActivity implements ListFragment.OnItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.main_activity);
        }

    public void onShadeItemSelected(String link){
        InformationFragment informationFragment = (InformationFragment)getSupportFragmentManager().findFragmentById(R.id.fragment2);
        if (informationFragment != null && informationFragment.isInLayout()){
            informationFragment.setText(link);
        }
        else{
            Intent intent = new Intent(this, InformationActivity.class);
            intent.putExtra("Information",link);
            startActivity(intent);
        }
    }
}

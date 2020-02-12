package com.example.paintcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private InteriorRoom mRoom;
private EditText lengthET;
private EditText widthET;
private EditText heightET;
private EditText nDoorsET;
private EditText nWindowsET;
private TextView nGallonsV;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        referenceUIcomponents();
        mRoom = new InteriorRoom();
    }

    private void referenceUIcomponents(){
        lengthET = (EditText)findViewById(R.id.length1);
        widthET = (EditText)findViewById(R.id.width1);
        heightET = (EditText)findViewById(R.id.height1);
        nDoorsET = (EditText)findViewById(R.id.doors1);
        nWindowsET=(EditText)findViewById(R.id.windows1);
        nGallonsV= (TextView) findViewById(R.id.textView9);
    }

    public void computeGallons(View view){
        double l = Double.valueOf(lengthET.getText().toString());
        double w = Double.valueOf(widthET.getText().toString());
        double h = Double.valueOf(heightET.getText().toString());
        mRoom.setLength(l);
        mRoom.setWidth(w);
        mRoom.setHeight(h);
        int doors = Integer.valueOf(nDoorsET.getText().toString());
        int windows = Integer.valueOf(nWindowsET.getText().toString());
        mRoom.setDoors(doors);
        mRoom.setWindows(windows);
        nGallonsV.setText("Interior surface area: "+ mRoom.surfaceArea()+" feet" + "\nGallons needed: " + mRoom.gallons());

    }

    public void gotoHelp(View view){
        Intent helpIntent = new Intent(MainActivity.this,HelpActivity.class);
        startActivity(helpIntent);
    }


}

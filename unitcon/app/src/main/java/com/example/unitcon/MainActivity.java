package com.example.unitcon;

import android.app.ActionBar;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView inputLabel;
    private TextView outputLabel;
    private TextView outputMeasurement;
    private EditText inputMeasurement;
    Conversion conversion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        conversion = new Conversion();
        setUpReferenceDisplay();


    }
    private void setUpReferenceDisplay(){
        inputLabel = (TextView)findViewById(R.id.inputLabel);
        inputLabel.setText(conversion.inputLable);
        outputLabel = (TextView)findViewById(R.id.outputLabel);
        outputLabel.setText(conversion.outputLable);
        outputMeasurement = (TextView) findViewById(R.id.outputMeasurement);
        outputMeasurement.setText(conversion.outputValue.toString());
        inputMeasurement=(EditText)findViewById(R.id.inputMeasurement);
        inputMeasurement.setText(conversion.inputValue.toString());
        inputMeasurement.addTextChangedListener(inputTextWatcher);

    }
    private TextWatcher inputTextWatcher = new TextWatcher() {


        @Override
        public void onTextChanged(CharSequence s, int i, int i1, int i2) {
            try {
                conversion.inputValue = Double.parseDouble(s.toString());
            }
            catch (NumberFormatException e){
                conversion.inputValue = 0.0;
            }
            conversion.compute();
            String value = String.format("%.2f",conversion.outputValue);
            outputMeasurement.setText(conversion.outputValue.toString());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }
    };

    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction()== MotionEvent.ACTION_DOWN){
            toggleActionBar();
        }
        return true;
    }

    private void toggleActionBar(){
        ActionBar actionBar = getActionBar();
        if(actionBar != null){
            if(actionBar.isShowing()) {


                actionBar.hide();
            }
        else{
            actionBar.show();
        }
    }
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
         return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
                             // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
         // as you specify a parent activity in AndroidManifest.xml.
         int id = item.getItemId();


        if(id == R.id.menuitem_feet_meters){
            conversion.switch_toFeetMeters();
            resetDisplay();
            return true;
        }
        else if(id == R.id.menuitem_iches_cent) {
            conversion.switch_toInchesCentimeters();
            resetDisplay();
            return true;
        }
        else if(id == R.id.menuitem_pounds_grams) {
            conversion.switch_toPoundsGrams();
            resetDisplay();
            return true;
        }

        else if (id == R.id.menuitem_quit) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void resetDisplay(){
        inputLabel.setText(conversion.inputLable);
        outputLabel.setText(conversion.outputLable);
        outputMeasurement.setText(conversion.outputValue.toString());
        inputMeasurement.setText(conversion.inputValue.toString());
    }
}

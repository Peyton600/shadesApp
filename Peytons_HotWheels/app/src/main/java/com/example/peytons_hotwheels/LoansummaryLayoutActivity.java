package com.example.peytons_hotwheels;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoansummaryLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loansummary_layout);
        TextView monthlyPayET = (TextView)findViewById(R.id.textView6);
        TextView loanReportET = (TextView)findViewById(R.id.textView7);
        Intent intent = getIntent();
        String report;
        report = intent.getStringExtra("LoanReport");
        String monthlyPay;
        monthlyPay = intent.getStringExtra("MonthlyPayment");
        monthlyPayET.setText(monthlyPay);
        loanReportET.setText(report);


    }
    public void goDataEntry(View view){
        finish();
    }
}

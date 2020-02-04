package com.example.questionair;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AnswerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_activite);
        Button questionBtn = (Button) findViewById(R.id.button2);
        questionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showQuestion = new Intent(AnswerActivity.this, MainActivity.class);
                startActivity(showQuestion);
            }
        });
    }

    @Override
    protected void onStart() {

        super.onStart();
        overridePendingTransition(R.anim.answer_in, R.anim.question_out);
    }
}
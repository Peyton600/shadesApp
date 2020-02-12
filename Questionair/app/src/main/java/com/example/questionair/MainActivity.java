package com.example.questionair;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button answerBtn = (Button)findViewById(R.id.button);
        answerBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent showAnswer = new Intent(MainActivity.this , AnswerActivity.class);
                        startActivity(showAnswer);
            }
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        overridePendingTransition(R.anim.question_in,R.anim.answer_out);
    }

}

package com.batsec.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class O2TrainerActivity extends AppCompatActivity {
    boolean isPlaying = false;
    long timeRemain;
    CountDownTimer countDownTimer;
    TextView countdown;
    TextView textView;
    Button button_start;
    int session = 0;
    int isRest = 1;
    int toExit = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o2_trainer);

        Intent getMain = getIntent();
        setSession();

        button_start = (Button) findViewById(R.id.button_Start);
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toExit == 1)
                    finish();
                else if (isPlaying) {
                    button_start.setText(R.string.resume);
                    countDownTimer.cancel();
                    isPlaying = false;
                }
                else {
                    button_start.setText(R.string.pause);
                    startTimer();
                    isPlaying = true;
                }
            }
        });
    }
    public void setSession(){
        switch (session){
            case 0:
                timeRemain = 60000;
                countdown = (TextView) findViewById(R.id.countdown1);
                break;
            case 1:
                timeRemain = 75000;
                countdown = (TextView) findViewById(R.id.countdown2);
                break;
            case 2:
                timeRemain = 90000;
                countdown = (TextView) findViewById(R.id.countdown3);
                break;
            default:
                toExit = 1;
        }
    }
    public void startTimer(){
        countDownTimer = new CountDownTimer(timeRemain, 1) {
            @Override
            public void onTick(long millisUntilFinished) {
                long mins = millisUntilFinished / 60000;
                long sec = millisUntilFinished % 60000 / 1000;
                if (sec < 10)
                    countdown.setText("0" + mins + ":0" + sec);
                else
                    countdown.setText("0" + mins + ":" +sec);
                timeRemain = millisUntilFinished;
            }
            @Override
            public void onFinish() {
                restTimer();
                isPlaying = false;
                if (toExit == 1)
                    button_start.setText(R.string.finish);
                else
                    button_start.setText(R.string.start);
            }
        };
        countDownTimer.start();
    }
    public void restTimer(){
        switch (session){
            case 0:
                textView = (TextView) findViewById(R.id.textView1);
                countdown.setText(R.string._1_00);
                break;
            case 1:
                textView = (TextView) findViewById(R.id.textView2);
                countdown.setText(R.string._1_00);
                break;
            case 2:
                textView = (TextView) findViewById(R.id.textView3);
                countdown.setText(R.string._1_00);
                break;
            default:
                textView.setText(R.string.done);
        }
        textView.setText(R.string.take_rest);
        if (isRest == 1) {
            isRest = isRest - 1;
            timeRemain = 60000;
        }
        else {
            textView.setText(R.string.done);
            countdown.setText("--:--");
            button_start.setText(R.string.finish);
            isRest = isRest + 1;
            session = session + 1;
            setSession();
        }
    }
}

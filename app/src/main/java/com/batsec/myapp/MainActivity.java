package com.batsec.myapp;

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

        Button button_o2Trainer = (Button) findViewById(R.id.button_o2Trainer);
    }
    public void goToO2Trainer(View v){
        Intent intentToO2Trainer;
        intentToO2Trainer = new Intent(this, O2TrainerActivity.class);
        startActivity(intentToO2Trainer);
    }
    public void goToNotifier(View v){
        Intent intentToNotifier;
        intentToNotifier = new Intent(this, Notifier.class);
        startActivity(intentToNotifier);
    }
}

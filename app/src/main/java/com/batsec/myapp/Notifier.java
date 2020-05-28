package com.batsec.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.renderscript.RenderScript;
import android.view.View;
import android.widget.Button;

public class Notifier extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifier);
        createNotificationChannel();

        Button button_notifier = (Button) findViewById(R.id.button_notifier);
        button_notifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(Notifier.this, "test")
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setContentTitle("Title")
                        .setContentText("Test")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(0,builder.build());
            }
        });
    }
    private void createNotificationChannel(){

            CharSequence name = "testChannel";
            String description = "Channel for testing";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("test", name, importance);
            channel.setDescription(description);

            NotificationManager NotificationManager = getSystemService(NotificationManager.class);
            NotificationManager.createNotificationChannel(channel);

    }
}

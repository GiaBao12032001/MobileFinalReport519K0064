package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private NotificationManager notificationManager;
    private NotificationCompat.Builder notificationBuilder;
    private int notificationId = 0;
    private final String NOTIFICATION_CHANNEL_ID = "vn.edu.tdtu.ntan.notification.important";
    private NotificationChannel notificationChannel;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchtoinfo();
            }
        });
        notificationManager = (NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel =
                    new NotificationChannel(NOTIFICATION_CHANNEL_ID,
                            "Demo Notification",
                            NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setShowBadge(true);
            notificationManager.createNotificationChannel(notificationChannel);
        }

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                this,
                0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationBuilder = new NotificationCompat.Builder(this,
                    NOTIFICATION_CHANNEL_ID)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Notification")
                    .setContentText("This is a simple notification")
                    .setStyle(new NotificationCompat.BigPictureStyle()
                            .bigPicture(BitmapFactory.decodeResource(getResources(),
                                    R.mipmap.ic_launcher))
                            .setBigContentTitle("This is a big picture"))
                    .setContentIntent(pendingIntent);
        }
    }
    public void onclickShowNotification(View view) {
        Toast.makeText(this,
                String.valueOf(Build.VERSION.SDK_INT),
                Toast.LENGTH_SHORT).show();
        if (notificationId > 0) {
            notificationManager.cancel(notificationId - 1);
        }
        Notification ntf = notificationBuilder.build();
        notificationManager.notify(notificationId++, ntf);
    }
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }
    public void ClickFavorite(View view) {
        displayToast(getString(R.string.favorite));
    }
    public void ClickCall(View view) {
        displayToast(getString(R.string.call));
    }
    private void switchtoinfo() {
        Intent switchInfoIntent = new Intent(this, NhaThoDucBaActivity.class);
        startActivity(switchInfoIntent);
    }


}
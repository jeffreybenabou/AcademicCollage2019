package com.example.academiccollage.Service;

import android.app.Notification;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FireBaseMessage extends FirebaseMessagingService {
    public static final String TAG = "MsgFirebaseServ";

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("sfsf")
                .setContentText("sadsf")
                .build();
        NotificationManagerCompat manager = NotificationManagerCompat.from(getApplicationContext());
        manager.notify(/*notification id*/0, notification);

        Toast.makeText(this,"fsf",Toast.LENGTH_LONG).show();
    }
}

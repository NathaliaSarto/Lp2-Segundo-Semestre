package com.example.alunos.notifyme;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

/**
 * Created by alunos on 19/10/17.
 */

public class MyMessagingService extends FirebaseMessaginService {

    private static final String TAG = "MyFirebaseMsgSerive";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage){
        Log.d(TAG, "Remetente: " + remoteMessage.getFrom());
        if(remoteMessage.getNotification()!null){
            Log.d(TAG, "Corpo da mensagem: " + remoteMessage.getNotification().getBody());

        }
    }

    private void sendNotification(String messageBody){
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        Notification.Builder notificationBuilder =
                (NotificationCompat.Builder)new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Mensagem FCM")
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
                .setVibrate(new long[]{1000, 1000})
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0, notificationBuilder.build());
    }
}

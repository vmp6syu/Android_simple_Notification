package com.example.week8;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_send;
    Button btn_cancel;


   NotificationManager manager;
   NotificationChannel channel;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_send=(Button) findViewById(R.id.button);
        btn_cancel=(Button)findViewById(R.id.button2);

        manager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        channel=new NotificationChannel("Notice","OuO",NotificationManager.IMPORTANCE_LOW);
        manager.createNotificationChannel(channel);


        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Notification_pass("test_title","test_context");
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.cancelAll();
            }
        });
    }

    private void Notification_pass(String s_title,String s_context){

        final Notification.Builder builder=new Notification.Builder(MainActivity.this,"Notice");
        builder.setSmallIcon(R.drawable.a);
        builder.setColor(Color.green(255));
        builder.setContentText(s_context);
        builder.setContentTitle(s_title);
        //final Notification.BigPictureStyle style=new Notification.BigPictureStyle();
        // Bitmap map=((BitmapDrawable)getResources().getDrawable(R.drawable.b)).getBitmap();
        //  style.bigPicture(map);
        // builder.setStyle(style);
        manager.notify(1,builder.build());
    }
}

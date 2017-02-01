package com.example.student.test19_broadcast_sender;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnSendBroadcast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSendBroadcast = (Button) findViewById
                (R.id.btn_send_broadcast);

        btnSendBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 암시적 인텐트를 만들어서 방송으로 보냄
                Intent intent = new Intent();
                intent.setAction("com.example.YANGYU");
                sendBroadcast(intent);
            }
        });
    }
}

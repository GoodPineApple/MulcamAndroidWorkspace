package com.example.taemi.test13_intent_web;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnCall;
    private Button btnSms;
    private Button btnWeb;
    private Button btnContacts;
    private Button btnWeb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCall = (Button) findViewById(R.id.btn_call_intent);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:01083319717"));
                startActivity(intent);
//                if (MainActivity.this.checkSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
//                    Intent callIntent = new Intent(Intent.ACTION_CALL);
//                    callIntent.setData(Uri.parse("tel:01075640626"));
////                    callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    startActivity(callIntent);
//                }
            }
        });

        btnSms = (Button) findViewById(R.id.btn_sms_intent);
        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:01083319717"));
                intent.putExtra("sms_body","메세지내용입니다");
                startActivity(intent);
            }
        });

        btnWeb = (Button) findViewById(R.id.btn_web_intent);
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://m.naver.com"));
                startActivity(intent);
            }
        });

        btnContacts = (Button) findViewById(R.id.btn_contacts_intent);
        btnContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("content://contacts/people"));
                startActivity(intent);
            }
        });

        btnWeb2 = (Button) findViewById(R.id.btn_web2_intent);
        btnWeb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                startActivity(intent);
            }
        });
    }
}

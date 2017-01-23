package com.example.student.test14_implicit_intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnCall, btnSms, btnWeb, btnContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCall = (Button) findViewById(R.id.btn_call_intent);
        btnSms = (Button) findViewById(R.id.btn_sms_intent);
        btnWeb = (Button) findViewById(R.id.btn_web_intent);
        btnContacts = (Button) findViewById(R.id.btn_contacts_intent);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent
                    (Intent.ACTION_CALL,Uri.parse("tel:01075640626"));
                startActivity(intent);
            }
        });

        btnSms.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent
                        (Intent.ACTION_SENDTO,
                                Uri.parse("smsto:01075640626"));
                intent.putExtra("sms_body","메세지내용");
                startActivity(intent);
            }
        });

        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://m.naver.com"));
                startActivity(intent);
            }
        });

        btnContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("content://contacts/people/"));
                startActivity(intent);
            }
        });

    }

}






package com.example.taemi.test15_intentfilter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnGoogleMap, btnNote, btnContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGoogleMap = (Button) findViewById(R.id.btn_google_map);
        btnGoogleMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//              구글 맵 앱이 설치된 경우 해당 앱의 지도보기 액티비티한테
//              아래의 Intent가 필터를 통과하여 도착함.
                Uri gmmIntentUri =
                        Uri.parse("geo:37.7749,-122.4194?z=10&q=restaurants");
                Intent mapIntent = new Intent();

                mapIntent.setAction(Intent.ACTION_VIEW);
                mapIntent.setData(gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
/////////////////////////////////////////////////////////////////////////
//                Intent mapIntent = new Intent();
//                mapIntent.setAction(Intent.ACTION_VIEW);
//                mapIntent.setData(Uri.parse("https://www.google.co.kr/maps/search/%EB%A9%80%ED%8B%B0%EC%BA%A0%ED%8D%BC%EC%8A%A4/@37.5108207,126.9768204,12z/data=!3m1!4b1?hl=ko"));
                startActivity(mapIntent);

            }
        });

        //test08_scribble
        btnNote = (Button) findViewById(R.id.btn_note);
        btnNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.intent.test.PINEAPPLE");
                startActivity(intent);
            }
        });


        btnContacts = (Button) findViewById(R.id.btn_contact);
        btnContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.intent.test.Contacts");
                startActivity(intent);
            }
        });
    }
}

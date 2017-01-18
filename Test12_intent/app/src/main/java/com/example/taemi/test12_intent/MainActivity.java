package com.example.taemi.test12_intent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by taemi on 2017-01-18.
 */

public class MainActivity extends Activity{
    private Button btnSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        btnSecond = (Button) findViewById(R.id.btn_second_activity);

        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                명시적 인텐트
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

    }

    public void onbtnNaverClicked(View v){
        Toast.makeText(this, "Click Naver Button", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        startActivity(intent);
    }

    public void onBtnCallClicked(View v){
//        암시적 인텐트
        Toast.makeText(this, "Click Call Button", Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-8331-9717"));
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01083319717"));
        startActivity(intent);
    }

}

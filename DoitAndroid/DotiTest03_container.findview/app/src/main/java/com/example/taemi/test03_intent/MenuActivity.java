package com.example.taemi.test03_intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by taemi on 2017-01-25.
 */

public class MenuActivity extends Activity {
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acivity_menu);

        Intent intent = getIntent();
        if (intent == null){
            String title = intent.getStringExtra("title");
            Toast.makeText(getApplicationContext(), "전달받은값:"+title,Toast.LENGTH_SHORT).show();
        }

        btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("name","return");
                setResult(RESULT_OK);
            }
        });

    }
}

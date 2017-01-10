package com.example.taemi.test03;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by taemi on 2017-01-10.
 */

public class MainActivity02 extends Activity {
    private Button btnCount;
    private Button btnReset;
    private TextView textNumber;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main01);

        btnCount = (Button) findViewById(R.id.btn_count);
        btnReset = (Button) findViewById(R.id.btn_reset);
        textNumber = (TextView) findViewById(R.id.text_number);

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                textNumber.setText(count+"");
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                textNumber.setText(count+"");
            }
        });
    }
}

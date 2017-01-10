package com.example.taemi.test03;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by taemi on 2017-01-10.
 */

public class MainActivity01 extends Activity {
    private Button btnRed;
    private Button btnBlue;
    private TextView textColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main01);

        btnRed = (Button) findViewById(R.id.btn_red);
        btnBlue = (Button) findViewById(R.id.btn_blue);
        textColor = (TextView) findViewById(R.id.text_color);

        btnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textColor.setText("RED");
                textColor.setTextColor(Color.RED);
            }
        });

        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textColor.setText("BLUE");
                textColor.setTextColor(Color.BLUE);
            }
        });
    }
}

package com.example.taemi.test08_scribble;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_red;
    private Button btn_blue;
    private Button btn_orange;
    private MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_red = (Button) findViewById(R.id.btn_red);
        btn_blue = (Button) findViewById(R.id.btn_blue);
        btn_orange = (Button) findViewById(R.id.btn_yellow);
        myView = (MyView) findViewById(R.id.my_view);

        btn_red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myView.setBtninfo("red");
            }
        });

        btn_blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myView.setBtninfo("blue");
            }
        });

        btn_orange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myView.setBtninfo("yellow");
            }
        });
    }
}

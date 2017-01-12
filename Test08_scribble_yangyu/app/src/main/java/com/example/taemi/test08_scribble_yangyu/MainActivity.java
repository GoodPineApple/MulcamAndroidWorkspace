package com.example.taemi.test08_scribble_yangyu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnRed, btnBlue, btnGreen;
    private DrawPanel drawPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRed = (Button) findViewById(R.id.btn_red);
        btnBlue = (Button) findViewById(R.id.btn_blue);
        btnGreen = (Button) findViewById(R.id.btn_green);
        drawPanel = (DrawPanel) findViewById(R.id.draw_panel);

        btnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawPanel.chageColor("RED");
            }
        });

        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawPanel.chageColor("BLUE");
            }
        });

        btnGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawPanel.chageColor("GREEN");
            }
        });
    }
}

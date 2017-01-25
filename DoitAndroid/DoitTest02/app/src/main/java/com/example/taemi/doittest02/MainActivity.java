package com.example.taemi.doittest02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img1;
    ImageView img2;

    boolean selected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img1 = (ImageView) findViewById(R.id.imageView);
        img2 = (ImageView) findViewById(R.id.imageView2);

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selected){
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.GONE);
                } else {
                    img1.setVisibility(View.GONE);
                    img2.setVisibility(View.VISIBLE);
                }
                selected = !selected;
            }
        });

    }
}

package com.example.taemi.test04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void taemin(View v){
        Button Clicked = (Button)v;
        Toast.makeText(this, Clicked.getText(), Toast.LENGTH_SHORT).show();
    }
}

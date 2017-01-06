package com.example.taemi.test01_practice;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by taemi on 2017-01-06.
 */

public class MainActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        Button btn2 = (Button)findViewById(R.id.button2);
        btn2.setOnClickListener(new MyListener());

        Button btn3 = (Button)findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"무명클래스 이벤트", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void myClick(View v){
        Toast.makeText(this,"button1!!!!!!!!",Toast.LENGTH_LONG).show();
    }
}

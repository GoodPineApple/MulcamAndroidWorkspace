package com.example.student.test02;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by student on 2017-01-09.
 */

public class MainActivity extends Activity {
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

//        activity_main7 관련 메소드
//        Button btnClick = (Button)findViewById(R.id.btn_click);
//        final TextView textTarget = (TextView)findViewById(R.id.text_target);
//
//        btnClick.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                textTarget.setText("눌렸습니다!!");
//            }
//        });

        Button btnCount = (Button) findViewById(R.id.btn_bottom);
        Button btnReset = (Button) findViewById(R.id.btn_reset);
        final TextView textTarget = (TextView)findViewById(R.id.CountPanel);

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              count++;
                textTarget.setText(count+"");
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                textTarget.setText(count + "");
            }
        });

    }
}

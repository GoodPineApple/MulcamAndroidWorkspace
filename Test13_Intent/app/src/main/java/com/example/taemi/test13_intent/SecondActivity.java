package com.example.taemi.test13_intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by taemi on 2017-01-18.
 */

public class SecondActivity extends Activity {
    private TextView textFromMain;
    private EditText editSecond;
    private Button btnExitSecond;
    private int pressCountBack = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        textFromMain = (TextView) findViewById(R.id.text_from_main);
        editSecond = (EditText) findViewById(R.id.edit_second_activity);
        btnExitSecond = (Button) findViewById(R.id.btn_exit_second);

        Intent receiveIntent = getIntent();
        textFromMain.append(receiveIntent.getStringExtra("sendData"));
        btnExitSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(); // 답장.
                intent.putExtra("reply",editSecond.getText()+"");

                setResult(200,intent);
                finish();  // SecondActivity 종료.
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (pressCountBack==0){

            Toast.makeText(this,"Press one more backBtn to Exit SecondActivity",Toast.LENGTH_SHORT).show();
            pressCountBack++;


        } else{
            super.onBackPressed();
        }

        new Thread() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                    pressCountBack=0;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}

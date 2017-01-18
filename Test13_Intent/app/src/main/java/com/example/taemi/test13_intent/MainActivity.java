package com.example.taemi.test13_intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by taemi on 2017-01-18.
 */

public class MainActivity extends Activity{
    private Button btnToSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        btnToSecond = (Button) findViewById(R.id.btn_to_second_extra);

        btnToSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("sendData","Hello Second");
                startActivityForResult(intent,111);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 111:
                if(resultCode==200){
                    String secondReplyData = data.getStringExtra("reply");
                    Toast.makeText(this,"Exit by Second btn Clicked"+secondReplyData,Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this,"Exit by Back btn Clicked",Toast.LENGTH_SHORT).show();
                }
        }
    }
}

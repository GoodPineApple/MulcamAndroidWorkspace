package com.example.taemi.test03_intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                container = (LinearLayout) findViewById(R.id.container);
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.acivity_menu,container,true);

                Button btn2 = (Button) container.findViewById(R.id.button2);
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "부분화면 버튼이 눌림", Toast.LENGTH_SHORT).show();
                    }
                });



//                Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
//                intent.putExtra("title","love EJ");
//                startActivityForResult(intent,1001);
            }
        });
    }
}

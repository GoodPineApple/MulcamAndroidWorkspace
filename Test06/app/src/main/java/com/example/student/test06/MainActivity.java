package com.example.student.test06;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private ToggleButton toggleSound;
    private EditText editEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleSound = (ToggleButton) findViewById(R.id.toggle_sound);
        toggleSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggleSound.isChecked()){
                    Toast.makeText(getApplicationContext(),
                            "눌림:사운드켜짐",Toast.LENGTH_SHORT)
                            .show();
                }else{
                    Toast.makeText(getApplicationContext(),
                            "눌림:사운드꺼짐",Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
///////////////////////////////////////////////////////////////
        editEnter.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN &&
                        keyCode == KeyEvent.KEYCODE_ENTER){
                    Toast.makeText(getApplicationContext(),
                            "입력메시지:"+editEnter.getText(), Toast.LENGTH_SHORT)
                            .show();
                    return true;
                }
                return false;
            }
        });
    }
}

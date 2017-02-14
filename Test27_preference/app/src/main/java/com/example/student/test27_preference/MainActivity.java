package com.example.student.test27_preference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private EditText editPref;
    private Button btnSave, btnLoad;

    public static final String PREF_NAME = "YujinPref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPref = (EditText) findViewById(R.id.edit_pref);
        btnSave = (Button) findViewById(R.id.btn_save);
        btnLoad = (Button) findViewById(R.id.btn_load);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editPref.getText()+"";
                if(text!=null && text.length()>0){
                    SharedPreferences yujinPref =
                            getSharedPreferences(PREF_NAME,MODE_PRIVATE);
                    SharedPreferences.Editor editor = yujinPref.edit();

                    editor.putString("savedText", text);
                    editor.commit();
                }else{
                    Toast.makeText(MainActivity.this,"입력없음",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences yujinPref =
                        getSharedPreferences(PREF_NAME,MODE_PRIVATE);
                
                // savedText라는 키값으로 저장된 데이터가 없는 경우
                // 자동으로 none 이라는 값이 불러짐.
                String savedText = yujinPref.getString("savedText","none");
                editPref.setText(savedText);
            }
        });

    }
}

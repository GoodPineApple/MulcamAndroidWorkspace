package com.example.taemi.test09_scribblewithmenu;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends Activity {
    private Button btn_selectColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_selectColor = (Button) findViewById(R.id.select_color);
        btn_selectColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu colorPopupMenu = new PopupMenu(getApplicationContext(),btn_selectColor);
                colorPopupMenu.getMenuInflater().inflate(R.menu.menu,colorPopupMenu.getMenu());

                colorPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.item_red :
                                Toast.makeText(getApplicationContext(),"빨강 선택",Toast.LENGTH_LONG).show();
                                break;
                            case R.id.item_blue:
                                Toast.makeText(getApplicationContext(),"파란 선택",Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.item_white:
                                Toast.makeText(getApplicationContext(),"하얀 선택",Toast.LENGTH_SHORT).show();
                                break;
                            Toast
                        }
                        return false;
                    }
                });

            }
        });

    }
}

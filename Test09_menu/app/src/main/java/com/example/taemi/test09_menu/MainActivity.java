package com.example.taemi.test09_menu;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends Activity {

    private TextView textContext;
    private Button btnPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textContext = (TextView) findViewById(R.id.text_context);
        registerForContextMenu(textContext);

        btnPopup = (Button) findViewById(R.id.btn_popup);
        btnPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(getApplicationContext(),btnPopup);
                popup.getMenuInflater().inflate(R.menu.my_menu,popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
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
                        }
                        return false;
                    }
                });

                popup.show();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("컨택스트 메뉴");
        menu.add(0,1,0,"첫째");
        menu.add(0,2,0,"둘째");
        menu.add(0,3,0,"셋째");
        menu.add(0,4,0,"넷째");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                textContext.setBackgroundColor(Color.BLUE);
                break;
            case 2:
                textContext.setBackgroundColor(Color.RED);
                break;
            case 3:
                textContext.setBackgroundColor(Color.WHITE);
                break;
            case 4:
                textContext.setBackgroundColor(Color.GREEN);
                break;
        }

        return super.onContextItemSelected(item);
    }

    //    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuItem item = menu.add(0,1,0,"orange");
//        menu.add(0,2,0,"blue");
//        menu.add(0,3,0,"yellow");
//
//        return true;
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.my_menu,menu);
        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_red :
                Toast.makeText(this, "빨간 선택", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_blue:
                Toast.makeText(this,"파란 선택",Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_white:
                Toast.makeText(this,"하얀 선택",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onMenuItemSelected(featureId, item);
    }
}

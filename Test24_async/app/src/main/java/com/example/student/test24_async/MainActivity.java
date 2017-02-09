package com.example.student.test24_async;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private Button btnDown;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDown = (Button) findViewById(R.id.btn_down);
        imageView = (ImageView) findViewById(R.id.image_view);

        btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadThread t = new DownloadThread();
                t.execute();
            }
        });
    }

    class DownloadThread extends AsyncTask<Void,Void,Bitmap>{

        @Override
        protected Bitmap doInBackground(Void... params) {
            Bitmap bitmap = null;
            InputStream is = null;
            String imgUrl = "http://rgo4.com/files/attach/images/2676751/345/921/002/d3540f585dee5aeb7d4f8e0b2f794dc1.jpg";

            try {
                // http 요청 보내서 응답 이미지를 bitmap으로 받는 작업
                URL url = new URL(imgUrl);
                HttpURLConnection urlConnection =
                        (HttpURLConnection) url.openConnection();
                urlConnection.connect();
                is = urlConnection.getInputStream();
                bitmap = BitmapFactory.decodeStream(is);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally{
                if(is!=null)
                    try {is.close();}
                    catch (IOException e) {}
            }

            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            imageView.setImageBitmap(bitmap);
            Toast.makeText(MainActivity.this, "download complete!",
                    Toast.LENGTH_SHORT).show();
        }
    }
}











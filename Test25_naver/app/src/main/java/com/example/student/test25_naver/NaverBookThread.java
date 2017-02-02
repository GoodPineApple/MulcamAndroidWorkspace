package com.example.student.test25_naver;

import android.os.Handler;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by student on 2017-02-02.
 */

public class NaverBookThread extends Thread{
    private Handler handler;
    private String keyword;

    public NaverBookThread(Handler handler, String keyword){
        this.handler = handler;
        this.keyword = keyword;
    }
//////////////////////////////////////////////////////////////
// 1. keyword와 그밖의 파라미터를 포함해서 URL 요청 만들기
// 2. 응답받은 XML 데이터를 파싱해서 원하는 정보 추출
// 3. 2에서 추출한 데이터를 Book객체로 만들어서 List에 담음.
// 4. handler를 통해 BookList를 sendMessage
    @Override
    public void run() {
        String urlStr = null;
        try {
            urlStr = "https://openapi.naver.com/v1/search/book.xml?query="+
                    URLEncoder.encode(keyword, "UTF-8");
            URL url = new URL(urlStr);

            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();
            connection.setRequestProperty
                    ("X-Naver-Client-Id", "8QAf5GX8gzGiswY5Aqpd");
            connection.setRequestProperty
                    ("X-Naver-Client-Secret", "aAMUUdPseJ");
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            BufferedReader br;

            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader
                        (connection.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader
                        (connection.getErrorStream()));
            }

            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            Log.i("naver test",response.toString());

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}












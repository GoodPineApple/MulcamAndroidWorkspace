package com.example.student.test25_naver;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.student.test25_naver.vo.BookVO;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by student on 2017-02-02.
 */

public class NaverBookThread extends Thread {
    private Handler handler;
    private String keyword;

    public NaverBookThread(Handler handler, String keyword) {
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
            urlStr = "https://openapi.naver.com/v1/search/book.xml?query=" +
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

            if (responseCode == 200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader
                        (connection.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader
                        (connection.getErrorStream()));
            }
            // 여기까지 네이버와 연결 설정하는 부분
/////////////////////////////////////////////////////////////
            // 여기부터 실질적으로 데이터 읽어들이는 부분
            XmlPullParser parser = XmlPullParserFactory.newInstance()
                    .newPullParser();
            parser.setInput(br);

            List<BookVO> bookVOList = new ArrayList<>();
            BookVO bookVO = null;

            int eventType = parser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG) {
                    String tagName = parser.getName();
                    if (tagName.equals("title")) {
                        bookVO = new BookVO();

                    // 책 제목에서 <b></b> 태그 제거하기 작업///////////////
                        String bookTitle = parser.nextText();

                        Pattern pattern = Pattern.compile("<.?b>");
                        Matcher matcher = pattern.matcher(bookTitle);

                        if(matcher.find()==true){
                            // <b></b> 태그가 있는 경우 ""으로 지우기
                            bookTitle = matcher.replaceAll("");
                        }
                        bookVO.setTitle(bookTitle);
                    } else if (tagName.equals("image")) {
                        bookVO.setImgURL(parser.nextText());
                    } else if (tagName.equals("author")) {
                        bookVO.setAuthor(parser.nextText());
                    } else if (tagName.equals("price")) {
                        bookVO.setPrice(parser.nextText());
                    } else if (tagName.equals("discount")) {
                        bookVO.setSalePrice(parser.nextText());
                    } else if (tagName.equals("publisher")) {
                        bookVO.setPublisher(parser.nextText());
                        bookVOList.add(bookVO);
                    }
                }
                eventType = parser.next();
            }

            Message msg = new Message();
            msg.obj = bookVOList;
            handler.sendMessage(msg); // 쓰레드 작업 종료!
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
    }
}












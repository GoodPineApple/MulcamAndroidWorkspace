package com.example.student.test25_naver;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.student.test25_naver.vo.BookVO;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by student on 2017-02-02.
 */

public class BookListAdapter extends ArrayAdapter<BookVO> {
    private Context activity;
    private int layout;
    private List<BookVO> bookVOList;

    public BookListAdapter
            (Context context, int resource, List<BookVO> objects) {
        super(context, resource, objects);

        this.activity = context;
        this.layout = resource;
        this.bookVOList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BookHolder holder = null;

        if (convertView != null) {
            // getView 첫 실행이 아닐때는 이전의 정보 얻어 씀.
            holder = (BookHolder) convertView.getTag();
        } else {
            // getView 첫 실행일 때에는 새로 inflate를 함.
            LayoutInflater inflater =
                    ((Activity) activity).getLayoutInflater();

            convertView = inflater.inflate(layout, parent, false);

            holder = new BookHolder();
            holder.title = (TextView) convertView.findViewById
                    (R.id.text_book_title);
            holder.author = (TextView) convertView.findViewById
                    (R.id.text_book_author);
            holder.imageViewBook = (ImageView) convertView.findViewById
                    (R.id.image_book);
            holder.price = (TextView) convertView.findViewById
                    (R.id.text_book_price);
            holder.publisher = (TextView) convertView.findViewById
                    (R.id.text_book_publisher);
            holder.salePrice = (TextView) convertView.findViewById
                    (R.id.text_book_price_sale);
            convertView.setTag(holder);
        }

        BookVO bookVO = bookVOList.get(position);

        holder.title.setText(bookVO.getTitle());
        holder.salePrice.setText(bookVO.getSalePrice());
        holder.publisher.setText(bookVO.getPublisher());
        holder.price.setText(bookVO.getPrice());
        holder.author.setText(bookVO.getAuthor());

        BookImageThread t = new BookImageThread
                (holder.imageViewBook, bookVO.getImgURL());
        t.execute();

        return convertView;
    }

    ////////////////////////////////////////////////////////////
//  ListView에 넣을 아이템 매번 inflate(팽창)하려면 비효율 적이므로
//  한번만 inflate해서 holder 객체의 멤버변수들에 기억시켜 놓음.
    class BookHolder {
        ImageView imageViewBook;
        TextView title;
        TextView author;
        TextView publisher;
        TextView price;
        TextView salePrice;
    }

    /////////////////////////////////////////////////////////////
    class BookImageThread extends AsyncTask<Void, Void, Bitmap> {
        private ImageView imageView;
        private String imgUrl;

        public BookImageThread(ImageView imageView, String imgUrl){
            this.imageView = imageView;
            this.imgUrl = imgUrl;
        }

        @Override
        protected Bitmap doInBackground(Void... params) {
            Bitmap bitmap = null;

            URL url = null; // XML에 들어있던 이미지URL 주소
            try {
                url = new URL(imgUrl);
                BufferedInputStream is =
                        new BufferedInputStream(url.openStream());
                bitmap = BitmapFactory.decodeStream(is); // 이미지 다운로드
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            imageView.setImageBitmap(bitmap);
        }
    }
}














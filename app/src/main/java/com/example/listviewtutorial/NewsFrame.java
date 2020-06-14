package com.example.listviewtutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.example.listviewtutorial.MainActivity.IMAGE_URL;
import static com.example.listviewtutorial.MainActivity.INFO;
import static com.example.listviewtutorial.MainActivity.PUBLISHER;
import static com.example.listviewtutorial.MainActivity.TITLE;

public class NewsFrame extends AppCompatActivity {
    private TextView titleHeader;
    private ImageView urlimage;
    private TextView Titleagain;
    private TextView Publisher;
    private TextView info;
    private static final String URL_DATA="https://learnappmaking.com/ex/news/articles/Apple?secret=CHWGk3OTwgObtQxGqdLvVhwji6FsYm95oe87o3ju";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_frame);
        titleHeader=(TextView)findViewById(R.id.titletextheader);
        urlimage = (ImageView)findViewById(R.id.imageview2);
        Titleagain = (TextView)findViewById(R.id.titleagain);
        Publisher = (TextView)findViewById(R.id.publisher);
        info = (TextView)findViewById(R.id.information);
        Intent intent = getIntent();
        String title=intent.getStringExtra(TITLE);
        String publisher = intent.getStringExtra(PUBLISHER);
        String inform = intent.getStringExtra(INFO);
        String imgurl= intent.getStringExtra(IMAGE_URL);
        Glide.with(getApplicationContext()).load(imgurl).into(urlimage);
        titleHeader.setText(title);
        Titleagain.setText(title);
        Publisher.setText(publisher);
        info.setText(inform);


    }


    public void gotomainpage(View view) {
        Intent intent = new Intent (NewsFrame.this,MainActivity.class);
        startActivity(intent);
    }
}




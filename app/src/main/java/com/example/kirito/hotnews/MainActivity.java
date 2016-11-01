package com.example.kirito.hotnews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.kirito.hotnews.entity.NewsItem;
import com.example.kirito.hotnews.support.LoadData;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String url = "http://v.juhe.cn/toutiao/index?type=top&key=26f819932456ca1753977723c2473a43";
    private ListView lv;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.lv);
        LoadData loadData = new LoadData();
        loadData.execute(url);
        loadData.setItem(new LoadData.Items() {
            @Override
            public void setNewsItems(List<NewsItem> items) {
                adapter = new ListAdapter(MainActivity.this);
                adapter.addItems(items);
                lv.setAdapter(adapter);
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        NewsItem item = (NewsItem) parent.getItemAtPosition(position);
                        Intent intent = new Intent(MainActivity.this,ShowDetail.class);
                        intent.putExtra("url",item.getUrl());
                        startActivity(intent);
                    }
                });
            }
        });
    }
}

package com.example.kirito.hotnews.support;

import android.os.AsyncTask;

import com.example.kirito.hotnews.entity.NewsItem;

import java.util.List;

/**
 * Created by kirito on 2016.11.01.
 */

public class LoadData extends AsyncTask<String,Void,String> {
    private Items items;

    public LoadData(Items items) {
        this.items = items;
    }

    public LoadData() {
    }

    @Override
    protected String doInBackground(String... params) {
        String data = Http.getDataFromUrl(params[0]);
        return data;
    }

    @Override
    protected void onPostExecute(String s) {
        List<NewsItem> newsItems = JsonHelper.parseJson(s);
        if (newsItems != null){
            items.setNewsItems(newsItems);
        }
    }

    public interface Items{
        void setNewsItems(List<NewsItem> items);
    }

    public void setItem(Items items){
        this.items = items;
    }
}

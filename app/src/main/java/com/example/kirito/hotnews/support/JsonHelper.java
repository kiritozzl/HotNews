package com.example.kirito.hotnews.support;

import com.example.kirito.hotnews.entity.NewsItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kirito on 2016.11.01.
 */

public class JsonHelper {

    public static List<NewsItem> parseJson(String datas){
        List<NewsItem> items = null;
        try {
            JSONObject json = new JSONObject(datas);
            JSONObject result = json.getJSONObject("result");
            int state = result.getInt("stat");
            if (state == 1){
                JSONArray data = result.getJSONArray("data");
                items = new ArrayList<>();
                for (int i = 0; i < data.length(); i++) {
                    JSONObject obj = data.getJSONObject(i);
                    NewsItem item = new NewsItem();
                    item.setAuthor_name(obj.getString("author_name"));
                    item.setTitle(obj.getString("title"));
                    item.setDate(obj.getString("date"));
                    item.setThumb_url(obj.getString("thumbnail_pic_s"));
                    item.setRealType(obj.getString("realtype"));
                    item.setUrl(obj.getString("url"));
                    items.add(item);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return items;
    }
}

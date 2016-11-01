package com.example.kirito.hotnews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kirito.hotnews.entity.NewsItem;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by kirito on 2016.11.01.
 */

public class ListAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflater;
    private List<NewsItem> newsItems;
    private Context mContext;

    public ListAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
        this.mContext = context;
    }

    public void addItems(List<NewsItem> newsItems){
        this.newsItems = newsItems;
    }

    @Override
    public int getCount() {
        return newsItems.size();
    }

    @Override
    public Object getItem(int position) {
        return newsItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder holder;
        if (convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.itemslayout,parent,false);
            holder = new viewHolder();
            holder.iv = (ImageView) convertView.findViewById(R.id.iv);
            holder.date = (TextView) convertView.findViewById(R.id.date);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.source = (TextView) convertView.findViewById(R.id.source);
            holder.type = (TextView) convertView.findViewById(R.id.type);
            convertView.setTag(holder);
        }else {
            holder = (viewHolder) convertView.getTag();
        }
        NewsItem item = newsItems.get(position);
        Picasso.with(mContext).load(item.getThumb_url()).into(holder.iv);
        holder.title.setText(item.getTitle());
        holder.date.setText(item.getDate());
        holder.source.setText(item.getAuthor_name());
        holder.type.setText(item.getRealType());
        return convertView;
    }

    class viewHolder{
        ImageView iv;
        TextView title,date,source,type;
    }
}

package com.noyet.zzj.sectionadapterdemo;

import android.content.Context;
import android.view.LayoutInflater;

import java.util.List;

/**
 * package: com.noyet.zzj.sectionadapterdemo
 * Created by noyet on 2015/12/9.
 */
public class SectionItem<T> {

    private String mTitle;
    private List<T> mItems;
    private Context mContext;
    private LayoutInflater mInflater;

    public SectionItem (Context context, String title, List<T> items) {
        mContext = context;
        mTitle = title;
        mInflater = LayoutInflater.from(context);
        mItems = items;
    }

    public int getCount() {
        return mItems.size();
    }

    public T getItem(int position) {
        return mItems.get(position);
    }

    /*public boolean isEqualSection(SectionItem item) {
        if (item == null) {
            return false;
        }
        return getTitle().equals(item.getTitle());
    }*/

    public LayoutInflater getmInflater() {
        return mInflater;
    }

    public String getTitle() {
        return mTitle;
    }

    public List<T> getItems() {
        return mItems;
    }
}

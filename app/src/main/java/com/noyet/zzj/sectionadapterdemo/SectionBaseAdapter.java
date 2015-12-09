package com.noyet.zzj.sectionadapterdemo;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

/**
 * package: com.noyet.zzj.sectionadapterdemo
 * Created by noyet on 2015/12/9.
 */
public abstract class SectionBaseAdapter<T> extends BaseAdapter {

    protected final static int TYPE_SECTION_HEADER = 0;
    protected Context mContext;
    protected SparseArray<T> mSection;
    protected int mTypeCount;
    protected LayoutInflater mInflater;

    public SectionBaseAdapter(Context context, SparseArray<T> section) {
        mContext = context;
        mSection = section;
        mTypeCount = section.size();
        mInflater = LayoutInflater.from(context);
    }

    public T getItemSection(int position) {
        if (position >= mSection.size()) {
            return null;
        }
        return mSection.get(mSection.keyAt(position));
    }
}

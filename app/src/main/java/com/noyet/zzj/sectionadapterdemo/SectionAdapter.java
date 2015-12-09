package com.noyet.zzj.sectionadapterdemo;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * package: com.noyet.zzj.sectionadapterdemo
 * Created by noyet on 2015/12/9.
 */
public class SectionAdapter extends SectionBaseAdapter<SectionItem> {

    public SectionAdapter(Context context, SparseArray<SectionItem> mSectionItems) {
        super(context, mSectionItems);
    }

    @Override
    public int getItemViewType(int position) {
        int titlePos = 0;
        for (int i = 0; i < mTypeCount; i++) {
            SectionItem sectionItem = getItemSection(titlePos);
            int size = sectionItem.getCount() + 1;

            if (position < size) {
                return position;
            }
            position -= size;
            titlePos++;
        }
        return -1;
    }

    @Override
    public int getViewTypeCount() {
        return mTypeCount;
    }

    @Override
    public int getCount() {
        int total = 0;
        for (int i = 0; i < mTypeCount; i++) {
            total += getItemSection(i).getCount() + 1;
        }
        return total;
    }

    @Override
    public Object getItem(int position) {
        int titlePos = 0;
        for (int i = 0; i < mTypeCount; i++) {

            SectionItem sectionItem = getItemSection(titlePos);
            int size = sectionItem.getCount() + 1;
            if (position < size) {
                return sectionItem;
            }
            position -= size;
            titlePos++;
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return (long) position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SectionItem item = (SectionItem) getItem(position);
        int itemPos = getItemViewType(position);
        ViewHolder holder;

        if (itemPos == TYPE_SECTION_HEADER) {
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.item_title_section, null);
                holder = new ViewHolder();
                holder.textView = (TextView) convertView.findViewById(R.id.text_title);
                holder.imageView = (ImageView) convertView.findViewById(R.id.text_title_iv);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.imageView.setImageResource(android.R.drawable.ic_dialog_dialer);
            holder.textView.setText(item.getTitle());
            return convertView;
        } else {
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.item_content_section, null);
                holder = new ViewHolder();
                holder.textView = (TextView) convertView.findViewById(R.id.text_content);
                convertView.setTag(R.id.tag_data, holder);
            } else {
                holder = (ViewHolder) convertView.getTag(R.id.tag_data);
            }
            String content = item.getItem(itemPos - 1).toString();
            holder.textView.setText(content);
            convertView.setTag(R.id.tag_id, content);
            convertView.setOnClickListener(listener);
            return convertView;
        }
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(mContext, (String) v.getTag(R.id.tag_id), Toast.LENGTH_SHORT).show();
        }
    };

    static class ViewHolder {
        TextView textView;
        ImageView imageView;
    }
}

package com.noyet.zzj.sectionadapterdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SectionAdapter mAdapter;
    private SparseArray<SectionItem> mSectionItems;
    private List<String> list;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.list_view);

        mSectionItems = new SparseArray<>();
        list = new ArrayList<>();
        list.add("like me 1");
        list.add("like me 2");
        list.add("like me 3");
        for (int i = 0; i < 10; i++) {
            SectionItem<String> sectionItem = new SectionItem<>(this, "title" + i, list);
            mSectionItems.put(i, sectionItem);
        }
        mAdapter = new SectionAdapter(this, mSectionItems);
        mListView.setAdapter(mAdapter);
    }
}

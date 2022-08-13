package com.alfiyandipandya.a10119007_diarynotes.adapter;

// NIM   : 10119007
// Nama  : Alfiyandi Pandya K
// Kelas : IF-1

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alfiyandipandya.a10119007_diarynotes.R;
import com.alfiyandipandya.a10119007_diarynotes.model.DiaryModel;

import java.util.List;

public class DiaryAdapter extends BaseAdapter {

    private final Context context;
    private List<DiaryModel> diaryAdapter;
    private LayoutInflater layoutInflater;

    public DiaryAdapter(Context context, List<DiaryModel> diaryAdapter) {
//        this.activity = activity;
        this.context = context;
        this.diaryAdapter = diaryAdapter;
    }

    @Override
    public int getCount() {
        return diaryAdapter.size();
    }

    @Override
    public Object getItem(int i) {
        return diaryAdapter.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (layoutInflater == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.list_item, null);
        }

        if (convertView != null) {
            DiaryModel note = diaryAdapter.get(position);
            TextView title = convertView.findViewById(R.id.title);
            TextView category = convertView.findViewById(R.id.category);
            title.setText(note.getTitle());
            category.setText(note.getCategory());
        }
        return convertView;
    }
}
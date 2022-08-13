package com.alfiyandipandya.a10119007_diarynotes.activity.diary;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.alfiyandipandya.a10119007_diarynotes.R;
import com.alfiyandipandya.a10119007_diarynotes.database.Database;
import com.alfiyandipandya.a10119007_diarynotes.model.DiaryModel;

public class DetailDiaryActivity extends AppCompatActivity {

    private TextView title, category, note;
    private Database database;
    private DiaryModel diaryModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_diary);

        title = findViewById(R.id.title);
        category = findViewById(R.id.category);
        note = findViewById(R.id.note);

        int id = getIntent().getIntExtra("id", 0);

        database = new Database(this);
        SQLiteDatabase db = database.getWritableDatabase();
        Cursor cursor = db.rawQuery(database.selectById(id), null);

        cursor.moveToFirst();

        diaryModel = new DiaryModel();
        diaryModel.setId(id);
        diaryModel.setTitle(cursor.getString(1).toString());
        diaryModel.setCategory(cursor.getString(2).toString());
        diaryModel.setNote(cursor.getString(3).toString());

        cursor.close();

        title.setText(diaryModel.getTitle());
        category.setText(diaryModel.getCategory());
        note.setText(diaryModel.getNote());


    }
}
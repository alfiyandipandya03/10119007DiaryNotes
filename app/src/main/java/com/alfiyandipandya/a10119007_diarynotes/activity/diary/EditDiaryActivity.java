package com.alfiyandipandya.a10119007_diarynotes.activity.diary;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.alfiyandipandya.a10119007_diarynotes.MainActivity;
import com.alfiyandipandya.a10119007_diarynotes.R;
import com.alfiyandipandya.a10119007_diarynotes.database.Database;
import com.alfiyandipandya.a10119007_diarynotes.model.DiaryModel;

public class EditDiaryActivity extends AppCompatActivity {

    private EditText inputTitle, inputCategory, inputNote;
    private Button btn_save;
    private Database database;
    private DiaryModel diaryModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_diary);

        inputTitle = findViewById(R.id.title);
        inputCategory = findViewById(R.id.category);
        inputNote = findViewById(R.id.note);
        btn_save = findViewById(R.id.btn_save);

        int id = getIntent().getIntExtra("id", 0);

        database = new Database(this);
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor = db.rawQuery(database.selectById(id), null);

        cursor.moveToFirst();

        diaryModel = new DiaryModel();
        diaryModel.setId(id);
        diaryModel.setTitle(cursor.getString(1).toString());
        diaryModel.setCategory(cursor.getString(2).toString());
        diaryModel.setNote(cursor.getString(3).toString());

        cursor.close();

        inputTitle.setText(diaryModel.getTitle());
        inputCategory.setText(diaryModel.getCategory());
        inputNote.setText(diaryModel.getNote());

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = inputTitle.getText().toString().trim();
                String category = inputCategory.getText().toString().trim();
                String note = inputNote.getText().toString().trim();

                if (TextUtils.isEmpty(title)) {
                    inputTitle.setError("Judul wajib diisi.");
                } else if (TextUtils.isEmpty(category)) {
                    inputCategory.setError("Kategori wajib diisi.");
                } else if (TextUtils.isEmpty(title)) {
                    inputNote.setError("Catatan wajib diisi.");
                } else {
                    SQLiteDatabase db = database.getWritableDatabase();
                    database.updateTable(db, title, category, note, id);
                    Toast.makeText(EditDiaryActivity.this, "Berhasil mengubah catatan.", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(EditDiaryActivity.this, MainActivity.class));
                    finish();
                }
            }
        });
    }
}
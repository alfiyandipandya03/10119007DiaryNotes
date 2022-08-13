package com.alfiyandipandya.a10119007_diarynotes.activity.diary;

import android.content.Intent;
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

public class AddDiaryActivity extends AppCompatActivity {

    private EditText inputTitle, inputCategory, inputNote;
    private Button btn_add;
    private Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_diary);

        database = new Database(this);

        inputTitle = findViewById(R.id.title);
        inputCategory = findViewById(R.id.category);
        inputNote = findViewById(R.id.note);

        btn_add = findViewById(R.id.btn_add);

        btn_add.setOnClickListener(new View.OnClickListener() {
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
                    database.insertToTable(db, title, category, note);
                    Toast.makeText(AddDiaryActivity.this, "Berhasil menambahkan catatan.", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AddDiaryActivity.this, MainActivity.class));
                    finish();
                }
            }
        });
    }
}
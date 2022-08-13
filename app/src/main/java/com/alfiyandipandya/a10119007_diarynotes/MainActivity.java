package com.alfiyandipandya.a10119007_diarynotes;

// NIM   : 10119007
// Nama  : Alfiyandi Pandya K
// Kelas : IF-1

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.alfiyandipandya.a10119007_diarynotes.fragment.DiaryFragment;
import com.alfiyandipandya.a10119007_diarynotes.fragment.InfoFragment;
import com.alfiyandipandya.a10119007_diarynotes.fragment.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.btn_notes:
                    fragment = new DiaryFragment();
                    break;
                case R.id.btn_profile:
                    fragment = new UserFragment();
                    break;
                case R.id.btn_info:
                    fragment = new InfoFragment();
                    break;
                default:
            }

            initFragment(fragment);
            return true;
        });

        initFragment(new DiaryFragment());
    }

    private void initFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.container_fragment, fragment)
                .commit();
    }
}
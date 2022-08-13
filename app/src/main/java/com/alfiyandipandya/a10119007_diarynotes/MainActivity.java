package com.alfiyandipandya.a10119007_diarynotes;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.alfiyandipandya.a10119007_diarynotes.fragment.DiaryFragment;
import com.alfiyandipandya.a10119007_diarynotes.fragment.InfoFragment;
import com.alfiyandipandya.a10119007_diarynotes.fragment.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
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
                        fragment = null;
                }

                initFragment(fragment);
                return true;
            }
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
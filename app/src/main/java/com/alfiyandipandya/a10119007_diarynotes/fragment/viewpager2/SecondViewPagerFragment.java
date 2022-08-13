package com.alfiyandipandya.a10119007_diarynotes.fragment.viewpager2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.alfiyandipandya.a10119007_diarynotes.R;

public class SecondViewPagerFragment extends Fragment {


    public SecondViewPagerFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second_view_pager, container, false);
    }
}
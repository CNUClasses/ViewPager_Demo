package com.example.keith.viewpager_demo;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    ViewPager vp;
    CusomSwipeAdapter csa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp = (ViewPager)findViewById(R.id.view_pager);
        csa = new CusomSwipeAdapter(this);
        vp.setAdapter(csa);
    }
}

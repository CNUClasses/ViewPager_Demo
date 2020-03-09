package com.example.keith.viewpager_demo;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //viewpager stuff
    private ViewPager2 vp2;
    private ViewPager2_Adapter vp2_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        vp2 = (ViewPager2)findViewById(R.id.view_pager);
        vp2_adapter = new ViewPager2_Adapter();
        vp2.setAdapter(vp2_adapter);
   }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.action_settings:
            {
                return true;
            }
            case R.id.action_changetext: {
                //TODO lets change the text of this item
                TextView mtv = vp2.findViewById(R.id.tv);
                mtv.setText("Bogon");           //this lasts a limited time, should save in adapter

                //lets get the tag associated with iv
                int tag = (Integer)(vp2.findViewById(R.id.imageView)).getTag();
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }
}

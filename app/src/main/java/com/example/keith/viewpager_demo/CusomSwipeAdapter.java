package com.example.keith.viewpager_demo;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by keith on 3/5/18.
 */

public class CusomSwipeAdapter extends PagerAdapter {
    private int[] image_resources = { R.drawable.p0,R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5 };
    private Context ctx;
    private LayoutInflater lf;

    public CusomSwipeAdapter(Context ctx){
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return image_resources.length;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        lf = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = lf.inflate(R.layout.swipe_layout,container,false);

        ImageView iv = (ImageView)item_view.findViewById(R.id.imageView);
        TextView tv = (TextView)item_view.findViewById(R.id.tv);

        iv.setImageResource(image_resources[position]);

        tv.setText("Image : " + position);


        container.addView(item_view);

        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout)object);
    }

}

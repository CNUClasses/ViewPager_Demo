package com.example.keith.viewpager_demo;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Created by keith on 3/5/18.
 */

public class ViewPager2_Adapter extends RecyclerView.Adapter {
    private static final String TAG = "ViewPager2_Adapter";
    private int[] image_resources = { R.drawable.p0,R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5 };

    private final int DEFAULT_NUMB_IMAGES = 1;
    private Drawable mDefaultImage;

    class PagerViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv;
        String url;

        public PagerViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = (ImageView)itemView.findViewById(R.id.imageView);
            tv = (TextView)itemView.findViewById(R.id.tv);
        }

        String getURL(){return url;}
        void setURL(String url){this.url=url;}
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.swipe_layout, parent, false);
        return new PagerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //lets lazily set up a default image
        if (mDefaultImage ==null)
            mDefaultImage = holder.itemView.getContext().getDrawable(R.drawable.error);

        //wants a new viewholder so set it up with defaults
        PagerViewHolder viewHolder = (PagerViewHolder) holder;

        //if we have no pets then just display the default
        if (image_resources == null) {
            viewHolder.iv.setImageDrawable(mDefaultImage);
            viewHolder.iv.setTag(-1);                       //set TAG!
            viewHolder.tv.setText("Default text");
        }
        else{
            //launch a thread to get this image
            viewHolder.iv.setImageResource(image_resources[position]);
            viewHolder.iv.setTag(position);                 //set TAG!
            viewHolder.tv.setText("Image "+ position);
        }

    }

    @Override
    public int getItemCount() {
        return image_resources.length;
    }
}

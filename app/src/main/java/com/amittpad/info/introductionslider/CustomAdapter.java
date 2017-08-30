package com.amittpad.info.introductionslider;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by pc31 on 30-08-2017.
 */

public class CustomAdapter extends PagerAdapter {

    private Context ctx;
    private LayoutInflater inflater;
    private int[] images = {R.drawable.daily,R.drawable.dite,R.drawable.meditation};
    private Button btnSkip;


    CustomAdapter(Context ctx){
        this.ctx = ctx;
    }
    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view ==object);
    }
    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        inflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.multiple_screen,container,false);
        ImageView img =(ImageView)v.findViewById(R.id.imageView);
        img.setImageResource(images[position]);

        container.addView(v);
        return v;
    }
    @Override
    public void destroyItem(View container, int position, Object object) {
        container.refreshDrawableState();
    }
}

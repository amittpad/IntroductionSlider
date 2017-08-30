package com.amittpad.info.introductionslider;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AbstractProjectBaseActivity {
    private int[] images = {R.drawable.daily,R.drawable.dite,R.drawable.meditation};
    private ViewPager viewPager;

    private Button btnSkip;
    private Button btnNext;
    private LinearLayout dotsLayout;
    private TextView[] dots;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSkip = (Button) findViewById(R.id.button_skip);
        btnNext = (Button) findViewById(R.id.button_next);
        dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
        viewPager = (ViewPager)findViewById(R.id.view_pager);
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        CustomAdapter customAdapter = new CustomAdapter(this);
        viewPager.setAdapter(customAdapter);
        addBottomDots(0);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addBottomDots(position);
                if (position == 2){
                    btnNext.setText("GET STARTED");
                    btnSkip.setVisibility(View.INVISIBLE);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                       // btnNext.setBackground(getResources().getDrawable(R.drawable.button_border, null));
                        btnNext.setTextColor(getResources().getColor(R.color.colorPrimary));

                    }else {
                        //btnNext.setBackground(getResources().getDrawable(R.drawable.button_border));
                        btnNext.setTextColor(getResources().getColor(R.color.colorPrimary));
                    }
                    btnNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    });

                }else {
                    btnNext.setText("NEXT");
                    btnSkip.setVisibility(View.VISIBLE);

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                           // btnNext.setTextColor(getResources().getColor(R.color.colorText, null));
                            btnNext.setTextColor(Color.BLACK);
                        }else {
                            //btnNext.setTextColor(getResources().getColor(R.color.colorText));
                            btnNext.setTextColor(Color.BLACK);
                        }
                        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            btnNext.setBackground(getResources().getDrawable(R.drawable.button_border_gray, null));
                        }else {
                            btnNext.setBackground(getResources().getDrawable(R.drawable.button_border_gray));
                        }*/


                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void addBottomDots(int currentPage) {
        dots = new TextView[images.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(45);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }




}

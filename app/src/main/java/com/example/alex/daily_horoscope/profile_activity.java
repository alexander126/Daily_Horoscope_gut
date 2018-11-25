/**
 * The profile_activity class is used for functionality
 * to the profile page of the Daily Horoscope Application
 *
 * @author Aleksandar Kalapsazov
 * @version 1.0
 * @since 2017-03-18
 */
package com.example.alex.daily_horoscope;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class profile_activity extends AppCompatActivity {
    //---Setting public proerty for variables inherited in Main Activity---//
    private Context cnt;
    public EditText editText;
    SharedPreferences m_Text;
    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;
    private TextView[] mDots;
    private SliderAdapter sliderAdapter;
    private Button backPage;
    private Button nextPage;
    private int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_activity);
        mSlideViewPager=(ViewPager)findViewById(R.id.slideViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.dotsLayout);
        sliderAdapter=new SliderAdapter(this);
        mSlideViewPager.setAdapter(sliderAdapter);
        backPage = (Button)findViewById(R.id.backButton);
        nextPage = (Button)findViewById(R.id.nextButton);

        //TODO: check this lines
        //set typeface for buttons ???
     /*   Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/AdventPro-Light.ttf");
        backPage.setTypeface(typeface);
        nextPage.setTypeface(typeface); */

        addDotsIndicator(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);

        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mCurrentPage==2){
                    startActivity(new Intent(profile_activity.this,carouselPicker.class));
                }else {
                    mSlideViewPager.setCurrentItem(mCurrentPage + 1);
                }

            }
        });
        backPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mCurrentPage!=0) {
                    mSlideViewPager.setCurrentItem(mCurrentPage - 1);
                }
            }
        });
    }
    public void addDotsIndicator(int position){
        mDots = new TextView[3];
        mDotLayout.removeAllViews();
        for (int i=0 ; i<mDots.length; i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
            mDotLayout.addView(mDots[i]);

        }

        if(mDots.length>0){
            mDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
            mCurrentPage = i;
            if(i==0){
                backPage.setVisibility(View.INVISIBLE);
            }else if(i==mDots.length-1){
                nextPage.setText("Finish");

            }else{
                backPage.setVisibility(View.VISIBLE);
                nextPage.setText("Next");
            }


        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
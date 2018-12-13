package com.example.alex.daily_horoscope;


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.ArrayList;
import java.util.List;

import in.goodiebag.carouselpicker.CarouselPicker;

public class carouselPicker extends AppCompatActivity {
    private CarouselPicker carouselPicker;
    private ImageButton enter;
    private TextView zodiacSign;
    private TextView choose;
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carousel_picker);

        final SharedPreferences sharedPref = getSharedPreferences("prefs",MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPref.edit();

        choose = (TextView)findViewById(R.id.choose);
        zodiacSign = (TextView)findViewById(R.id.unknownZ);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/AdventPro-Light.ttf");
        choose.setTypeface(typeface);

        carouselPicker = (CarouselPicker)findViewById(R.id.carouselPicker);
        enter = (ImageButton)findViewById(R.id.enter) ;

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        //carouselItems
        List<CarouselPicker.PickerItem> itemImages = new ArrayList<>();
        itemImages.add(new CarouselPicker.DrawableItem(R.drawable.aquarius));
        itemImages.add(new CarouselPicker.DrawableItem(R.drawable.pisces));
        itemImages.add(new CarouselPicker.DrawableItem(R.drawable.aries));
        itemImages.add(new CarouselPicker.DrawableItem(R.drawable.taurus));
        itemImages.add(new CarouselPicker.DrawableItem(R.drawable.gemini));
        itemImages.add(new CarouselPicker.DrawableItem(R.drawable.cancer));
        itemImages.add(new CarouselPicker.DrawableItem(R.drawable.leo));
        itemImages.add(new CarouselPicker.DrawableItem(R.drawable.virgo));
        itemImages.add(new CarouselPicker.DrawableItem(R.drawable.libra));
        itemImages.add(new CarouselPicker.DrawableItem(R.drawable.scorpio));
        itemImages.add(new CarouselPicker.DrawableItem(R.drawable.sagittarius));
        itemImages.add(new CarouselPicker.DrawableItem(R.drawable.capricorn));


        CarouselPicker.CarouselViewAdapter imageAdapter = new CarouselPicker.CarouselViewAdapter(this, itemImages ,0);
        carouselPicker.setAdapter(imageAdapter);
        carouselPicker.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(final int i) {
                enter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sharedPref.edit().putBoolean("my_first_time", false).commit();

                        if(i==0) {
                                startActivity(new Intent(carouselPicker.this, opening.class));
                                editor.putString("sign","aquarius");
                                editor.commit();
                                Bundle bundle = new Bundle();
                                bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "2");
                                bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "aquarius");
                                bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "sign");
                                mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
                            }
                            if(i==1) {
                                startActivity(new Intent(carouselPicker.this, opening.class));
                                editor.putString("sign","pisces");
                                editor.commit();
                                Bundle bundle = new Bundle();
                                bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "3");
                                bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "pisces");
                                bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "sign");
                                mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
                            }
                            if(i==2) {
                                startActivity(new Intent(carouselPicker.this, opening.class));
                                editor.putString("sign","aries");
                                editor.commit();
                                Bundle bundle = new Bundle();
                                bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "4");
                                bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "aries");
                                bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "sign");
                                mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
                            }
                            if(i==3) {
                                startActivity(new Intent(carouselPicker.this, opening.class));
                                editor.putString("sign","taurus");
                                editor.commit();
                                Bundle bundle = new Bundle();
                                bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "5");
                                bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "taurus");
                                bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "sign");
                                mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
                            }
                            if(i==4) {
                                startActivity(new Intent(carouselPicker.this, opening.class));
                                editor.putString("sign","gemini");
                                editor.commit();
                                Bundle bundle = new Bundle();
                                bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "6");
                                bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "gemini");
                                bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "sign");
                                mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
                            }
                            if(i==5) {
                                startActivity(new Intent(carouselPicker.this, opening.class));
                                editor.putString("sign","cancer");
                                editor.commit();
                                Bundle bundle = new Bundle();
                                bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "7");
                                bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "cancer");
                                bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "sign");
                                mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
                            }
                            if(i==6) {
                                startActivity(new Intent(carouselPicker.this, opening.class));
                                editor.putString("sign","leo");
                                editor.commit();
                                Bundle bundle = new Bundle();
                                bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "8");
                                bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "leo");
                                bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "sign");
                                mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
                            }
                            if(i==7) {
                                startActivity(new Intent(carouselPicker.this, opening.class));
                                editor.putString("sign","virgo");
                                editor.commit();
                                Bundle bundle = new Bundle();
                                bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "9");
                                bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "virgo");
                                bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "sign");
                                mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
                            }
                            if(i==8) {
                                startActivity(new Intent(carouselPicker.this, opening.class));
                                editor.putString("sign","libra");
                                editor.commit();
                                Bundle bundle = new Bundle();
                                bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "10");
                                bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "libra");
                                bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "sign");
                                mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
                            }
                            if(i==9) {
                                startActivity(new Intent(carouselPicker.this, opening.class));
                                editor.putString("sign","scorpio");
                                editor.commit();
                                Bundle bundle = new Bundle();
                                bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "11");
                                bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "scorpio");
                                bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "sign");
                                mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
                            }
                            if(i==10) {
                                startActivity(new Intent(carouselPicker.this, opening.class));
                                editor.putString("sign","sagittarius");
                                editor.commit();
                                Bundle bundle = new Bundle();
                                bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "12");
                                bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "sagittarius");
                                bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "sign");
                                mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
                            }
                            if(i==11) {
                                startActivity(new Intent(carouselPicker.this, opening.class));
                                editor.putString("sign","capricorn");
                                editor.commit();
                                Bundle bundle = new Bundle();
                                bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "13");
                                bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "capricorn");
                                bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "sign");
                                mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
                            }


                    }
                });

            }
            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        zodiacSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(carouselPicker.this, getString(R.string.zodiacDates  ), Toast.LENGTH_LONG).show();

            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME );
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}

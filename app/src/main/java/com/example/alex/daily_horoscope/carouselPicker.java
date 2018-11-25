package com.example.alex.daily_horoscope;


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import in.goodiebag.carouselpicker.CarouselPicker;

public class carouselPicker extends AppCompatActivity {
    private CarouselPicker carouselPicker;
    private Button enter;
    private TextView zodiacSign;
    private TextView choose;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carousel_picker);

        SharedPreferences sharedPref = getSharedPreferences("prefs",MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPref.edit();

        choose = (TextView)findViewById(R.id.choose);
        zodiacSign = (TextView)findViewById(R.id.unknownZ);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/AdventPro-Light.ttf");
        choose.setTypeface(typeface);

        carouselPicker = (CarouselPicker)findViewById(R.id.carouselPicker);
        enter = (Button)findViewById(R.id.enter) ;

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

                            if(i==0) {
                                startActivity(new Intent(carouselPicker.this, opening.class));
                                editor.putString("sign","aquarius");
                                editor.commit();
                            }
                            if(i==1) {
                                startActivity(new Intent(carouselPicker.this, opening.class));
                                editor.putString("sign","pisces");
                                editor.commit();
                            }
                            if(i==2) {
                                startActivity(new Intent(carouselPicker.this, opening.class));
                                editor.putString("sign","aries");
                                editor.commit();
                            }
                            if(i==3) {
                                startActivity(new Intent(carouselPicker.this, opening.class));
                                editor.putString("sign","taurus");
                                editor.commit();
                            }
                            if(i==4) {
                                startActivity(new Intent(carouselPicker.this, opening.class));
                                editor.putString("sign","gemini");
                                editor.commit();
                            }
                            if(i==5) {
                                startActivity(new Intent(carouselPicker.this, opening.class));
                                editor.putString("sign","cancer");
                                editor.commit();
                            }
                            if(i==6) {
                                startActivity(new Intent(carouselPicker.this, opening.class));
                                editor.putString("sign","leo");
                                editor.commit();
                            }
                            if(i==7) {
                                startActivity(new Intent(carouselPicker.this, opening.class));
                                editor.putString("sign","virgo");
                                editor.commit();
                            }
                            if(i==8) {
                                startActivity(new Intent(carouselPicker.this, opening.class));
                                editor.putString("sign","libra");
                                editor.commit();
                            }
                            if(i==9) {
                                startActivity(new Intent(carouselPicker.this, opening.class));
                                editor.putString("sign","scorpio");
                                editor.commit();
                            }
                            if(i==10) {
                                startActivity(new Intent(carouselPicker.this, opening.class));
                                editor.putString("sign","sagittarius");
                                editor.commit();
                            }
                            if(i==11) {
                                startActivity(new Intent(carouselPicker.this, opening.class));
                                editor.putString("sign","capricorn");
                                editor.commit();
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

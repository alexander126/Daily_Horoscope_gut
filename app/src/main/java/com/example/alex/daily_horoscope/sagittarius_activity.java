/**
 * The sagittarius_activity class is used for displaying
 * information provided from BasicZodiacActivity
 * about the specific zodiac sign.
 *
 *
 * @author  Aleksandar Kalapsazov
 * @version 1.0
 * @since   2017-03-18
 */
package com.example.alex.daily_horoscope;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class sagittarius_activity extends BasicZodiacActivity {

    @Override
    //---On create function which displays the formated string---//
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sagittarius_activity);
        String link = "https://www.cafeastrology.com/dailyhoroscopes/sagittariushorocode.php";
        super.loadHoroscope(link);
        ImageButton share = (ImageButton) findViewById(R.id.shareContent);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareLink();
            }
        });
    }
    protected int getRId() {
        return R.id.webViewSagittaius;
    }
}

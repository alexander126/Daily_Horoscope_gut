/**
 * The leo_activity class is used for displaying
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
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class leo_activity extends BasicZodiacActivity {

    @Override
    //---On create function which displays the formated string---//
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leo_activity);
        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        mAdView.loadAd(adRequest);
        MobileAds.initialize(this, "ca-app-pub-8629737007792498~8339643427");
        String link = "https://www.cafeastrology.com/dailyhoroscopes/leohorocode.php";
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
        return R.id.webViewLeo;
    }
}

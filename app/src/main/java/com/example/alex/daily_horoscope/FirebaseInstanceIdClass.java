package com.example.alex.daily_horoscope;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by alex on 14/11/2018.
 */

public class FirebaseInstanceIdClass extends FirebaseInstanceIdService {

        private static final String TAG = "MyFirebaseIIDService";
        @Override
        public void onTokenRefresh() {

            String refreshedToken = FirebaseInstanceId.getInstance().getToken();

            Log.d(TAG, "Refreshed token:" + refreshedToken);
        }
    }



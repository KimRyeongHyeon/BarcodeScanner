package com.myandroid.barcodescanner;

import android.app.Activity;
import android.widget.Toast;

public class BackPressCloseHandler {

    private long backpressTime = 0;
    private Activity activity;

    public BackPressCloseHandler(Activity activity) {
        this.activity = activity;
    }

    public void onBackPressed() {
        if(System.currentTimeMillis() > backpressTime + 2000) {
            backpressTime = System.currentTimeMillis();
            Toast.makeText(activity, "한 번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();

            return;
        } else if(System.currentTimeMillis() <= backpressTime + 2000) {
            activity.finishAffinity();
        }
    }
}

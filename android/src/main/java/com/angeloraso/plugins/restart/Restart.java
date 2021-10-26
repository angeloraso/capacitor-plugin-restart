package com.angeloraso.plugins.restart;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

public class Restart {

    private final Context mContext;
    private final AppCompatActivity mActivity;
    private RestartSettings mSettings;
    private boolean mRestarting = false;

    Restart(final AppCompatActivity activity, final Context context) {
        mActivity = activity;
        mContext = context;
        mSettings = new RestartSettings();
    }

    public void enable() {
        mSettings.setEnabled(true);
    }

    public boolean isEnabled() {
        return mSettings.isEnabled();
    }

    public void disable() {
        mSettings.setEnabled(false);
    }

    public void onStart() {
        if (!isEnabled() || !mRestarting) {
            return;
        }

        moveToBackground();
        mRestarting = false;
    }

    public void onDestroy() {
        if (!isEnabled() || mRestarting) {
            return;
        }

        mRestarting = true;
        restart();
    }

    private void moveToBackground() {
        try {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            mActivity.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void restart() {
        Intent mStartActivity = new Intent(mContext, mActivity.getClass());
        int mPendingIntentId = 123456;
        PendingIntent mPendingIntent = PendingIntent.getActivity(
            mContext,
            mPendingIntentId,
            mStartActivity,
            PendingIntent.FLAG_CANCEL_CURRENT
        );
        AlarmManager mgr = (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);
        mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 100, mPendingIntent);
        System.exit(0);
    }
}

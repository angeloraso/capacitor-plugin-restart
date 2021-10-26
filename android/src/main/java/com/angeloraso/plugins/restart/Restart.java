package com.angeloraso.plugins.restart;

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

    public void onResume() {
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
        openApp();
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

    private void openApp() {
        Intent intent = mContext.getPackageManager().getLaunchIntentForPackage(mContext.getPackageName());
        mActivity.startActivity(intent);
    }
}

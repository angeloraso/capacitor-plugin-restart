package com.angeloraso.plugins.restart;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "Restart")
public class RestartPlugin extends Plugin {

    private Restart restart;

    public void load() {
        AppCompatActivity activity = getActivity();
        Context context = getContext();
        restart = new Restart(activity, context);
    }

    @PluginMethod
    public void enable(PluginCall call) {
        restart.enable();
        call.resolve();
    }

    @PluginMethod
    public void disable(PluginCall call) {
        restart.disable();
        call.resolve();
    }

    /**
     * Called when the activity will start interacting with the user.
     */
    @Override
    public void handleOnResume() {
        restart.onResume();
    }

    /**
     * Called when the activity will be destroyed.
     */
    @Override
    public void handleOnDestroy() {
        restart.onDestroy();
    }
}

package com.angeloraso.plugins.restart;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import java.util.Timer;
import java.util.TimerTask;

@CapacitorPlugin(name = "Restart")
public class RestartPlugin extends Plugin {

    private Restart restart;

    private Restart test = null;

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

    /**
     * Called when the activity is becoming visible to the user
     */
    @Override
    protected void handleOnStart() {
        restart.onStart();
    }

    /**
     * Called when the activity is no longer visible to the user.
     */
    @Override
    public void handleOnStop() {
        if (getActivity().isFinishing() || getActivity().isDestroyed()) {
            restart.onDestroy();
        }
    }

    /**
     * Called when the activity will be destroyed.
     */
    @Override
    public void handleOnDestroy() {
        if (getActivity().isFinishing() || getActivity().isDestroyed()) {
            restart.onDestroy();
        }
    }
}


package sh.pixelbru;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;

public class RNPushTokenModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public RNPushTokenModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;

        registerNotificationsRegistration();
    }

    @Override
    public String getName() {
    return "RNPushTokenModule";
    }

    @ReactMethod
    public void getToken(Promise promise) {
        String token = RNPushTokenSingleton.getInstance().getDeviceToken();
        if (token.isEmpty()) promise.reject("Error", "Error");
        else promise.resolve(token);
    }

    private void registerNotificationsRegistration() {
        IntentFilter intentFilter = new IntentFilter(getReactApplicationContext().getPackageName() + ".RNPushTokenRegistered");

        getReactApplicationContext().registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String token = intent.getStringExtra("token");
                RNPushTokenSingleton.getInstance().setDeviceToken(token);
            }
        }, intentFilter);
    }
}

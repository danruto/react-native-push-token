
package sh.pixelbru;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Promise;

public class RNPushTokenModule extends ReactContextBaseJavaModule {

    private static final String TAG = "RNPushTokenModule";
    private final ReactApplicationContext reactContext;
    private String senderID;

    private static final String E_TOKEN_EMPTY = "E_TOKEN_EMPTY";

    public RNPushTokenModule(ReactApplicationContext reactContext, String senderID) {
        super(reactContext);
        this.reactContext = reactContext;
        this.senderID = senderID;

        registerNotificationsRegistration();
        registerService();
    }

    @Override
    public String getName() {
    return "RNPushToken";
    }

    @ReactMethod
    public void getToken(Promise promise) {
        String token = RNPushTokenSingleton.getInstance().getDeviceToken();
        if (token == null || token.isEmpty()) promise.reject(E_TOKEN_EMPTY, "Error");
        else promise.resolve(token);
    }

    private void registerNotificationsRegistration() {
        IntentFilter intentFilter = new IntentFilter(getReactApplicationContext().getPackageName() + ".RNPushTokenRegistered");

        getReactApplicationContext().registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(getReactApplicationContext(), "Got the token", Toast.LENGTH_LONG);
                String token = intent.getStringExtra("token");
                Log.d(TAG, token);
                RNPushTokenSingleton.getInstance().setDeviceToken(token);
            }
        }, intentFilter);
    }

    private void registerService() {
        ReactApplicationContext context = getReactApplicationContext();
        Intent GCMService = new Intent(context, RNPushTokenService.class);
        GCMService.putExtra("senderID", this.senderID);
        context.startService(GCMService);
    }
}

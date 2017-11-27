
package sh.pixelbru;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

public class RNTokenModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNTokenModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;

    registerNotificationsRegistration();
  }

  @Override
  public String getName() {
    return "RNPushToken";
  }

  private void registerNotificationsRegistration() {
        IntentFilter intentFilter = new IntentFilter(getReactApplicationContext().getPackageName() + ".RNPushTokenRegistered");

        getReactApplicationContext().registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String token = intent.getStringExtra("token");
                WritableMap params = Arguments.createMap();
                params.putString("deviceToken", token);

                mJsDelivery.sendEvent("RNPushTokenReceived", params);
            }
        }, intentFilter);
    }
}
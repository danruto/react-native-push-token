
package sh.pixelbru;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;

public class RNPushTokenModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;
  private String mDeviceToken = "";

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
  public String getToken(Promise promise) {
    if (mDeviceToken.isEmpty()) promise.reject();
    else promise.resolve(mDeviceToken);
  }

  private void registerNotificationsRegistration() {
        IntentFilter intentFilter = new IntentFilter(getReactApplicationContext().getPackageName() + ".RNPushTokenRegistered");

        getReactApplicationContext().registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String token = intent.getStringExtra("token");
                this.mDeviceToken = token;
            }
        }, intentFilter);
    }
}
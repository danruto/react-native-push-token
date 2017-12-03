package sh.pixelbru;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;


/**
 * Created by danny on 1/12/17.
 */

public class RNPushTokenService extends IntentService {
    private static final String TAG = "RNPushTokenService";

    public RNPushTokenService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            String SenderID = intent.getStringExtra("senderID");
            InstanceID instanceID = InstanceID.getInstance(this);
            String token = instanceID.getToken(SenderID,
                    GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);
            sendRegistrationToken(token);
        } catch (Exception e) {
            Log.e(TAG, TAG + " failed to process intent " + intent, e);
        }
    }

    private void sendRegistrationToken(String token) {
        Intent intent = new Intent(this.getPackageName() + ".RNPushTokenRegistered");
        intent.putExtra("token", token);
        sendBroadcast(intent);
    }
}

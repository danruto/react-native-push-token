package sh.pixelbru;

/**
 * Created by danny on 1/12/17.
 */

public class RNPushTokenSingleton {
    private static RNPushTokenSingleton instance;
    private String deviceToken;

    private RNPushTokenSingleton(){}

    public static synchronized RNPushTokenSingleton getInstance() {
        if (instance == null) {
            instance = new RNPushTokenSingleton();
        }

        return instance;
    }

    public String getDeviceToken() { return deviceToken; }
    public void setDeviceToken(String value) { this.deviceToken = value; }
}

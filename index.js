
import { NativeModules, NativeEventEmitter } from 'react-native';

const { RNPushToken } = NativeModules;

const RNPushNotificationReceivedBridgeEvent = 'RNPushTokenReceived';
const tokenEmitter = new NativeEventEmitter(RNPushToken);

const addListener = (onRegister) => {
    tokenEmitter.addListener(
        RNPushNotificationReceivedBridgeEvent,
        (userInfo) => onRegister(userInfo.deviceToken)
    );
};

export default addListener;

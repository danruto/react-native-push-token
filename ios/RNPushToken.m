
#import "RNPushToken.h"

@implementation RNPushToken

NSString *const RNPushNotificationReceived = @"RNPushNotificationReceived";
NSString *const RNPushNotificationReceivedBridgeEvent = @"RNPushTokenReceived";

RCT_EXPORT_MODULE()

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}

- (NSArray<NSString *> *)supportedEvents
{
    return @[RNPushNotificationReceivedBridgeEvent];
}

- (void)startObserving
{
    [[NSNotificationCenter defaultCenter]   addObserver:self
                                            selector:@selector(handleRemoteNotificationsRegistered:)
                                            name:RNPushNotificationReceived
                                            object:nil];
}

- (void)stopObserving
{
    [[NSNotificationCenter defaultCenter] removeObserver:self];
}

- (void)handleRemoteNotificationsRegistered:(NSNotification *)notification
{
    [self sendEventWithName:RNPushNotificationReceivedBridgeEvent body:notification.userInfo];
}

+ (void)didRegisterForRemoteNotificationsWithDeviceToken:(NSData *)deviceToken
{
    NSMutableString *hexString = [NSMutableString string];
    NSUInteger deviceTokenLength = deviceToken.length;
    const unsigned char *bytes = deviceToken.bytes;
    for (NSUInteger i = 0; i < deviceTokenLength; i++) {
        [hexString appendFormat:@"%02x", bytes[i]];
    }
    
    // Delay notification as this library is not the one that sets up push notifications so it may not be in memory yet
    dispatch_after(dispatch_time(DISPATCH_TIME_NOW, (int64_t)(3.0 * NSEC_PER_SEC)), dispatch_get_main_queue(), ^{
        [[NSNotificationCenter defaultCenter] postNotificationName:RNPushNotificationReceived
                                              object:self
                                              userInfo:@{@"deviceToken" : [hexString copy]}];
    });

}
     
@end

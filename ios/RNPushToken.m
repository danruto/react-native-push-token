
#import "RNPushToken.h"

@implementation RNPushToken

NSString *const RNPushNotificationReceived = @"RNPushNotificationReceived";

RCT_EXPORT_MODULE()

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}

- (NSArray<NSString *> *)supportedEvents
{
    return @[@"RNPushTokenReceived"];
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
    [self sendEventWithName:@"RNPushTokenReceived" body:notification.userInfo];
}

+ (void)didRegisterForRemoteNotificationsWithDeviceToken:(NSData *)deviceToken
{
    NSMutableString *hexString = [NSMutableString string];
    NSUInteger deviceTokenLength = deviceToken.length;
    const unsigned char *bytes = deviceToken.bytes;
    for (NSUInteger i = 0; i < deviceTokenLength; i++) {
        [hexString appendFormat:@"%02x", bytes[i]];
    }
    [[NSNotificationCenter defaultCenter] postNotificationName:RNPushNotificationReceived
                                          object:self
                                          userInfo:@{@"deviceToken" : [hexString copy]}];
}
     
@end

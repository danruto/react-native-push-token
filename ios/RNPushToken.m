
#import "RNPushToken.h"
#import "RNPushTokenSingleton.h"

@implementation RNPushToken

RCT_EXPORT_MODULE()

+ (void)didRegisterForRemoteNotificationsWithDeviceToken:(NSData *)deviceToken
{
    [[RNPushTokenSingleton sharedManager] didRegisterForRemoteNotificationsWithDeviceToken:deviceToken];
}
     
RCT_REMAP_METHOD(getToken,
                 getTokenWithResolver:(RCTPromiseResolveBlock)resolve
                 getTokenWithRejecter:(RCTPromiseRejectBlock)reject)
{
    RNPushTokenSingleton *sharedManager = [RNPushTokenSingleton sharedManager];
    NSString *dt = [sharedManager deviceToken];
    if ([dt length] == 0) reject(@"Error", @"Error", nil);
    else resolve(dt);
}

@end

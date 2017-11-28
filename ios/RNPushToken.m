
#import "RNPushToken.h"
#import "RNPushTokenSingleton.h"

@implementation RNPushToken

RCT_EXPORT_MODULE()

+ (void)didRegisterForRemoteNotificationsWithDeviceToken:(NSData *)deviceToken
{
    [[RNPushTokenSingleton sharedManager] didRegisterForRemoteNotificationsWithDeviceToken:deviceToken];
}
     
RCT_REMAP_METHOD(getToken,
                 resolver:(RCTPromiseResolveBlock)resolve
                 rejecter:(RCTPromiseRejectBlock)reject)
{
    NSString *dt = [[RNPushToken sharedManager] deviceToken];
    if ([dt length] == 0) reject(@"Error", @"Error", nil);
    return resolve(dt);
}

@end

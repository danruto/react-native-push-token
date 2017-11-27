
#if __has_include("RCTBridgeModule.h")
#import "RCTBridgeModule.h"
#import "RCTEventEmitter.h"
#else
#import <React/RCTBridgeModule.h>
#import <React/RCTEventEmitter.h>
#endif

extern NSString *const RNPushNotificationReceived;

@interface RNPushToken : RCTEventEmitter <RCTBridgeModule>

+ (void)didRegisterForRemoteNotificationsWithDeviceToken:(NSData *)deviceToken;

@end
  

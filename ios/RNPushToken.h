
#if __has_include("RCTBridgeModule.h")
#import "RCTBridgeModule.h"
#else
#import <React/RCTBridgeModule.h>
#endif

@interface RNPushToken : NSObject <RCTBridgeModule>

+ (void)didRegisterForRemoteNotificationsWithDeviceToken:(NSData *)deviceToken;

@end
  

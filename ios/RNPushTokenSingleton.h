#import <foundation/Foundation.h>

@interface RNPushTokenSingleton : NSObject {
    NSString *deviceToken;
}

@property (nonatomic, retain) NSString *deviceToken;

+ (id)sharedManager;

@end
  

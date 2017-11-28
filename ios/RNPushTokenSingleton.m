
#import "RNPushTokenSingleton.h"

@implementation RNPushTokenSingleton

@synthesize deviceToken;

#pragma mark Singleton Methods

+ (id)sharedManager {
    static RNPushTokenSingleton *sharedMyManager = nil;
    static dispatch_once_t onceToken;
    dispatch_once(&onceToken, ^{
        sharedMyManager = [[self alloc] init];
    });
    return sharedMyManager;
}

- (id)init {
    if (self = [super init]) {
        deviceToken = @"";
    }
    return self;
}

- (void)dealloc {
    // Should never be called, but just here for clarity really.
}

- (void)didRegisterForRemoteNotificationsWithDeviceToken:(NSData *)deviceToken
{
    NSMutableString *hexString = [NSMutableString string];
    NSUInteger deviceTokenLength = deviceToken.length;
    const unsigned char *bytes = deviceToken.bytes;
    for (NSUInteger i = 0; i < deviceTokenLength; i++) {
        [hexString appendFormat:@"%02x", bytes[i]];
    }
    
    deviceToken = [hexString copy];
}

@end

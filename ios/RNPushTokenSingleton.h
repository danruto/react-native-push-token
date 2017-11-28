
@interface RNPushTokenSingleton : NSObject {
    NSString *deviceToken;
}

@property (nonatomic, retain) NSString *deviceToken;

+ (id)sharedManager;

@end
  

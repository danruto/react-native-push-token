
# react-native-push-token

## Getting started

`$ npm install react-native-push-token --save`
or
`$ yarn add react-native-push-token`

### Mostly automatic installation

`$ react-native link react-native-push-token`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-push-token` and add `RNReactNativePushToken.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNReactNativePushToken.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Add the following snippet to your `AppDelegate.m`
```
#import <RNPushToken.h>
...

- (void)application:(UIApplication *)app didRegisterForRemoteNotificationsWithDeviceToken:(NSData *)deviceToken
{
  [RNPushToken didRegisterForRemoteNotificationsWithDeviceToken:deviceToken];
}
```
5. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNPushTokenPackage;` to the imports at the top of the file
  - Add `new RNPushTokenPackage()` to the list returned by the `getPackages()` method with the senderID e.g. `new RNPushTokenPackage(getApplicationContext().getString(R.string.senderID)),`
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-push-token'
  	project(':react-native-push-token').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-push-token/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-push-token')
  	```
4. Add the following to the android manifest
    ```
      <service android:name="sh.pixelbru.RNPushTokenService" />
    ```

NOTE: You may need to set a specific gcm/firebase version to your app's build.grade to ensure all versions across your deps are the same e.g.
    ```
    compile ('com.google.firebase:firebase-messaging:11.0.2') {
        force = true
    }
    compile('com.google.android.gms:play-services-gcm:11.0.2') {
        force = true
    }
    ```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNPushToken.sln` in `node_modules/react-native-push-token/windows/RNPushToken.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using React.Native.Push.Token.RNPushToken;` to the usings at the top of the file
  - Add `new RNPushTokenPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNPushToken from 'react-native-push-token';

try {
  const token = await RNPushToken.getToken();
} catch (error) {
  console.error(error);
}
```
  
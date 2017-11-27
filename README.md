
# react-native-push-token

## Getting started

`$ npm install react-native-push-token --save`

### Mostly automatic installation

`$ react-native link react-native-push-token`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-push-token` and add `RNReactNativePushToken.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNReactNativePushToken.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNReactNativePushTokenPackage;` to the imports at the top of the file
  - Add `new RNReactNativePushTokenPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-push-token'
  	project(':react-native-push-token').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-push-token/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-push-token')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNReactNativePushToken.sln` in `node_modules/react-native-push-token/windows/RNReactNativePushToken.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using React.Native.Push.Token.RNReactNativePushToken;` to the usings at the top of the file
  - Add `new RNReactNativePushTokenPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNReactNativePushToken from 'react-native-push-token';

// TODO: What to do with the module?
RNReactNativePushToken;
```
  
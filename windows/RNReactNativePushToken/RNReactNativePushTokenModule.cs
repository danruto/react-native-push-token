using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace React.Native.Push.Token.RNReactNativePushToken
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNReactNativePushTokenModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNReactNativePushTokenModule"/>.
        /// </summary>
        internal RNReactNativePushTokenModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNReactNativePushToken";
            }
        }
    }
}

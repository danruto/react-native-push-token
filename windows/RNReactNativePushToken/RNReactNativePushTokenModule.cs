using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace React.Native.Push.Token.RNPushToken
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNPushTokenModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNPushTokenModule"/>.
        /// </summary>
        internal RNPushTokenModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNPushToken";
            }
        }
    }
}

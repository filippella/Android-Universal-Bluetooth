package org.dalol.universalbluetooth.api

import android.os.Handler

/**
 * @author Filippo
 * @version 1.0.0
 * @since Wed, 26/12/2018 at 21:47.
 */
class IBluetoothOperation constructor(handler: Handler) {

    fun onOperationUpdate() {}
    fun onOperationComplete() {}
}
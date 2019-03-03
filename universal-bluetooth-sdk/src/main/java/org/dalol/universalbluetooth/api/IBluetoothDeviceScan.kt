package org.dalol.universalbluetooth.api

/**
 * @author Filippo
 * @version 1.0.0
 * @since Wed, 26/12/2018 at 21:01.
 */
interface IBluetoothDeviceScan {

    fun isBluetoothEnabled() : Boolean

    fun switchBluetooth(on : Boolean)

    fun startDeviceScan() : Boolean

    fun isScanningDevice() : Boolean

    fun stopDeviceScan() : Boolean

    fun close()
}
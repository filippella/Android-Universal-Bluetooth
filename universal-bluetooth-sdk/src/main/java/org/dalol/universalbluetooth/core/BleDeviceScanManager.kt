package org.dalol.universalbluetooth.core

import org.dalol.universalbluetooth.api.IBluetoothDeviceScan

/**
 * @author Filippo Engidashet
 * @version 1.0.0
 * @since Wed, 26/12/2018 at 22:16.
 */
class BleDeviceScanManager : IBluetoothDeviceScan {

    override fun isBluetoothEnabled(): Boolean {

    }

    override fun switchBluetooth(on: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun startDeviceScan(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isScanningDevice(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun stopDeviceScan(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun close() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
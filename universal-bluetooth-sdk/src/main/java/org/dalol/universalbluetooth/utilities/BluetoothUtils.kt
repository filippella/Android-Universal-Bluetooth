package org.dalol.universalbluetooth.utilities

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.text.TextUtils

/**
 * @author Filippo
 * @version 1.0.0
 * @since Wed, 26/12/2018 at 22:18.
 */
@Suppress("UNCHECKED_CAST")
object BluetoothUtils {

    @JvmStatic
    fun isBluetoothSupported(context: Context): Boolean {
        return context.packageManager.hasSystemFeature(
            PackageManager.FEATURE_BLUETOOTH
        )
    }

    @JvmStatic
    fun isBleSupported(context: Context): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2 && context.packageManager.hasSystemFeature(
            PackageManager.FEATURE_BLUETOOTH_LE
        )
    }

    @JvmStatic
    fun getBluetoothManager(context: Context): BluetoothManager? {
        return if (isBleSupported(context)) {
            context.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        } else null
    }

    @JvmStatic
    fun getBluetoothAdapter(context: Context): BluetoothAdapter? {
        var bluetoothAdapter: BluetoothAdapter? = null
        val bluetoothManager = getBluetoothManager(context)
        if (bluetoothManager != null) {
            bluetoothAdapter = bluetoothManager.adapter
        }
        return bluetoothAdapter
    }

    @JvmStatic
    fun switchBluetooth(context: Context, enable: Boolean): Boolean {
        var result = false
        if (isBleSupported(context)) {
            val bluetoothAdapter = getBluetoothAdapter(context)
            if (bluetoothAdapter != null) {
                result = if (enable) {
                    bluetoothAdapter.enable()
                } else {
                    bluetoothAdapter.disable()
                }
            }
        }
        return result
    }

    @JvmStatic
    fun findDeviceByAddress(bluetoothAdapter: BluetoothAdapter?, deviceAddress: String): BluetoothDevice? {
        return if (bluetoothAdapter == null || TextUtils.isEmpty(deviceAddress)) null else bluetoothAdapter.getRemoteDevice(
            deviceAddress
        )
    }

    @JvmStatic
    fun discoverServices(bluetoothGatt: BluetoothGatt?): Boolean {
        var result = false
        if (bluetoothGatt != null) {
            result = bluetoothGatt.discoverServices()
        }
        return result
    }

    @JvmStatic
    fun readRemoteRssi(bluetoothGatt: BluetoothGatt?): Boolean {
        var result = false
        if (bluetoothGatt != null) {
            result = bluetoothGatt.readRemoteRssi()
        }
        return result
    }

    @JvmStatic
    fun refreshGattCache(bluetoothGatt: BluetoothGatt?): Boolean {
        var result = false
        try {
            val refresh = BluetoothGatt::class.java.getMethod("refresh")
            if (bluetoothGatt != null) {
                refresh.isAccessible = true
                result = refresh.invoke(bluetoothGatt) as Boolean
                println("gatt.refresh(): $result")
            }
        } catch (e: Exception) {
            println("gatt.refresh()\n $e")
        }

        return result
    }
}
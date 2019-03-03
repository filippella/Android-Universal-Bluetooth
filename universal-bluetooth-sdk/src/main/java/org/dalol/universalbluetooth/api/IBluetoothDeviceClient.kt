package org.dalol.universalbluetooth.api

/**
 * @author Filippo
 * @version 1.0.0
 * @since Wed, 26/12/2018 at 20:39.
 */
interface IBluetoothDeviceClient {

    fun connect(address: String): Int

    fun discoverServices(): Boolean

    fun cancelDiscovery(): Boolean

    fun getService(Uuid: String): IBluetoothService

    fun getServices(): List<IBluetoothService>

    fun queueCommand(command: IBluetoothCommand)

    fun read(serviceUuid: String, characteristicUuid: String)

    fun write(serviceUuid: String, characteristicUuid: String, value: ByteArray, noResponse: Boolean)

    fun notify(serviceUuid: String, characteristicUuid: String)

    fun unnotify(serviceUuid: String, characteristicUuid: String)

    fun indicate(serviceUuid: String, characteristicUuid: String)

    fun unindicate(serviceUuid: String, characteristicUuid: String)

    fun readDescriptor(serviceUuid: String, characteristicUuid: String, descriptor: String)

    fun writeDescriptor(serviceUuid: String, characteristicUuid: String, descriptor: String, value: ByteArray)

    fun readRssi(): Boolean

    fun requestMtu(mtu: Int)

    fun refreshCache(): Boolean
    
    fun flush()

    fun disconnect(): Int
}
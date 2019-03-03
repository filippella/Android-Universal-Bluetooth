package org.dalol.universalbluetooth.base;

/**
 * @author Filippo Engidashet
 * @version 1.0.0
 * @since Sun, 10/02/2019 at 22:25.
 */
public interface BluetoothDeviceScan {

    boolean isBluetoothEnabled();

    void switchBluetooth(boolean on);

    boolean startDeviceScan();

    boolean isScanningDevice();

    boolean stopDeviceScan();

    void close();
}


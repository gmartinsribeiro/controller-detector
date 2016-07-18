package com.aptoide.controller_detector.lib.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.os.Parcelable;

/**
 * Created by franciscofariaaleixo on 16/07/2016.
 */
public interface BluetoothConnectivityHandler {

    void handleBtPairing(BluetoothDevice device, DeviceInputType type);

    void handleBtUnpairing(BluetoothDevice device, DeviceInputType type);

    void handleBtInputConnect(BluetoothDevice device, DeviceInputType type);

    void handleBtInputDisconnect(BluetoothDevice device, DeviceInputType type);

    void handleBtFound(BluetoothDevice device, DeviceInputType type);


}

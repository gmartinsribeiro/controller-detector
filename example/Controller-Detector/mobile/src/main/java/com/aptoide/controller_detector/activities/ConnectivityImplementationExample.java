package com.aptoide.controller_detector.activities;

import android.bluetooth.BluetoothDevice;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbDevice;

import com.aptoide.controller_detector.lib.bluetooth.BluetoothConnectivityHandler;
import com.aptoide.controller_detector.lib.bluetooth.DeviceInputType;
import com.aptoide.controller_detector.lib.usb.UsbConnectivityHandler;

/**
 * Created by franciscofariaaleixo on 17/07/2016.
 */
public class ConnectivityImplementationExample implements BluetoothConnectivityHandler, UsbConnectivityHandler {


    @Override
    public void handleBtPairing(BluetoothDevice device, DeviceInputType type) {
        // ...
    }

    @Override
    public void handleBtUnpairing(BluetoothDevice device, DeviceInputType type) {
        // ...
    }

    @Override
    public void handleBtInputConnect(BluetoothDevice device, DeviceInputType type) {
        // ...
    }

    @Override
    public void handleBtInputDisconnect(BluetoothDevice device, DeviceInputType type) {
        // ...
    }

    @Override
    public void handleBtFound(BluetoothDevice device, DeviceInputType type) {
        // ...
    }

    @Override
    public void handleUsbDeviceAttach(UsbDevice device) {
        // ...
    }

    @Override
    public void handleUsbDeviceDetach(UsbDevice device) {
        // ...
    }

    @Override
    public void handleUsbAccessoryAttach(UsbAccessory device) {
        // ...
    }

    @Override
    public void handleUsbAccessoryDetach(UsbAccessory device) {
        // ...
    }
}

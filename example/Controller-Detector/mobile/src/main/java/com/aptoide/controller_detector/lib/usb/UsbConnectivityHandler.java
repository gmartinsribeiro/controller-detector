package com.aptoide.controller_detector.lib.usb;

import android.bluetooth.BluetoothDevice;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbDevice;

/**
 * Created by franciscofariaaleixo on 16/07/2016.
 */
public interface UsbConnectivityHandler {

    void handleUsbDeviceAttach(UsbDevice device);

    void handleUsbDeviceDetach(UsbDevice device);

    void handleUsbAccessoryAttach(UsbAccessory device);

    void handleUsbAccessoryDetach(UsbAccessory device);


}

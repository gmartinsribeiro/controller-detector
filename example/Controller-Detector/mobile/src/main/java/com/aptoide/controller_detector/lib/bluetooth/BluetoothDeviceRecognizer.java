package com.aptoide.controller_detector.lib.bluetooth;

import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;

/**
 * Created by franciscofariaaleixo on 17/07/2016.
 */
public class BluetoothDeviceRecognizer {

    public static DeviceInputType recognizeDevice(BluetoothDevice device){

        int deviceMajorClass = device.getBluetoothClass().getMajorDeviceClass();
        if(deviceMajorClass != BluetoothClass.Device.Major.UNCATEGORIZED){
            // First pass is a CoD reconnaisance
            // For now only takes into consideration Peripheral and Not Keyboard/ Not Pointing Device
            if(deviceMajorClass == BluetoothClass.Device.Major.PERIPHERAL){
                return getPeripheralType(device.getBluetoothClass().getDeviceClass());
            }
        }
        else{
            // Second pass - Manufactuter's database
            return null;
        }
        return null;
    }

    private static DeviceInputType getPeripheralType(int deviceClass){
        int initialClass = 0x500;
        for(int i = 0; i<7; i++){
            int iClass = initialClass + (0x4*i);
            if(iClass == deviceClass){
                return DeviceInputType.values()[i];
            }
        }
        return DeviceInputType.UNCATEGORIZED;
    }
}

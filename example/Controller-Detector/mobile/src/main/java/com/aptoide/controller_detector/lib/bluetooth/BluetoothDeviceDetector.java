package com.aptoide.controller_detector.lib.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;

/**
 * Created by franciscofariaaleixo on 13-07-2016.
 */
public class BluetoothDeviceDetector extends ContextWrapper {

    private BluetoothConnectivityHandler handler;

    public BluetoothDeviceDetector(Context context,  BluetoothConnectivityHandler handler){
        super(context);
        this.handler = handler;
    }

    public void startDetectingDevices(){
        IntentFilter filter = new IntentFilter();
        filter.addAction(BluetoothDevice.ACTION_ACL_CONNECTED);
        filter.addAction(BluetoothDevice.ACTION_UUID);
        filter.addAction(BluetoothDevice.ACTION_ACL_DISCONNECT_REQUESTED);
        filter.addAction(BluetoothDevice.ACTION_ACL_DISCONNECTED);
        filter.addAction(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
        filter.addAction(BluetoothDevice.ACTION_CLASS_CHANGED);
        filter.addAction(BluetoothDevice.ACTION_FOUND);
        filter.addAction(BluetoothDevice.ACTION_NAME_CHANGED);
        filter.addAction(BluetoothDevice.ACTION_PAIRING_REQUEST);
        registerReceiver(bluetoothDetector, filter);
    }

    public void stopDetectingBluetoothDevices(){
        unregisterReceiver(bluetoothDetector);
    }


    // Other actions: ACTION_UUID; ACTION_ACL_DISCONNECT_REQUESTED; ACTION_CLASS_CHANGED
    //                ACTION_CLASS_CHANGED; ACTION_NAME_CHANGED; ACTION_PAIRING_REQUEST
    private final BroadcastReceiver bluetoothDetector = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            DeviceInputType type = BluetoothDeviceRecognizer.recognizeDevice(device);

            if(action.equals(BluetoothDevice.ACTION_ACL_CONNECTED)){
                handler.handleBtInputConnect(device, type);
            }
            else if (action.equals(BluetoothDevice.ACTION_ACL_DISCONNECTED)){
                handler.handleBtInputDisconnect(device, type);
            }
            else if (action.equals(BluetoothDevice.ACTION_BOND_STATE_CHANGED)){
                int bondState = device.getBondState();
                if(bondState == BluetoothDevice.BOND_NONE){
                    handler.handleBtPairing(device, type);
                } else if (bondState == BluetoothDevice.BOND_BONDED){
                    handler.handleBtUnpairing(device, type);
                }
            }
            else if (action.equals(BluetoothDevice.ACTION_FOUND)){
                handler.handleBtFound(device, type);
            }
        }
    };
}

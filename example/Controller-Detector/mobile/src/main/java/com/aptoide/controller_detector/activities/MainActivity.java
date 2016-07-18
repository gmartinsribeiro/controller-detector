package com.aptoide.controller_detector.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aptoide.controller_detector.R;
import com.aptoide.controller_detector.lib.bluetooth.BluetoothDeviceDetector;

public class MainActivity extends AppCompatActivity {

    BluetoothDeviceDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectivityImplementationExample handler = new ConnectivityImplementationExample();
        detector = new BluetoothDeviceDetector(MainActivity.this, handler);
        detector.startDetectingDevices();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        detector.stopDetectingBluetoothDevices();
    }
}

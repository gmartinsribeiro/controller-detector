# Controller Detector
Detect and recognize Bluetooth and USB controllers and receive feedback based on connectivity changes.

## How to
Apart from this 'How to', a complete example can be found on /example.

**Note:** This is simply an 'How to' of the current test version for feedback purposes, so it is very susceptible to change.

### Bluetooth
To implement Bluetooth detection you must create a BluetoothDeviceDetector object and call startDetectingDevices() method on onCreate() and stopDetectingBluetoothDevices() on onDestroy(), these registers and unregisters the BroadcastReceiver.

To create a BluetoothDeviceDetector object however, you need to pass the activity context and a implementation of the  BluetoothConnectivityHandler interface (represented as ConnectivityImplementationExample).

```java
public class MainActivity extends AppCompatActivity {
    private BluetoothDeviceDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        (...)
        ConnectivityImplementationExample handler = new ConnectivityImplementationExample();
        detector = new BluetoothDeviceDetector(MainActivity.this, handler);
        detector.startDetectingDevices();
        (...)
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        detector.stopDetectingBluetoothDevices();
        (...)
    }
}
```

You can of course combine both interfaces for convenience to serve as a single listener for both USB and Bluetooth connectivity changes.

```java
public class ConnectivityImplementationExample implements BluetoothConnectivityHandler, UsbConnectivityHandler {
  //...
}
```

# Controller Detector
Detect and recognize Bluetooth and USB controllers and receive feedback based on connectivity changes.

## Usage
Apart from this section, a complete example can be found on /example.

**Note:** This is simply an 'How to' of the current test version for feedback purposes, so it is very susceptible to change.
    
To implement Bluetooth and USB detection you must create the correspondent DeviceDetectors objects and call startDetectingDevices() method on onCreate() and stopDetectingDevices() on onDestroy(), these registers and unregisters the BroadcastReceivers.

To create a DeviceDetector object however, you need to pass the activity context and a implementation of the  ConnectivityHandler interface (represented below as ConnectivityImplementationExample).

```java
public class MainActivity extends AppCompatActivity {
    private BluetoothDeviceDetector btDetector;
    private UsbDeviceDetector usbDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        (...)
        ConnectivityImplementationExample handler = new ConnectivityImplementationExample();
        btDetector = new BluetoothDeviceDetector(MainActivity.this, handler);
        usbDetector = new UsbDeviceDetector(MainActivity.this, handler);
        btDetector.startDetectingDevices();
        usbDetector.startDetectingDevices();
        (...)
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        (...)
        btDetector.stopDetectingBluetoothDevices();
        usbDetector.stopDetectingUsbDevices();
        (...)
    }
}
```

You can of course combine both interfaces for convenience to serve as a single listener for both USB and Bluetooth connectivity changes.

```java
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
```

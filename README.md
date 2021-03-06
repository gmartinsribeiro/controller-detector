# Controller Detector

![alt tag](https://travis-ci.org/gmartinsribeiro/controller-detector.svg?branch=master)

Detect and recognize input controllers (HID) and receive feedback based on connectivity changes.

## Installation
You can easily install this module using JCenter or Maven, by adding the following dependency to your build.gradle file:

```java
dependencies {
 compile 'com.aptoide.pt:controller-detector:1.0.0'
 //...
}
```

## Usage
Apart from this section, a complete example can be downloaded from this repo.

You need to create a InputDeviceConnector object and implement ControllerListener interface.
For InputDeviceConnector you also need to:
 - Implement startDetectingDevices() to start detecting controllers (e.g. onCreate).
 - Implement stopDetectingDevices() to stop detecting controllers (e.g. onDestroy).


```java
public class MainActivity extends AppCompatActivity implements ControllerListener {
    private InputDeviceConnector connector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // ...
        connector = new InputDeviceConnector(getApplicationContext(), this);
        connector.startDetectingDevices();
        // ...
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        // ...
        connector.stopDetectingDevices();
        // ...
    }
    
    @Override
    public void onControllerChange(DeviceController controller) {
        // ...
    }

    @Override
    public void onControllerConnect(DeviceController controller) {
        // ...
    }

    @Override
    public void onControllerDisconnect(int id) {
        // ...
    }
}
```

Notice onControllerDisconnect only an id is passed since the Device has been disconnected. This is the same id that you retrieve from DeviceController.getDevice().getId().


## DeviceController
DeviceController defines two useful attributes that you can retrieve: an InputDevice and a DeviceInputType (enum).

For InputDevice you can read further [here.](https://developer.android.com/reference/android/view/InputDevice.html)

For DeviceInputType, it defines the following values: DPAD, GAMEPAD, KEYBOARD, MOUSE, STYLUS, TOUCHPAD, TOUCHSCREEN, TRACKBALL, TVREMOTE, UNRECOGNIZED

## Tested Devices
An analysis of several devices was made in order to check the correctness of the recognition algorithm. This analysis and the list of confirmed supported devices is [here.](https://docs.google.com/document/d/1Vw1gcduL2oMhtW0se3IvQIH8wanySyLB3CMG4A1ZHpg)

package com.aptoide.controllerdetector;

import android.hardware.input.InputManager;
import android.view.InputDevice;

/**
 * Created by franciscofariaaleixo on 18-07-2016.
 */
public class DeviceListener implements InputManager.InputDeviceListener {
    private ControllerListener listener;

    public DeviceListener(ControllerListener listener){
        this.listener = listener;
    }

    @Override
    public void onInputDeviceAdded(int i) {
        InputDevice dev = InputDevice.getDevice(i);
        DeviceController controller = new DeviceController(DeviceRecognizer.getDeviceInputType(dev), dev);
        listener.onControllerConnect(controller);
    }

    @Override
    public void onInputDeviceRemoved(int i) {
        listener.onControllerDisconnect(i);

    }

    @Override
    public void onInputDeviceChanged(int i) {
        InputDevice dev = InputDevice.getDevice(i);
        DeviceController controller = new DeviceController(DeviceRecognizer.getDeviceInputType(dev), dev);
        listener.onControllerChange(controller);
    }

}

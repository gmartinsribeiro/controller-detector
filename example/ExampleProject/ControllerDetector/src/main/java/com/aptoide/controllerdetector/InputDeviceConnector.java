package com.aptoide.controllerdetector;

import android.content.Context;
import android.hardware.input.InputManager;
import android.view.InputDevice;

import java.util.ArrayList;

/**
 * Created by franciscofariaaleixo on 18-07-2016.
 */
public class InputDeviceConnector {

    private InputManager manager;
    private DeviceListener listener;

    public InputDeviceConnector(Context context, ControllerListener cListener){
        manager = (InputManager) context.getSystemService(Context.INPUT_SERVICE);
        listener = new DeviceListener(cListener);
    }

    public void startDetectingDevices(){
        manager.registerInputDeviceListener(listener, null);
    }

    public void stopDetectingDevices(){
        manager.unregisterInputDeviceListener(listener);
    }

    public DeviceController[] getConnectedDevicesList(){
        int[] deviceIds = InputDevice.getDeviceIds();
        ArrayList<DeviceController> list = new ArrayList<>();
        for(int id : deviceIds){
            InputDevice dev = InputDevice.getDevice(id);
            if(!dev.isVirtual()){
                DeviceController controller = new DeviceController(DeviceRecognizer.getDeviceInputType(dev), dev);
                list.add(controller);
            }
        }
        return list.toArray(new DeviceController[0]);
    }
}

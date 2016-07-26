package com.aptoide.controllerdetector;

import android.content.Context;
import android.hardware.input.InputManager;
import android.view.InputDevice;

import java.util.ArrayList;

/**
 * Detect and recognize input controllers (HID) and receive feedback based on connectivity changes.
 * <p>
 * Main class for registering and unregistering the appropriate listener and to query about connected devices.
 *
 * @see ControllerListener
 * @see DeviceController
 */
public class InputDeviceConnector {

    private InputManager manager;
    private DeviceListener dListener;

    /**
     * Public constructor for InputDeviceConnector. Activity context and listener has to be passed.
     *
     * @param context Context of application
     * @param listener ControllerListener to receive connectivity changes alerts
     * @see ControllerListener
     * @see Context
     */
    public InputDeviceConnector(Context context, ControllerListener listener){
        manager = (InputManager) context.getSystemService(Context.INPUT_SERVICE);
        dListener = new DeviceListener(listener);
    }

    /**
     * Starts detecting devices. Any devices connectivity changes will be handled by the registered
     * listener.
     *
     * @see ControllerListener
     */
    public void startDetectingDevices(){
        manager.registerInputDeviceListener(dListener, null);
    }

    /**
     * Stops detecting devices. Any devices connectivity changes will be handled by the registered
     * listener.
     *
     * @see ControllerListener
     */
    public void stopDetectingDevices(){
        manager.unregisterInputDeviceListener(dListener);
    }

    /**
     * Requests an array of all devices connected to the system.
     *
     * @return An array containing all DeviceControllers connected to the system.
     * @see ControllerListener
     */

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

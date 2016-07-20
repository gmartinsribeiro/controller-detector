package com.aptoide.controllerdetector;

import android.view.InputDevice;

/**
 * Created by franciscofariaaleixo on 20-07-2016.
 */
public class DeviceRecognizer {

    public static DeviceInputType getDeviceInputType(InputDevice dev){
        if( ((dev.getSources() & InputDevice.SOURCE_GAMEPAD) == InputDevice.SOURCE_GAMEPAD) ||
                ((dev.getSources() & InputDevice.SOURCE_JOYSTICK) == InputDevice.SOURCE_JOYSTICK)){
            return DeviceInputType.GAMEPAD;
        }
        else if(((dev.getSources() & InputDevice.SOURCE_STYLUS) == InputDevice.SOURCE_STYLUS) ||
                ((dev.getSources() & InputDevice.SOURCE_BLUETOOTH_STYLUS) == InputDevice.SOURCE_BLUETOOTH_STYLUS)){
            return DeviceInputType.STYLUS;
        }
        else if((dev.getSources() & InputDevice.SOURCE_TOUCHPAD) == InputDevice.SOURCE_TOUCHPAD){
            return DeviceInputType.TOUCHPAD;
        }
        else if((dev.getSources() & InputDevice.SOURCE_TOUCHSCREEN) == InputDevice.SOURCE_TOUCHSCREEN){
            return DeviceInputType.TOUCHSCREEN;
        }
        else if((dev.getSources() & InputDevice.SOURCE_TRACKBALL) == InputDevice.SOURCE_TRACKBALL){
            return DeviceInputType.TRACKBALL;
        }
        else if((dev.getSources() & InputDevice.SOURCE_MOUSE) == InputDevice.SOURCE_MOUSE){
            return DeviceInputType.MOUSE;
        }
        else if(((dev.getSources() & InputDevice.SOURCE_KEYBOARD) == InputDevice.SOURCE_KEYBOARD)
                && dev.getKeyboardType() == InputDevice.KEYBOARD_TYPE_ALPHABETIC){
            return DeviceInputType.KEYBOARD;
        }
        else if(((dev.getSources() & InputDevice.SOURCE_KEYBOARD) == InputDevice.SOURCE_KEYBOARD)
                && dev.getKeyboardType() == InputDevice.KEYBOARD_TYPE_NON_ALPHABETIC){
            return DeviceInputType.TVREMOTE;
        }
        else if((dev.getSources() & InputDevice.SOURCE_DPAD) == InputDevice.SOURCE_DPAD){
            return DeviceInputType.DPAD;
        }
        return DeviceInputType.UNRECOGNIZED;
    }
}

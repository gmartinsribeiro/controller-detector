package com.aptoide.controllerdetector;

import android.view.InputDevice;

/**
 * Created by franciscofariaaleixo on 20-07-2016.
 */

public class DeviceController {
    private DeviceInputType type;
    private InputDevice device;

    public DeviceController(DeviceInputType type, InputDevice device) {
        this.type = type;
        this.device = device;

    }

    public DeviceInputType getType() {
        return type;
    }

    public void setType(DeviceInputType type) {
        this.type = type;
    }

    public InputDevice getDevice() {
        return device;
    }

    public void setDevice(InputDevice device) {
        this.device = device;
    }

}

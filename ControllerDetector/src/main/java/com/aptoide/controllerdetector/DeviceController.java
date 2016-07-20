package com.aptoide.controllerdetector;

import android.content.Context;
import android.view.InputDevice;

/**
 * Class that represents a controller containing two attributes: DeviceInputType and InputDevice.
 *
 * @see DeviceInputType
 * @see InputDevice
 */
public class DeviceController {
    private DeviceInputType type;
    private InputDevice device;

    /**
     * Public constructor for DeviceController.
     *
     * @param type DeviceInputType of this DeviceController
     * @param device InputDevice of this DeviceController.
     * @see DeviceInputType
     * @see InputDevice
     */
    public DeviceController(DeviceInputType type, InputDevice device) {
        this.type = type;
        this.device = device;

    }

    /**
     * Queries for the type of this controller.
     *
     * @return The type of this controller
     * @see DeviceInputType
     */
    public DeviceInputType getType() {
        return type;
    }

    /**
     * Queries for the InputDevice object of this controller.
     *
     * @return The InputDevice object of this controller
     * @see InputDevice
     */
    public InputDevice getDevice() {
        return device;
    }

}

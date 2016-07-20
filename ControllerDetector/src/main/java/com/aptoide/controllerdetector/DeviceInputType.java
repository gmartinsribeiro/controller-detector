package com.aptoide.controllerdetector;

/**
 * Enum that is used to specify the type of a device.
 * Only HID devices supported by InputDevice are listed.
 *
 * @see android.view.InputDevice
 */
public enum DeviceInputType {
    DPAD, GAMEPAD, KEYBOARD, MOUSE, STYLUS, TOUCHPAD, TOUCHSCREEN, TRACKBALL, TVREMOTE, UNRECOGNIZED
}


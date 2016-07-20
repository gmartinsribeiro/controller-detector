package com.aptoide.controllerdetector;

public interface ControllerListener {

    void onControllerConnect(DeviceController controller);

    void onControllerDisconnect(int id);

    void onControllerChange(DeviceController controller);
}

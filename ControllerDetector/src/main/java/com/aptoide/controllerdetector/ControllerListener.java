package com.aptoide.controllerdetector;

/**
 * Created by franciscofariaaleixo on 19-07-2016.
 */
public interface ControllerListener {

    void onControllerConnect(DeviceController controller);

    void onControllerDisconnect(int id);

    void onControllerChange(DeviceController controller);
}

package com.aptoide.controller_detector.activities;


import com.aptoide.controllerdetector.ControllerListener;
import com.aptoide.controllerdetector.DeviceController;

/**
 * Created by franciscofariaaleixo on 19-07-2016.
 */
public class ControllerListenerExample implements ControllerListener {

    private MainActivity main;

    public ControllerListenerExample(MainActivity main){
        this.main = main;
    }

    @Override
    public void onControllerChange(DeviceController controller) {

    }

    @Override
    public void onControllerConnect(DeviceController controller) {
        final DeviceController ctrl = controller;
        main.runOnUiThread(new Runnable(){

            @Override
            public void run() {
                main.addItemToList(ctrl);
            }
        });
    }

    @Override
    public void onControllerDisconnect(int id) {
        final int idF = id;
        main.runOnUiThread(new Runnable(){

            @Override
            public void run() {
                main.removeItemFromList(idF);
            }
        });
    }

}


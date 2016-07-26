package com.aptoide.controller_detector.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.InputDevice;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.aptoide.controller_detector.R;
import com.aptoide.controllerdetector.DeviceController;
import com.aptoide.controllerdetector.InputDeviceConnector;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private InputDeviceConnector connector;
    private ListView listView;

    private ArrayList<HashMap<String, String>> listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ControllerListenerExample listener = new ControllerListenerExample(MainActivity.this);
        connector = new InputDeviceConnector(this, listener);
        connector.startDetectingDevices();

        listView = (ListView) findViewById(R.id.listView);
        loadDeviceList();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        connector.stopDetectingDevices();
    }

    public void loadDeviceList(){
        DeviceController[] controllers = connector.getConnectedDevicesList();
        listData = new ArrayList<>();

        for(int i = 0; i<controllers.length; i++){
            HashMap<String,String> hashItem = new HashMap<>();
            if(controllers[i].getDevice().getId() > 5){
                InputDevice dev = controllers[i].getDevice();
                hashItem.put("NameVal", dev.getName());
                hashItem.put("TypeVal", controllers[i].getType().name());
                listData.add(hashItem);
            }
        }
        updateAdapter();
    }

    public void addItemToList(DeviceController controller){
        HashMap<String,String> hashItem = new HashMap<>();
        InputDevice dev = controller.getDevice();
        hashItem.put("NameVal", dev.getId() + " - " + dev.getName());
        hashItem.put("TypeVal", controller.getType().name());
        listData.add(hashItem);
        updateAdapter();

        System.out.println("Added item to list");
    }

    public void removeItemFromList(int id){
        // Again not ideal way to remove item as it may have duplicated name
        for(HashMap<String, String> hash : listData){
            String nameval = hash.get("NameVal");
            if(nameval.contains(""+id)){
                listData.remove(hash);
            }
        }
        updateAdapter();
    }

    private void updateAdapter(){
        // SimpleAdapter shouldn't be used because it's dynamic data but it's for demo purposes
        SimpleAdapter adapter = new SimpleAdapter(this, listData, android.R.layout.simple_list_item_2,
                new String[] {"NameVal", "TypeVal"}, new int[] {android.R.id.text1, android.R.id.text2});
        listView.setAdapter(adapter);
    }

    public void onRefreshClick(View view){
        loadDeviceList();
    }


}

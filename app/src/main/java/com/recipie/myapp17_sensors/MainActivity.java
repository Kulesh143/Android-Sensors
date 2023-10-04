package com.recipie.myapp17_sensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void viewAllSensors(View view) {
        int i = 0 ;
        SensorManager manager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensorList = manager.getSensorList(Sensor.TYPE_ALL);
        for (Sensor sensor : sensorList){
            i++ ;
            System.out.println(i+" "+sensor.getName()+" "+sensor.getVendor());

        }
    }

    public void checkSensor(View view) {
        SensorManager manager = (SensorManager) getSystemService(SENSOR_SERVICE);
        if (manager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) != null){
            Toast.makeText(this,"Magnetic Found",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"Magnetic Not Found",Toast.LENGTH_SHORT).show();
        }
    }

    public void AddListener(View view) {
        SensorManager manager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor = manager.getDefaultSensor(Sensor.TYPE_LIGHT);
        SensorEventListener listener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                float values[] = sensorEvent.values ;
                System.out.println(values[0]);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };

        manager.registerListener(listener,sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SensorManager manager = (SensorManager) getSystemService(SENSOR_SERVICE);
        // manager.unregisterListener();
    }
}

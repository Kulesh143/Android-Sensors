package com.recipie.myapp17_sensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    SensorEventListener listener ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        SensorManager manager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        // TYPE_ACCELEROMETER 1
        // TYPE_PROXIMITY   2
        // TYPE_MAGNETIC_FIELD
        listener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
              float values[] = sensorEvent.values;
//      1
                float x = values[0];
                float y = values[1];
                float z = values[2] ;

                System.out.println("x="+x+",y="+y+",z="+z);
                ((TextView)findViewById(R.id.textView)).setText("x="+x+",y="+y+",z="+z);
                // 2
//                float distance = values[0];
//                TextView textView1 = findViewById(R.id.textView);
//                textView1.setText("Distance ="+distance+"ok");



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
        manager.unregisterListener(listener);

    }
}

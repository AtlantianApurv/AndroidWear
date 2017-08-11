package com.example.amodi.myapplication21;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.widget.TextView;
import android.util.Log;
import android.view.WindowManager;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends Activity implements SensorEventListener {

    private static final String TAG = "MainActivity";
    /* private TextView*/
    Sensor mHeartRateSensor;
    Sensor accelerometer;
    SensorManager sm;
    SensorManager mSensorManager;
    TextView acceleration;
    TextView heart;
    private static final int SENSOR_TYPE_HEART_RATE = 65562;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        acceleration = (TextView) findViewById(R.id.acceleration);

        mSensorManager = ((SensorManager) getSystemService(SENSOR_SERVICE));
        mHeartRateSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_HEART_RATE);
        accelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(this, mHeartRateSensor, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);

        heart = (TextView) findViewById(R.id.heart);

    }
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    public void onSensorChanged(SensorEvent event) {


        // TODO Auto-generate method stub

        if (event.sensor.getType() == Sensor.TYPE_HEART_RATE)
        {
            String msg = "" + (int) event.values[0];
            System.out.println("heart"+event.values[0]);
            heart.setText(msg);
            Log.d(TAG, msg);


        }

        else  if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)

        {
            acceleration.setText("X: " + event.values[0] +
                "\nY: " + event.values[1] +
                "\nZ: " + event.values[2]);
            System.out.println("X: " + event.values[0] +
                    "\nY: " + event.values[1] +
                    "\nZ: " + event.values[2]);
//            Log.d(TAG, msg);
        }
    }
}






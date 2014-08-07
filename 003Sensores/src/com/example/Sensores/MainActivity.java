package com.example.Sensores;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends Activity implements SensorEventListener {
    /**
     * Called when the activity is first created.
     */

    private SensorManager mSensorManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);

        List<Sensor> listaSensores = mSensorManager.getSensorList(Sensor.TYPE_ALL);

        // Aqui comprobamos que sensores determinados Existen
        for (Sensor sensor : listaSensores){
            Log.d("======>Sensor: ",sensor.getName() );
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        // Dentro de este metodo procederemos a manejar sus datos
        synchronized (this) {
            switch (sensorEvent.sensor.getType()) {
                case Sensor.TYPE_ACCELEROMETER:
                    for (int i=0;i<3;i++){
                        Log.d("====> Sensor: ",String.valueOf(sensorEvent.values[i]));
                    }
                case Sensor.TYPE_MAGNETIC_FIELD:
                    for (int i=0;i<3;i++){
                        Log.d("====> Sensor: ",String.valueOf(sensorEvent.values[i]));
                    }
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}

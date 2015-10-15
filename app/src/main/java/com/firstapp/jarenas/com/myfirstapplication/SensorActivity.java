package com.firstapp.jarenas.com.myfirstapplication;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SensorActivity extends AppCompatActivity implements SensorEventListener {

    LinearLayout linearLayout;
    TextView textView;
    Sensor sensor;
    SensorManager sensorManager;
    String cadena;
    float numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        Log.d("Entro en los sensores", "Activitat de sensors");

        linearLayout = (LinearLayout) findViewById(R.id.linearlayout);
        textView = (TextView) findViewById(R.id.texto);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sensor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        cadena = String.valueOf(event.values[0]);
        Log.d("Valor de cadena", String.valueOf(event.values[0]));
        textView.setText(cadena);
        numero = Float.parseFloat(cadena);

        if (numero == 0 )
        {
            linearLayout.setBackgroundColor(Color.RED);
        }
        else {
            linearLayout.setBackgroundColor(Color.BLUE);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}

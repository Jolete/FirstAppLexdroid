package com.firstapp.jarenas.com.myfirstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button LoginEntry;
    Button ImageEntry;
    Button WebViewEntry;
    Button SensorsEntry;
    Button ScrollImageEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginEntry = (Button) findViewById(R.id.loginbtn);
        ImageEntry = (Button) findViewById(R.id.imagebtn);
        WebViewEntry = (Button) findViewById(R.id.webviewbtn);
        SensorsEntry = (Button) findViewById(R.id.sensorbtn);
        ScrollImageEntry = (Button) findViewById(R.id.scrollimagebtn);

        LoginEntry.setOnClickListener(this);
        ImageEntry.setOnClickListener(this);
        WebViewEntry.setOnClickListener(this);
        SensorsEntry.setOnClickListener(this);
        ScrollImageEntry.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    public void onClick(View view) {
        String mPackage = "com.firstapp.jarenas.com.myfirstapplication";

        switch (view.getId()) {
            case R.id.loginbtn: {
                //ActivityLauncher("LoginActivity");
                ActivityLauncherWithReflexion(mPackage + ".LoginActivity");
                fowardZoom(view);
                Toast.makeText(this, "animación Zoom", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.imagebtn: {
                //ActivityLauncher("ImageActivity");
                ActivityLauncherWithReflexion(mPackage + ".ImageActivity");
                side(view);
                Toast.makeText(this, "animación Left", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.webviewbtn: {
                //ActivityLauncher("WebViewActivity");
                ActivityLauncherWithReflexion(mPackage + ".WebViewActivity");
                fade(view);
                Toast.makeText(this, "animación Fade", Toast.LENGTH_SHORT).show();
                break;
            }

            case R.id.sensorbtn: {
                ///ActivityLauncher("SensorActivity");
                ActivityLauncherWithReflexion(mPackage + ".SensorActivity");
                //Log.d("R.id.sensorbtn", "String.valueOf(event.values[0]))");
                //explode(view);
                side(view);
                Toast.makeText(this, "Sin animación", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.scrollimagebtn:
            {
                ActivityLauncherWithReflexion(mPackage + ".ScrollerImageActivity");
                fade(view);
                Toast.makeText(this, "animación Fade", Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }

    private void ActivityLauncher(String activityName) {
        Intent intent;
        String mPackage = "com.firstapp.jarenas.com.myfirstapplication";
        //String mClass = "." + activityName;
        // intent.setClassName(mPackage, mPackage+mClass);

        if (activityName.equals("LoginActivity"))
            intent = new Intent(this, LoginActivity.class);
        else if (activityName == "ImageActivity")
            intent = new Intent(this, ImageActivity.class);
        else if (activityName == "WebViewActivity")
            intent = new Intent(this, WebViewActivity.class);
        else if (activityName == "SensorActivity")
            Log.d("actividad q lanzo", activityName);
        intent = new Intent(this, SensorActivity.class);

        startActivity(intent);
    }

    private void ActivityLauncherWithReflexion(String activityName) {
        Class<?> c = null;
        if (activityName != null) {
            try {
                c = Class.forName(activityName);
            } catch (ClassNotFoundException e) {
                // TODO Auto‐generated catch block
                e.printStackTrace();
            }
        }
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }

    ///
    /// Bloc de transicions
    ///
    public void explode(View button) {
        overridePendingTransition(R.anim.explode_transition, R.anim.explode_transition);
    }

    public void fowardZoom(View button) {
        overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);
    }

    public void side(View button) {
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }

    public void fade(View button) {
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void byDefault(View button) {
        return;
    }
}

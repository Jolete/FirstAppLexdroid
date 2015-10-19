package com.firstapp.jarenas.com.myfirstapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class ScrollerImageActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView principal, a1, a2, a3, a4, a5, a6;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroller_image);

        principal = (ImageView) findViewById(R.id.principal);
        a1 = (ImageView) findViewById(R.id.a1);
        a2 = (ImageView) findViewById(R.id.a2);
        a3 = (ImageView) findViewById(R.id.a3);
        a4 = (ImageView) findViewById(R.id.a4);
        a5 = (ImageView) findViewById(R.id.a5);
        a6 = (ImageView) findViewById(R.id.a6);
        boton = (Button) findViewById(R.id.boton);

        a1.setOnClickListener(this);
        a2.setOnClickListener(this);
        a3.setOnClickListener(this);
        a4.setOnClickListener(this);
        a5.setOnClickListener(this);
        a6.setOnClickListener(this);
        boton.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scroller_image, menu);
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
        int fondoID = R.drawable.b;

        switch (view.getId()) {
            case R.id.a1:
                principal.setImageResource(R.drawable.b);
                fondoID = R.drawable.b;
                break;
            case R.id.a2:
                principal.setImageResource(R.drawable.batman);
                fondoID = R.drawable.batman;
                break;
            case R.id.a3:
                principal.setImageResource(R.drawable.ae);
                fondoID = R.drawable.ae;
                break;
            case R.id.a4:
                principal.setImageResource(R.drawable.bmw);
                fondoID = R.drawable.bmw;
                break;
            case R.id.a5:
                principal.setImageResource(R.drawable.firefox);
                fondoID = R.drawable.firefox;
                break;
            case R.id.a6:
                principal.setImageResource(R.drawable.orgflat);
                fondoID = R.drawable.orgflat;
                break;
            case R.id.boton:
                Bitmap fondo = BitmapFactory.decodeStream(getResources().openRawResource(fondoID));

                try {
                    getApplicationContext().setWallpaper(fondo);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}

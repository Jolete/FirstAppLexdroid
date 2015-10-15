package com.firstapp.jarenas.com.myfirstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    TextView usuario;
    TextView password;
    TextView message;
    Button forwardZoom;
    Button left;
    Button fade;
    Button bydefault;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       /* usuario = (TextView) findViewById(R.id.txtUser);
        password = (TextView) findViewById(R.id.txtUser);
        usuario = (TextView) findViewById(R.id.txtUser);

        forwardZoom = (Button) findViewById(R.id.forwardZoom);
        left = (Button) findViewById(R.id.left);
        fade = (Button) findViewById(R.id.fade);
        bydefault = (Button) findViewById(R.id.byDefault);

        forwardZoom.setOnClickListener(this);
        left.setOnClickListener(this);
        fade.setOnClickListener(this);
        bydefault.setOnClickListener(this);*/
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
        /*String usuario = ((EditText) findViewById(R.id.txtUser)).getText().toString();
        String password = ((EditText) findViewById(R.id.txtUser)).getText().toString();

        message.setText("Entrada al ".concat(usuario).concat(" con password ").concat(password));*/

        //getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        switch (view.getId()) {
            case R.id.forwardZoom:
                fowardZoom(view);
                break;
            case R.id.left:
                left(view);
                break;
            case R.id.fade:
                fade(view);
                break;
            case R.id.byDefault:
                byDefault(view);
                Toast.makeText(this, "Es canvia a la segona activitat sense cap animació", Toast.LENGTH_LONG).show();
                break;
        }
    }

    ///
    /// Bloc de transicions
    ///
    public void explode(View button)
    {
        startActivity(new Intent(this, ImageActivity.class));
        overridePendingTransition(R.anim.explode_transition, R.anim.explode_transition);
    }

    public void fowardZoom(View button)
    {
        startActivity(new Intent(this, ImageActivity.class));
        overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);
    }

    public void left(View button)
    {
        startActivity(new Intent(this, ImageActivity.class));
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }
    public void fade(View button)
    {
        startActivity(new Intent(this, ImageActivity.class));
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void byDefault(View button)
    {
        startActivity(new Intent(this, ImageActivity.class));
    }
}

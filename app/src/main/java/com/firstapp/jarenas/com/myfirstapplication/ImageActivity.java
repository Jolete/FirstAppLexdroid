package com.firstapp.jarenas.com.myfirstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imatge;
    Button boto1;
    Button boto2;
    Button forwardButton;
    Button faceButton;
    Button rightButton;
    Button backButton;

    TextView textBox;
    boolean canviText = true;
    boolean canviImatge = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        boto1 = (Button) findViewById(R.id.boto1);
        boto2 = (Button) findViewById(R.id.boto2);
        forwardButton  = (Button) findViewById(R.id.zoomBack);
        faceButton = (Button) findViewById(R.id.fadeBack);
        rightButton = (Button) findViewById(R.id.rightBack);
        backButton= (Button) findViewById(R.id.back);

        imatge = (ImageView) findViewById(R.id.imatge);
        textBox = (TextView) findViewById(R.id.nom);

        boto1.setOnClickListener(this);
        boto2.setOnClickListener(this);
        forwardButton.setOnClickListener(this);
        faceButton.setOnClickListener(this);
        rightButton.setOnClickListener(this);
        backButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_image, menu);
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

        switch (view.getId()) {
            case R.id.boto2:
                canviarText();
                break;
            case R.id.boto1:
                canviarImatge();
                break;
            case R.id.forwardZoom:
                zoomBack(view);
                break;
            case R.id.fadeBack:
                fade(view);
                break;
            case R.id.rightBack:
                right(view);
                break;
            case R.id.back:
                back(view);
                break;
        }
    }

    private void canviarText()
    {
        if (canviText) {
            textBox.setText("Jordi");
        }
        else {
            textBox.setText("Arnau");
        }

        canviText = !canviText;
    }

    private void canviarImatge() {
        if (canviImatge) {
            imatge.setImageResource(R.drawable.bmw);
        }
        else {
            imatge.setImageResource(R.drawable.burger);
        }
        canviImatge = !canviImatge;
    }

    ///
    /// Bloc de transicions
    ///
    public void explode(View button)
    {
        startActivity(new Intent(this, MainActivity.class));
        overridePendingTransition(R.anim.explode_transition, R.anim.explode_transition);
    }

    public void zoomBack(View button)
    {
        startActivity(new Intent(this, MainActivity.class));
        overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);
    }

    public void fade(View button)
    {
        startActivity(new Intent(this, MainActivity.class));
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void right(View button)
    {
        startActivity(new Intent(this, MainActivity.class));
        overridePendingTransition(R.anim.right_in, R.anim.right_out);
    }

    public void back(View button)
    {
        super.onBackPressed();
    }
}

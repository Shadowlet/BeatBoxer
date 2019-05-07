package com.zacharycarreiro.beatboxer;

import android.content.Intent;
import android.graphics.Point;
import android.app.Activity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener {

    int screenWidth;
    int screenHeight;

    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find out the width and height of the screen
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;

        Button button1 = findViewById(R.id.buttonPlay);
        Button button2 = findViewById(R.id.buttonControls);
        Button button3 = findViewById(R.id.buttonQuit);

        //Make each of them listen for clicks
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

        i = new Intent(this, GameActivity.class);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.buttonPlay://when the first button is pressed
                //Play the game
                startActivity(i);
                finish();
                break;

            //Repeat the above for the 2nd and 3rd samples and buttons
            case R.id.buttonControls:
                break;

            case R.id.buttonQuit:
                break;
        }
    }
}

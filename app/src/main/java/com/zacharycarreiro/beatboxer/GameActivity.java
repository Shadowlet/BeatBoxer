package com.zacharycarreiro.beatboxer;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;

public class GameActivity extends AppCompatActivity {

    int screenWidth;
    int screenHeight;

    boolean gameIsRunning = false;

    int fps = 30;
    int skipTick = 1000 / fps;
    long nextTick = System.currentTimeMillis(); // Returns current number of milliseconds

    int timeToSleep = 0;

    SwingMeter meter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        createDisplay();

        meter = new SwingMeter();

        while (gameIsRunning)
        {
            updateGame();
            //showGame();

            nextTick += skipTick;
            timeToSleep = nextTick; //GetTick
            if (timeToSleep >= 0)
            {

            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent){

        switch (motionEvent.getAction() & MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_UP:
                if(motionEvent.getX() >= screenHeight/2){
                    //Ducking
                    Duck();
                } else{
                   //Punching
                    Punch();
                }
        }
        return true;
    }

    public void createDisplay(){
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;
    }

    public void Duck(){

    }

    public void Punch(){
        meter.Swing();
    }
}

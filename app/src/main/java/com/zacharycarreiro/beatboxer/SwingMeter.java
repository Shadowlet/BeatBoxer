package com.zacharycarreiro.beatboxer;

import android.app.Activity;
import android.os.Bundle;

public class SwingMeter extends Activity {
    int meterMin;
    int meterMid;
    int meterMax;

    float meter;
    float xVelocity;
    float dx = meter - meterMax;

    int comboNum;

    boolean finished = false;
    boolean swingingLeft = false;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        meter = 0;
        meterMin = -100;
        meterMid = 0;
        meterMax = 100;

        xVelocity = 0.4f;
        comboNum = 0;
    }

    public void Swing()
    {
        if (swingingLeft)
        {
            meter *= -xVelocity;
            swingingLeft = false;

        }
        else if (swingingLeft == false) {
            meter *= xVelocity;
            swingingLeft = true;


        }
    }
}

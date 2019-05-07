package com.zacharycarreiro.beatboxer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class TestingGuy extends Actor {



    @Override
    public void Update() {

    }

    @Override
    public void Draw(Canvas c, Paint p) {
        float size = 10;


        p.setColor(Color.argb(255, 255, 255, 255));
        Artist.drawRect(x - (size / 2),y - (size / 2),
                x + (size / 2), y + (size / 2));
    }



    @Override
    public void onCreate() {
        x = 10;
        y = 10;
    }
}

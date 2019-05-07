package com.zacharycarreiro.beatboxer;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.Display;

public class Artist {


    public static Canvas c;
    public static Paint p;

    public static int screenWidth = 0;
    public static int screenHeight = 0;
    public static float ratioWidth = 1;
    public static float ratioHeight = 1;
    public static int offsetX = 0;
    public static int offsetY = 0;


    public static boolean retainRatio = false;



    public static boolean isInit = false;

    public static Point displaySize = new Point();
    public static Display d = null;


    public static void Initialize(Display display) {
        d = display;
        //
        d.getSize(displaySize);
        //
        SetScreenSize(displaySize.x, displaySize.y);


        isInit = true;
    }

    public static void Setup(Canvas canvas, Paint paint) {
        c = canvas;
        p = paint;
    }



    public static void SetScreenSize(float val) {
        d.getSize(displaySize);
        //
        SetScreenSize((int)(displaySize.x/val), (int)(displaySize.y/val));
    }
    public static void SetScreenSize(int width, int height) {
        d.getSize(displaySize);


        screenWidth = width;
        screenHeight = height;
        //
        ratioWidth = screenWidth / (float)displaySize.x;
        ratioHeight = screenHeight / (float)displaySize.y;
        //
        if (retainRatio) {
            float lesser = Math.min(ratioWidth, ratioHeight);
            ratioWidth = lesser;
            ratioHeight = lesser;
        }
        //
        offsetX = 0;
        offsetY = 0;
    }



    public static void drawRect(float x1, float y1, float x2, float y2) {
        drawRect((int)x1, (int)y1, (int)x2, (int)y2);
    }
    public static void drawRect(int x1, int y1, int x2, int y2) {
        if (!isInit) return;


        c.drawRect(offsetX+ x1 /ratioWidth, offsetY+ y1 /ratioHeight, offsetX+ x2 /ratioWidth, offsetY+ y2 /ratioHeight, p);
    }

}

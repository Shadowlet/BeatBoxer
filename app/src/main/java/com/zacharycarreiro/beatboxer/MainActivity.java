package com.zacharycarreiro.beatboxer;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends Activity implements View.OnClickListener {



    TextView txtMessage;
    Button button;

    SoundPool soundPool;
    int testSample;
    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        txtMessage = findViewById(R.id.txtMessage);
        button = findViewById(R.id.button);
        //
        button.setOnClickListener(this);


        mediaPlayer = MediaPlayer.create(this, R.raw.test);


        soundPool = new SoundPool.Builder().setMaxStreams(10).build();
        try{
            //Create objects of the 2 required classes
            AssetManager assetManager = getAssets();
            AssetFileDescriptor descriptor;

            //create our three fx in memory ready for use
            descriptor = assetManager.openFd("raw/test.wav");
            testSample = soundPool.load(descriptor, 0);


            txtMessage.setText("Done.");
        }catch(IOException e){
            //catch exceptions here

            txtMessage.setText("Didn't work.");
        }
    }

    @Override
    public void onClick(View v) {
        // soundPool.play(testSample, 1, 1, 0, 0, 1);

        // mediaPlayer.
        if (mediaPlayer.isPlaying()) {

            mediaPlayer.seekTo(1000);
        } else {

            mediaPlayer.start();
        }


    }
}

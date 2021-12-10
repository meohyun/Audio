package com.example.audio01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void play(View v){
        int id = v.getId();
        LinearLayout layout = (LinearLayout) findViewById(id);


        Resources res = getResources();

        if(mp.isPlaying()){
            mp.pause();

            Drawable drawable = res.getDrawable(R.drawable.title_model);
            layout.setBackground(drawable);
        } else {

            String tag = (String) layout.getTag();
            int id_audio = res.getIdentifier(tag,"raw",getPackageName());

            mp = MediaPlayer.create(this,id_audio);
            mp.setLooping(false);
            mp.start();

            Drawable drawable = res.getDrawable(R.drawable.music_on);
            layout.setBackground(drawable);
        }


    }

    protected void onDestroy(){
        mp.stop();
        mp.release();
        super.onDestroy();
    }

}
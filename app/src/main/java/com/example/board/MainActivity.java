package com.example.board;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private SoundPool soundPool;
    private int griffin, griffin2, griffin3, dubstep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setMaxStreams(4)
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else {
            soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 0);
        }

        griffin = soundPool.load(this, R.raw.griffin, 1);
        griffin2 = soundPool.load(this, R.raw.griffin2, 1);
        griffin3 = soundPool.load(this, R.raw.griffin3, 1);
        dubstep = soundPool.load(this, R.raw.dubstep, 1);
    }
    public void playSound(View v) {
        switch (v.getId()) {
            case R.id.button_griffin:
                soundPool.play(griffin,1, 1, 0, 0, 1);
                soundPool.autoPause();
                break;
            case R.id.button_griffin2:
                soundPool.play(griffin2,1, 1, 0, 0, 1);
                soundPool.autoPause();
                break;
            case R.id.button_griffin3:
                soundPool.play(griffin3,1, 1, 0, 0, 1);
                soundPool.autoPause();
                break;
            case R.id.button_dubstep:
                soundPool.play(dubstep,1, 1, 0, 0, 1);
                soundPool.autoPause();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }
}

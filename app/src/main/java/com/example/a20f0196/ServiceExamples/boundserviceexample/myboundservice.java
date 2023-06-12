package com.example.a20f0196.ServiceExamples.boundserviceexample;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.example.a20f0196.R;
import com.karumi.dexter.Dexter;

import java.io.File;
import java.util.ArrayList;

public class myboundservice extends Service {


    public static final String TAG="tag";

    private final  Binder mybinder=new MyBinder();
    public MediaPlayer mediaPlayer;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG,"on bind started");
        return mybinder;
    }


    public  void play()
    {
        mediaPlayer.start();
    }
    public  void pause()
    {
        mediaPlayer.pause();
    }

    public  void stop()
    {
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer =MediaPlayer.create(this, R.raw.small);
    }
    private int seekForwardTime = 5 * 1000; // default 5 second
    private int seekBackwardTime = 5 * 1000; // default 5 second
    public void forwardSong() {
        if (mediaPlayer != null) {
            int currentPosition = mediaPlayer.getCurrentPosition();
            if (currentPosition + seekForwardTime <= mediaPlayer.getDuration()) {
                mediaPlayer.seekTo(currentPosition + seekForwardTime);
            } else {
                mediaPlayer.seekTo(mediaPlayer.getDuration());
            }
        }
    }

    public void rewindSong() {
        if (mediaPlayer != null) {
            int currentPosition = mediaPlayer.getCurrentPosition();
            if (currentPosition - seekBackwardTime >= 0) {
                mediaPlayer.seekTo(currentPosition - seekBackwardTime);
            } else {
                mediaPlayer.seekTo(0);
            }
        }
    }
    public boolean isplay()
    {
       return mediaPlayer.isPlaying();

    }

    @Override
    public void onCreate() {

        super.onCreate();

        mediaPlayer =MediaPlayer.create(this, R.raw.small);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG,"on unbind is called");
        return super.onUnbind(intent);
    }

    public  class MyBinder extends Binder
    {
        myboundservice getServiceMethod()
        {
            return myboundservice.this;
        }
    }


}

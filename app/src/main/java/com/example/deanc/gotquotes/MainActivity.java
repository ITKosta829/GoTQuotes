package com.example.deanc.gotquotes;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.deanc.gotquotes.fragments.Shake;
import com.example.deanc.gotquotes.fragments.TitlePage;

import java.io.IOException;


public class MainActivity extends AppCompatActivity implements MyActivity {

    String url;
    MediaPlayer mediaPlayer;
    NetworkCaller networkCaller;
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        networkCaller = new NetworkCaller(this);

        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, new TitlePage()).commit();

        playMusic();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Second fragment after 7 seconds appears
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new Shake())
                        .commit();
            }
        }, 3000);

        // ShakeDetector initialization
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager
                .getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector();
        mShakeDetector.setOnShakeListener(new ShakeDetector.OnShakeListener() {
            @Override
            public void onShake(int count) {
                Log.d("onShake", "CALLED");
                networkCaller.getMeAQuote();
            }
        });

    }

    public void playMusic() {

        mediaPlayer = new MediaPlayer();
        url = "https://soundcloud.com/fatihizm/game-of-thrones-main-theme";
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        try {
            mediaPlayer.setDataSource(url);
        } catch (IllegalArgumentException e) {

        } catch (SecurityException e) {

        } catch (IllegalStateException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            mediaPlayer.prepare();
        } catch (IllegalStateException e) {

        } catch (IOException e) {

        }

        mediaPlayer.start();

    }

    @Override
    public void showMeTheQuote() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new QuoteView())
                .commit();
    }




}

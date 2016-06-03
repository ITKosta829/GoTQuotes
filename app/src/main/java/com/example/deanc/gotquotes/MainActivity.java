package com.example.deanc.gotquotes;

import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.deanc.gotquotes.fragments.Shake;
import com.example.deanc.gotquotes.fragments.TitlePage;

import java.io.IOException;


public class MainActivity extends AppCompatActivity implements MyActivity {

    String url;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

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
        }, 7000);

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

    }
}

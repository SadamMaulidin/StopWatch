package com.tapperware.stopwatch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class Splash extends AppCompatActivity {

    private long ms = 0;
    private long splashTime = 5000;
    private boolean splashActivity = true;
    private boolean paused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final ProgressBar progressBar = (findViewById(R.id.progressBar));

        Thread mythread = new Thread(){
            public void run(){
                try{
                    while(splashActivity && ms < splashTime){
                        if (!paused){
                            ms = ms + 50;
                            sleep(50);
                            progressBar.setProgress((int)ms);
                        }
                    }
                }catch (Exception e) {
                } finally {
                    Intent intent = new Intent(Splash.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

        };
        mythread.start();
    }
}

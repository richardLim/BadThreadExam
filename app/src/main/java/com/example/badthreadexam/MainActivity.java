package com.example.badthreadexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Thread mThread;
    private int mCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startThread(View view) {
        if(mThread == null) {
            mThread = new Thread("My Thread") {
                @Override
                public void run() {
                    for(int i = 0; i < 100; i++) {
                        mCount++;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            break;
                        }
                        Log.d("My Thread", "쓰레드 동작중 " + mCount);
                    }
                }
            };
            mThread.start();
        }
    }

    public void stopThread(View view) {
        if(mThread != null) {
            mThread.interrupt();
            mThread = null;
            mCount = 0;
        }

    }
}
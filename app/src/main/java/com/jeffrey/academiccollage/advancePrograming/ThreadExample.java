package com.jeffrey.academiccollage.advancePrograming;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jeffrey.academiccollage.BasicActivity;
import com.jeffrey.academiccollage.R;

import java.util.Calendar;

public class ThreadExample extends BasicActivity {

    private TextView clock;
    private    int sec=0;
    private Thread thread;
    private boolean isRunning=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_example);
        clock=findViewById(R.id.title_of_time);
        findViewById(R.id.start_clock_without_thread).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startClockWithoutThread();
            }
        });
        findViewById(R.id.start_clock_with_thread).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startClockWithThread();
            }
        });
        findViewById(R.id.stop_clock).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                stopThread();
            }
        });


    }

    private void startClockWithThread(){
        thread=  new Thread(new Runnable() {
            @Override
            public void run() {

                isRunning=true;
                while (isRunning) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Calendar c = Calendar.getInstance();

                            int hours = c.get(Calendar.HOUR_OF_DAY);
                            int minutes = c.get(Calendar.MINUTE);
                            int seconds = c.get(Calendar.SECOND);

                            String curTime = String.format("%02d  %02d  %02d", hours, minutes, seconds);
                            clock.setText(curTime); //change clock to your textview
                        }
                    });
                }
            }
        });
        thread.start();



    }

    private void stopThread(){
        isRunning=false;
    }

    private void startClockWithoutThread(){

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                Calendar c = Calendar.getInstance();

                int hours = c.get(Calendar.HOUR_OF_DAY);
                int minutes = c.get(Calendar.MINUTE);
                int seconds = c.get(Calendar.SECOND);

                String curTime = String.format("%02d  %02d  %02d", hours, minutes, seconds);
                clock.setText(curTime); //change clock to your textview
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}

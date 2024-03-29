package com.example.workout2;


import android.arch.lifecycle.Lifecycle;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class StopwatchFragment extends Fragment implements  View.OnClickListener{

    int seconds = 0;
    boolean running;
    private boolean  wasRunning;

    //無引數建構事
    public StopwatchFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null){
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState .getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout =  inflater.inflate(R.layout.fragment_stopwatch, container, false);
        runTimer(layout);
        InitialComponent(layout);
        return  layout;
    }

    private void InitialComponent(View layout) {
    startButton = layout.findViewById(R.id.start_button);
    startButton.setOnClickListener(this);
    stopButton = layout.findViewById(R.id.stop_button);
    stopButton.setOnClickListener(this);
    resetButton = layout.findViewById(R.id.reset_button);
    resetButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.start_button:
                onClickStart();
                break;
            case R.id.stop_button:
                onClickStop();
                break;
            case R.id.reset_button:
                onClickReset();
                break;
        }
    }

    @Override
    public Lifecycle getLifecycle() {
        return super.getLifecycle();
    }

    @Override
    public void onPause() {
        super.onPause();
        wasRunning = running ;
        running = false;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(wasRunning){
            running = true;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("seconds", seconds);
        outState.putBoolean("running",running);
        outState.putBoolean("wasRunning", wasRunning);
    }

    private void onClickStart() {
        running = true;
    }

    private void onClickStop() {
        running = false;
    }

    private void onClickReset() {
        running = false;
        seconds = 0;
    }

    private void runTimer(View view) {
        final TextView timeView = view.findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int h = seconds/3600;
                int m = (seconds%3600)/60;
                int s = seconds%60;
                String Time = String.format(Locale.getDefault(), "%d:%02d:%02d", h, m, s);
                timeView.setText(Time);

                if(running){
                    seconds++;
                }
                handler.postDelayed(this,1000);

            }
        });
    }

    Button startButton, stopButton, resetButton;

}

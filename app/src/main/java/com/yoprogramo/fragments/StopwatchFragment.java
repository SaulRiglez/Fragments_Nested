package com.yoprogramo.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class StopwatchFragment extends Fragment implements View.OnClickListener {


    private final String TAG = "states";
    private final String TIME_KEY = "time";
    private final String RUNNING_STATE = "runing";

    private int seconds = 0;
    private boolean running;
    private boolean wasRunning;


    public StopwatchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState != null){
            seconds = savedInstanceState.getInt(TIME_KEY);
            running = savedInstanceState.getBoolean(RUNNING_STATE);
        }



    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_stopwatch, container, false);
        runTimer(layout);

        Button startButton = (Button) layout.findViewById(R.id.start_button);
        startButton.setOnClickListener(this);
        Button stopButton = (Button)layout.findViewById(R.id.stop_button);
        stopButton.setOnClickListener(this);

        Button resetButton = (Button)layout.findViewById(R.id.reset_button);
        resetButton.setOnClickListener(this);

        return layout;
    }



    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(TIME_KEY, seconds);
        outState.putBoolean(RUNNING_STATE, running);

    }

    private void runTimer(View view) {

        final TextView timeView = (TextView) view.findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int sec = seconds % 60;


                String time = String.format("%1$d:%2$d:%3$d",
                        hours, minutes, sec);


                timeView.setText(time);
                if (running) {
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });


    }

    public void onClickStart(View view) {

        running = true;
    }

    public void onClickStop(View view) {

        running = false;
    }

    public void onClickReset(View view) {

        seconds = 0;
        running = false;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {

            case R.id.start_button:
                onClickStart(view);
                break;
            case R.id.reset_button:
                onClickReset(view);
                break;
            case R.id.stop_button:

                onClickStop(view);
                break;

        }
    }
}

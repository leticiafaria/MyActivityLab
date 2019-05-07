package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityOne extends AppCompatActivity {

    private final static String TAG = "Lab-ActivityOne";

    private static final String RESTART_KEY = "restart";
    private static final String RESUME_KEY = "resume";
    private static final String START_KEY = "start";
    private static final String CREATE_KEY = "create";

    private static int contOnCreate = 0;
    private static int contOnStart = 0;
    private static int contOnResume = 0;
    private static int contOnRestart = 0;

    private TextView tvContadorOnCreate;
    private TextView tvContadorOnStart;
    private TextView tvContadorOnResume;
    private TextView tvContadorOnRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "Entered the onCreate() method - ActivityOne");


        if(savedInstanceState != null){
            contOnCreate = savedInstanceState.getInt(CREATE_KEY);
            contOnStart = savedInstanceState.getInt(START_KEY);
            contOnResume = savedInstanceState.getInt(RESUME_KEY);
            contOnRestart = savedInstanceState.getInt(RESTART_KEY);


        }

        Button launchActivityTwoButton = (Button) findViewById(R.id.buttonLaunchActivityTwo);

        tvContadorOnCreate = findViewById(R.id.create);
        tvContadorOnStart = findViewById(R.id.start);
        tvContadorOnResume = findViewById(R.id.resume);
        tvContadorOnRestart = findViewById(R.id.restart);

        contOnCreate++;
        updateTextViews();

        launchActivityTwoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO:
                // Iniciar Activity 2

                // Criar um Intent dizendo que Activity deve ser iniciada
                Intent intent = new Intent(ActivityOne.this, ActivityTwo.class);

                // Chamar Activity usando o Intent
                startActivity(intent);
            }
        });
    }

    public void updateTextViews(){

        tvContadorOnCreate.setText("onCreate(): " + contOnCreate);
        tvContadorOnStart.setText("onStart(): " + contOnStart);
        tvContadorOnResume.setText("onResume(): " + contOnResume);
        tvContadorOnRestart.setText("onRestart(): " + contOnRestart);
    }

    @Override
    public void onStart() {
        super.onStart();

        contOnStart++;
        updateTextViews();


        // Emit LogCat message
        Log.i(TAG, "Entered the onStart() method - ActivityOne");
    }

    @Override
    public void onResume() {
        super.onResume();

        contOnResume++;
        updateTextViews();

        // Emit LogCat message
        Log.i(TAG, "Entered the onResume() method - ActivityOne");
    }

    @Override
    public void onPause() {
        super.onPause();

        // Emit LogCat message
       Log.i(TAG, "Entered the onPause() method");
    }

    @Override
    public void onStop() {
        super.onStop();

        // Emit LogCat message
        Log.i(TAG, "Entered the onStop() method");
    }

    @Override
    public void onRestart() {
        super.onRestart();

        contOnRestart++;
        updateTextViews();

        // Emit LogCat message
        Log.i(TAG, "Entered the onRestart() method - ActivityOne");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        // Emit LogCat message
        Log.i(TAG, "Entered the onDestroy() method");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);
        // Save the user's current game state
        savedInstanceState.putInt(CREATE_KEY, contOnCreate);
        savedInstanceState.putInt(START_KEY, contOnStart);
        savedInstanceState.putInt(RESUME_KEY, contOnResume);
        savedInstanceState.putInt(RESTART_KEY, contOnRestart);


        // Always call the superclass so it can save the view hierarchy state

    }
}

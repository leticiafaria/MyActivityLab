package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends Activity {

    public final String TAG = "Lab-ActivityTwo";

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
        Log.i(TAG, "Entered the onCreate() method - ActivityTwo");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        if(savedInstanceState != null){
            contOnCreate = savedInstanceState.getInt(CREATE_KEY);
            contOnStart = savedInstanceState.getInt(START_KEY);
            contOnResume = savedInstanceState.getInt(RESUME_KEY);
            contOnRestart = savedInstanceState.getInt(RESTART_KEY);

        }

        Button closeButton = (Button) findViewById(R.id.bClose);

        tvContadorOnCreate = findViewById(R.id.create);
        tvContadorOnStart = findViewById(R.id.start);
        tvContadorOnResume = findViewById(R.id.resume2);
        tvContadorOnRestart = findViewById(R.id.restart);

        contOnCreate++;
        updateTextViews();


        closeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // TODO:
                // Este metodo fecha a Activity Two
                finish();
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
        Log.i(TAG, "Entered the onStart() method - ActivityTwo");
    }

    @Override
    public void onResume() {
        super.onResume();

        contOnResume++;
        updateTextViews();

        // Emit LogCat message
        Log.i(TAG, "Entered the onResume() method - ActivityTwo");
    }

    @Override
    public void onPause() {
        super.onPause();

        // Emit LogCat message
//        Log.i(TAG, "Entered the onPause() method");
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
        Log.i(TAG, "Entered the onRestart() method - ActivityTwo");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        // Emit LogCat message
        Log.i(TAG, "Entered the onDestroy() method *************** TESTE");
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        // Save the user's current game state
        savedInstanceState.putInt(CREATE_KEY, contOnCreate);
        savedInstanceState.putInt(START_KEY, contOnStart);
        savedInstanceState.putInt(RESUME_KEY, contOnResume);
        savedInstanceState.putInt(RESTART_KEY, contOnRestart);


        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }
}

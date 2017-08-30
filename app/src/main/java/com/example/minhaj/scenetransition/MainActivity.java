package com.example.minhaj.scenetransition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    private Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void setUpTransition() {
        //Transition fade = TransitionInflater.from(this).inflateTransition(R.transition.fade_transition);
        //Transition fade = new Fade();
        Scene scene = Scene.getSceneForLayout(frameLayout,R.layout.transition_two,this);
        TransitionManager.go(scene);
    }

    private void init() {
        frameLayout = (FrameLayout) findViewById(R.id.container);
        button1 = (Button) findViewById(R.id.button);
        setClickListeners();
    }

    private void setClickListeners() {
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                Log.d("tag",button.getText().toString());
                if (button.getText().equals("Button1"))
                setUpTransition();
                else
                    setUpTransition2();
            }
        });
    }

    private void setUpTransition2() {
        Log.d("tag","2");
        Scene scene = Scene.getSceneForLayout(frameLayout,R.layout.transition_one,this);
        TransitionManager.go(scene);
    }
}

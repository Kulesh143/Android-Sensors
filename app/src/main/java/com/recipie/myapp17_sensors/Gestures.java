package com.recipie.myapp17_sensors;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

public class Gestures extends AppCompatActivity {

    GestureDetectorCompat compat ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestures);

        final TextView textView = findViewById(R.id.gesture_text);

        GestureDetector.OnDoubleTapListener listener = new GestureDetector.OnDoubleTapListener() {
            @Override
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                textView.setText("Single Tap");
                return false;
            }

            @Override
            public boolean onDoubleTap(MotionEvent motionEvent) {
                textView.setText("Double Tap");
                return false;
            }

            @Override
            public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                textView.setText("Double Tap Event");
                return false;
            }
        };

        GestureDetector.OnGestureListener listener1 = new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                textView.setText("Motion Event");
                return false;
            }

            @Override
            public void onShowPress(MotionEvent motionEvent) {
                textView.setText("On Show Press");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                textView.setText("On Single Tap Up");
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                System.out.println("On Scroll");
                textView.setText("Scroll"+"x ="+v+"y ="+v1
                );
                return false;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {
                textView.setText("Long Press");
            }

            @Override
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                textView.setText("On Fling");
                return false;
            }
        };

        compat = new GestureDetectorCompat(this,listener1);
        compat.setOnDoubleTapListener(listener);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(compat.onTouchEvent(event)){
            return true ;
        }
        return super.onTouchEvent(event);
    }
}

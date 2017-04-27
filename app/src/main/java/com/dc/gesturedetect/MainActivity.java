package com.dc.gesturedetect;

import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements
                            GestureDetector.OnGestureListener,
                            GestureDetector.OnDoubleTapListener {
    private TextView output_text;
    private GestureDetectorCompat DetectMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output_text = (TextView) findViewById(R.id.outputText);
        DetectMe = new GestureDetectorCompat(this,this);
        DetectMe.setOnDoubleTapListener(this);

        findViewById(R.id.btn_clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                output_text.setText("event callback:\n");
            }
        });
    }

// Following functions are overrided to show text when a particular method called.

    // OnDoubleTapListener
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        appendText("onSingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        appendText("onDoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        appendText("onDoubleTapEvent");
        return true;
    }

    // OnGestureListener

    @Override
    public boolean onDown(MotionEvent e) {
        appendText("onDown");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        appendText("onShowPress");

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        appendText("onSingleTapUp");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        appendText("onScroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        appendText("onLongPress");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        appendText("onFling");
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.DetectMe.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private void appendText(String str) {
        String org = output_text.getText().toString();
        org += str + "\n";
        output_text.setText(org);
    }
}

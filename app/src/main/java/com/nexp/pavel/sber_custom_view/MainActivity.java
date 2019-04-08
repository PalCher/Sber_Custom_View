package com.nexp.pavel.sber_custom_view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private MyRectangle myRectangle;
    private Button update;
    private EditText editTextColor;
    private EditText editTextWidth;
    private EditText editTextHeight;
    private TextView textViewX;
    private TextView textViewY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initListeners();
        init();
    }

    private void init(){
        myRectangle.resize(Integer.parseInt(editTextWidth.getText().toString()), Integer.parseInt(editTextHeight.getText().toString()));
        myRectangle.changeColor(getResources().getColor(R.color.colorPrimary));
    }

    private void initViews() {
        myRectangle = findViewById(R.id.rectangle);
        update = findViewById(R.id.update);
        editTextColor = findViewById(R.id.edittext_color);
        editTextWidth = findViewById(R.id.edittext_width);
        editTextHeight = findViewById(R.id.edittext_height);
        textViewX = findViewById(R.id.rect_x);
        textViewY = findViewById(R.id.rect_y);
    }

    private void initListeners() {
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRectangle.resize(Integer.parseInt(editTextWidth.getText().toString()), Integer.parseInt(editTextHeight.getText().toString()));
                myRectangle.changeColor(getResources().getColor(R.color.colorPrimaryDark));
            }
        });

        myRectangle.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float x = event.getX();
                float y = event.getY();

                switch (event.getAction()){
                    case MotionEvent.ACTION_MOVE:
                        v.setX(x);
                        v.setY(y);
                        v.invalidate();
                        textViewX.setText(String.valueOf(x));
                        textViewY.setText(String.valueOf(y));
                }
                return true;
            }
        });
    }
}

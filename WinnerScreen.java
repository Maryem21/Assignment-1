package com.example.maryem.game;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Maryem on 3/18/2017.
 */
public class WinnerScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button b1 = (Button) findViewById(R.id.button4);
        Intent caller = getIntent();
        // float rating=caller.getFloatExtra("number of stars",0);
        String winner = caller.getStringExtra("Winner is ");
        TextView textView = (TextView) findViewById(R.id.textView3);
        textView.setText(winner+" is the Winner!!!");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_main);
            }
        });

    }
}

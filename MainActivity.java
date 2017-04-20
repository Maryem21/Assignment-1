package com.example.maryem.game;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int dis = 0;
    Drawable d;
    int x1, x2 = 0;
    int y1, y2 = 0;
    int player1 = 1;
    int player2 = 0;
    int x = 0;
    int row = 1;
    int row2 = 1;
    ImageButton comp, you;
    String winner=null;
    int exit=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //int i=10;
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = (Button) findViewById(R.id.button3);
        comp = (ImageButton) findViewById(R.id.imageButton);
        you = (ImageButton) findViewById(R.id.you);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int random = rand();
                if (random == 1) {
                    ImageView im = (ImageView) findViewById(R.id.imageView2);
                    im.setImageResource(R.drawable.d1);
                } else if (random == 2) {
                    ImageView im = (ImageView) findViewById(R.id.imageView2);
                    im.setImageResource(R.drawable.d2);
                } else if (random == 3) {
                    ImageView im = (ImageView) findViewById(R.id.imageView2);
                    im.setImageResource(R.drawable.d3);
                } else if (random == 4) {
                    ImageView im = (ImageView) findViewById(R.id.imageView2);
                    im.setImageResource(R.drawable.d4);
                } else if (random == 5) {
                    ImageView im = (ImageView) findViewById(R.id.imageView2);
                    im.setImageResource(R.drawable.d5);
                } else if (random == 6) {
                    ImageView im = (ImageView) findViewById(R.id.imageView2);
                    im.setImageResource(R.drawable.d6);
                }
                System.out.println(random);
                if (player1 == 1) {
                    movement1(random);
                    --player1;
                    ++player2;
                } else if (player2 == 1) {
                    movement2(random);
                    --player2;
                    ++player1;
                }
            }
        });


    }

    public int rand() {
        Random r = new Random();
        int i1 = r.nextInt(6) + 1;
        return i1;
    }

    public void movement1(int random) {

        for (int i = random; i > 0; i--) {
            int casee = check_Case1();
            System.out.println("this is case" + casee);
            switch (casee) {
                case 1: //right
                    comp.setX(x1+ 50);
                    x1 = (int) comp.getX();
                    y1 = (int) comp.getY();
                    System.out.println("this is case1 x1 " + x1);
                    System.out.println("this is case1 y1 " + y1);

                    break;
                case 2: // movement in left direction
                    //comp.setY(y1 - 50);
                    comp.setX(x1 - 50);
                    x1 = (int) comp.getX();
                    y1 = (int) comp.getY();
                    System.out.println("this is case2 x1 " + x1);
                    System.out.println("this is case2 y1 " + y1);
                    break;
                case 3: // right upward
                    comp.setY(y1 - 50);
                    comp.setX(x1 -  50);
                    ++row;
                    System.out.println("row is "+row);
                    x1 = (int) comp.getX();
                    y1 = (int) comp.getY();
                    System.out.println("this is case3 x1 " + x1);
                    System.out.println("this is case3 y1 " + y1);
                    break;
                case 4: //left upward
                    comp.setY(y1 - 50);
                    comp.setX(x1+ 50);
                    ++row;
                    System.out.println("row is "+row);
                    x1 = (int) comp.getX();
                    y1 = (int) comp.getY();
                    System.out.println("this is case4 x1 " + x1);
                    System.out.println("this is case2 y1 " + y1);
                    break;
                case 5: //left upward

                    //Toast.makeText(getApplicationContext(),rating + "stars",Toast.LENGTH_SHORT).show();
                    Intent gotosecond=new Intent();
                    gotosecond.setClass(this,WinnerScreen.class);
                    gotosecond.putExtra("Winner is ",winner);
                    startActivity(gotosecond);
                    ++exit;
                    break;

            }
            if(exit==1){
                break;
            }


        }
    }
    public void movement2(int random) {

        for (int i = random; i > 0; i--) {
            int casee = check_Case2();
            System.out.println("this is case" + casee);
            switch (casee) {
                case 1: //right
                    you.setX(x2 + 50);
                    x2 = (int) you.getX();
                    y2 = (int) you.getY();
                    System.out.println("this is case1 x2 " + x2);
                    System.out.println("this is case1 y2 " + y2);

                    break;
                case 2: // movement in left direction
                    //comp.setY(y1 - 50);
                    you.setX(x2 - 50);
                    x2 = (int) you.getX();
                    y2 = (int) you.getY();
                    System.out.println("this is case2 x1 " + x2);
                    System.out.println("this is case2 y1 " + y2);
                    break;
                case 3: // right upward
                    you.setY(y2 - 50);
                    you.setX(x2 - 50);
                    ++row2;
                    System.out.println("row is " + row);
                    x2 = (int) you.getX();
                    y2 = (int) you.getY();
                    System.out.println("this is case3 x1 " + x2);
                    System.out.println("this is case3 y1 " + y2);
                    break;
                case 4: //left upward
                    you.setY(y2 - 50);
                    you.setX(x2 + 50);
                    ++row2;
                    System.out.println("row is " + row);
                    x2 = (int) you.getX();
                    y2 = (int) you.getY();
                    System.out.println("this is case4 x1 " + x2);
                    System.out.println("this is case2 y1 " + y2);
                    break;
                case 5: //left upward

                    //Toast.makeText(getApplicationContext(),rating + "stars",Toast.LENGTH_SHORT).show();
                    Intent gotosecond = new Intent();
                    gotosecond.setClass(this, WinnerScreen.class);
                    gotosecond.putExtra("Winner is ", winner);
                    startActivity(gotosecond);
                    ++exit;
                    break;

            }

            if(exit==1){
                break;
            }
        }
    }

    public int check_Case1() {
        int dir=0;
        System.out.println("checking the case");
        if (x1 >=0 && x1 <450 && row==1) {
            dir=1;


        }
        else if (x1 >=0 && x1 <450  && row==3) {
            dir=1;


        }
        else if (x1 >=0 && x1 <450  && row==5) {
            dir=1;


        }
        else if (x1 >=0 && x1 <450  && row==7) {
            dir=1;


        }
        else if (x1<450 && x1 <450  && row==9) {
            dir=1;


        }

        else if (x1 >= 450) {
            dir=3;

        }
        else if (x1>0 && row == 2 ) {
            dir=2;

        }
        else if (x1>0 &&  row == 4) {
            dir=2;

        }
        else if (x1>0 && row == 6 ) {
            dir=2;

        }
        else if (x1>0 &&  row == 8) {
            dir=2;

        }
        else if ( x1>0  &&  row == 10) {
            dir=2;
            if(x1 <= 50 && y1 == -6)
            {
                winner="Computer";
                System.out.println("Computer is winner");
                dir = 5;
            }

        }
        else if (x1 == 0 && row == 2 ) {
            dir=4;

        }
        else if (x1 == 0 &&  row == 4 ) {
            dir=4;

        }
        else if (x1 == 0 && row == 6 ) {
            dir=4;

        }
        else if (x1 == 0 && row == 8 ) {
            dir=4;

        }
        else if (x1 == 0 &&  row == 10) {
            dir=4;

        }

        System.out.println("this is dir " +dir );
        return dir;
    }

    public int check_Case2() {
        int dir=0;
        System.out.println("checking the case");
        if (x2 >=0 && x2 <450  && row2==1) {
            dir=1;


        }
        else if (x2 >=0 && x2 <450  && row2==3) {
            dir=1;


        }
        else if (x2 >=0 && x2 <450   && row2==5) {
            dir=1;


        }
        else if (x2 >=0 && x2 <450   && row2==7) {
            dir=1;


        }
        else if (x2 >=0 && x2 <450   && row2==9) {
            dir=1;


        }

        else if (x2 >= 450) {
            dir=3;

        }
        else if (x2>0 && row2 == 2 ) {
            dir=2;

        }
        else if (x2>0 &&  row2 == 4) {
            dir=2;

        }
        else if (x2>0 && row2 == 6 ) {
            dir=2;

        }
        else if (x2>0 &&  row2 == 8) {
            dir=2;

        }
        else if ( x2>0  &&  row2 == 10) {
            dir=2;
            if(x2 <= 50 && y2 == -6)
            {
                winner="You";
                System.out.println("hello can i come in?");
                dir = 5;
            }

        }
        else if (x2 == 0 && row2 == 2 ) {
            dir=4;

        }
        else if (x2 == 0 &&  row2 == 4 ) {
            dir=4;

        }
        else if (x2 == 0 && row2 == 6 ) {
            dir=4;

        }
        else if (x2 == 0 && row2 == 8 ) {
            dir=4;

        }
        else if (x2 == 0 &&  row2 == 10) {
            dir=4;

        }

        System.out.println("this is dir " +dir );
        return dir;
    }






}

package com.example.antikseruven;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;


public class MainActivity2 extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView=findViewById(R.id.imageView8);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity2.this,Login.class);
                startActivity(intent);
                finish();
            }
        },2000);

    }
}





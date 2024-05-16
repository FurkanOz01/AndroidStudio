package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class okmenu extends AppCompatActivity {
    Button button;
    TextView textView13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okmenu);
        button=findViewById(R.id.button);
        textView13=findViewById(R.id.textView13);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(okmenu.this, MainActivity.class);
                startActivity(intent);
            }
        });
        textView13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(okmenu.this, menu.class);
                startActivity(intent);
            }
        });
    }
}
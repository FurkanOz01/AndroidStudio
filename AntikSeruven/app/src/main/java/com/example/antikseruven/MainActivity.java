package com.example.antikseruven;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.antikseruven.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.imageView.setImageResource(R.drawable.green1);
                Intent intent=new Intent(MainActivity.this,level1.class);
                startActivity(intent);
            }
        });
        binding.imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.imageView2.setImageResource(R.drawable.green2);
                Intent intent=new Intent(MainActivity.this,level2.class);
                startActivity(intent);
            }
        });
        binding.imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.imageView3.setImageResource(R.drawable.green3);
                Intent intent=new Intent(MainActivity.this,level3.class);
                startActivity(intent);
            }
        });
        binding.imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.imageView4.setImageResource(R.drawable.green4);
                Intent intent=new Intent(MainActivity.this,level4.class);
                startActivity(intent);
            }
        });
        binding.imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.imageView5.setImageResource(R.drawable.green5);
                Intent intent=new Intent(MainActivity.this,level5.class);
                startActivity(intent);
            }
        });
        binding.imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.imageView6.setImageResource(R.drawable.green6);
                Intent intent=new Intent(MainActivity.this,level6.class);
                startActivity(intent);
            }
        });
        binding.imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.imageView7.setImageResource(R.drawable.green7);
                Intent intent=new Intent(MainActivity.this,level7.class);
                startActivity(intent);
            }
        });
    }
}
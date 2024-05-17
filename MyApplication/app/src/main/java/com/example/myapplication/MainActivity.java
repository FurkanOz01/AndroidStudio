package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    ImageView imageView4,imageView6,imageView7,imageView8,imageView9;
    TextView textView5;
    ProgressBar progressBar2;
    int sayi,sayac,val,deger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView5=findViewById(R.id.textView5);
        imageView4=findViewById(R.id.imageView4);
        imageView6=findViewById(R.id.imageView6);
        imageView7=findViewById(R.id.imageView7);
        imageView8=findViewById(R.id.imageView8);
        imageView9=findViewById(R.id.imageView9);
        progressBar2 = (ProgressBar)findViewById(R.id.progressBar2);
        rastgele();
        deger=Integer.parseInt(textView5.getText().toString());

        Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run()
            {
                val=val+9;
                progressBar2.setProgress(val);
                if(val >= 100){
                    t.cancel();
                    Intent intent=new Intent(MainActivity.this,gameover.class);
                    startActivity(intent);
                }//progress bar 100 ü geçtiğinde gameover sayfasıan hönlendirilir
            }
        };
        t.schedule(tt,0,100);
        //progressbar ın çalışması için gereken kodlar

            if (sayi==1){imageView4.setImageResource(R.drawable.baseline_arrow_back_24);}
            else if (sayi==2){imageView4.setImageResource(R.drawable.baseline_arrow_downward_24);}
            else if (sayi==3){imageView4.setImageResource(R.drawable.baseline_arrow_forward_24);}
            else if (sayi==4){imageView4.setImageResource(R.drawable.baseline_arrow_upward_24);}
            //okun rastgele değişmesi(sağ sol yukarı aşağı)
            imageView6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (sayi==1){
                        rastgele();
                        sayac++;
                        textView5.setText(String.valueOf(sayac));
                        if (sayi==1){imageView4.setImageResource(R.drawable.baseline_arrow_back_24);}
                        else if (sayi==2){imageView4.setImageResource(R.drawable.baseline_arrow_downward_24);}
                        else if (sayi==3){imageView4.setImageResource(R.drawable.baseline_arrow_forward_24);}
                        else if (sayi==4){imageView4.setImageResource(R.drawable.baseline_arrow_upward_24);}
                        val=0;
                    }
                    else{
                        sayac--;
                        textView5.setText(String.valueOf(sayac));
                    }
                    //eğer imageview6 ya tıklandığında üstte gösterilen ok resimdekiyle aynı yöndeyse skora 1 eklenir
                    //bar sıfırlanır ve üstteki oku yeniden rastgele değiştirir basıldığında yukarıdaki okla aynı
                    //değilse yani sayi 1 e eşit değilse skoru azaltır bar sıfırlanmaz devam eder
                }});

            imageView7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (sayi==2){
                        rastgele();
                        sayac++;
                        textView5.setText(String.valueOf(sayac));
                        if (sayi==1){imageView4.setImageResource(R.drawable.baseline_arrow_back_24);}
                        else if (sayi==2){imageView4.setImageResource(R.drawable.baseline_arrow_downward_24);}
                        else if (sayi==3){imageView4.setImageResource(R.drawable.baseline_arrow_forward_24);}
                        else if (sayi==4){imageView4.setImageResource(R.drawable.baseline_arrow_upward_24);}
                        val=0;
                    }
                    else{
                        sayac--;
                        textView5.setText(String.valueOf(sayac));
                    }
                }
            });
            imageView8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (sayi==3){
                        rastgele();
                        sayac++;
                        textView5.setText(String.valueOf(sayac));
                        if (sayi==1){imageView4.setImageResource(R.drawable.baseline_arrow_back_24);}
                        else if (sayi==2){imageView4.setImageResource(R.drawable.baseline_arrow_downward_24);}
                        else if (sayi==3){imageView4.setImageResource(R.drawable.baseline_arrow_forward_24);}
                        else if (sayi==4){imageView4.setImageResource(R.drawable.baseline_arrow_upward_24);}
                        val=0;

                    }
                    else{
                        sayac--;
                        textView5.setText(String.valueOf(sayac));

                    }
                }
            });

            imageView9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (sayi==4){
                        rastgele();
                        sayac++;
                        textView5.setText(String.valueOf(sayac));
                        if (sayi==1){imageView4.setImageResource(R.drawable.baseline_arrow_back_24);}
                        else if (sayi==2){imageView4.setImageResource(R.drawable.baseline_arrow_downward_24);}
                        else if (sayi==3){imageView4.setImageResource(R.drawable.baseline_arrow_forward_24);}
                        else if (sayi==4){imageView4.setImageResource(R.drawable.baseline_arrow_upward_24);}
                        val=0;
                    }
                    else{
                        sayac--;
                        textView5.setText(String.valueOf(sayac));
                    }
                }
            });






    }
    void rastgele(){
        Random rnd=new Random();
        sayi=rnd.nextInt(4)+1;


    }
}
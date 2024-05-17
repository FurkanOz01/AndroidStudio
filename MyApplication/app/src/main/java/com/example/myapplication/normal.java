package com.example.myapplication;

import static android.view.View.GONE;
import static kotlin.random.RandomKt.Random;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class normal extends AppCompatActivity {

    Button button1,button4;
    EditText editText1;
    TextView textView,textView1,textView2,textView3,textView9;
    ImageView imageView;

    int s1,s2,sonuc,sayi,sayac,op;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        button1=findViewById(R.id.button1);
        button4=findViewById(R.id.button4);
        editText1=findViewById(R.id.editText1);
        textView=findViewById(R.id.textView);
        textView1=findViewById(R.id.textView1);
        textView2=findViewById(R.id.textView2);
        textView9=findViewById(R.id.textView9);
        textView3=findViewById(R.id.textView3);
        imageView=findViewById(R.id.imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(normal.this, menu.class);
                startActivity(intent);
            }});//menüye geri dönmek için

        rastgele();//rastgele sayıları üretiyor

        textView3.setVisibility(View.INVISIBLE);
        if (op==0){textView.setText("+");sonuc=s1+s2;}
        else if (op==1){textView.setText("-");sonuc=s1-s2;
            if (s2>s1){sonuc=s2-s1;}}
        else if (op==2){textView.setText("x");sonuc=s1*s2;}
        else if (op==3){textView.setText("/");sonuc=s1/s2;}
        //opdeğişkeni 0-4 arasında rastgele sayı üretir daha sonra gelen sayıya göre işlem yapılır

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sayi=Integer.parseInt(editText1.getText().toString());
                if (sayi==sonuc){
                    rastgele();
                    sayac++;
                    textView9.setText(String.valueOf(sayac));
                    editText1.setText("");
                    textView3.setVisibility(View.INVISIBLE);
                    if (op==0){textView.setText("+");sonuc=s1+s2;}
                    else if (op==1){textView.setText("-");sonuc=s1-s2;
                        if (s2>s1){sonuc=s2-s1;}}
                    else if (op==2){textView.setText("x");sonuc=s1*s2;}
                    else if (op==3){textView.setText("/");sonuc=s1/s2;}
                    textView3.setVisibility(View.INVISIBLE);
                }
                else {
                    sayac--;
                    textView9.setText(String.valueOf(sayac));
                    editText1.setText("");
                    button4.setVisibility(View.VISIBLE);

                }
            }
        });
        //gönder butonuna bastıktan sonra sonuc doğru girilmişse yendien rastgele
        //sayılar üretilir ve operatörler yeniden rastgele seçilir , sonuc yanlışsa
        //geç butonu gelir ve basarsak cevabı gösterir

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView3.setText(String.valueOf(sonuc));
                textView3.setVisibility(View.VISIBLE);
                button4.setVisibility(View.INVISIBLE);
            }
        });


    }
    void rastgele(){
        Random rnd=new Random();
        s1=rnd.nextInt(10)+5;
        s2=rnd.nextInt(10)+5;
        op=rnd.nextInt(4);
        textView1.setText(String.valueOf(s1));
        textView2.setText(String.valueOf(s2));
        //ilk olarak işlem yapacağımız sayılar belirlernir daha sonra rastgele operatör seçmek
        //için 4 tane rastgele sayı oluşturulacak ardından her bir sayıya göre operatörler yerleştirilecek
    }

}

package com.example.antikseruven;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class level2 extends AppCompatActivity implements View.OnClickListener {

    TextView txtSoru,sayac;
    Button btnCevapA,btnCevapB,btnCevapC,btnCevapD;
    Button btnGonder;
    int puan=0;
    int toplamSoru=Sorucevap.soru.length;
    int sorulacak=0;
    String secilenCevap="";
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);
        txtSoru=findViewById(R.id.soru);
        sayac=findViewById(R.id.sayac);
        btnCevapA=findViewById(R.id.cevap_A);
        btnCevapB=findViewById(R.id.cevap_B);
        btnCevapC=findViewById(R.id.cevap_C);
        btnCevapD=findViewById(R.id.cevap_D);
        btnGonder=findViewById(R.id.gonder);

        btnCevapA.setOnClickListener(this);
        btnCevapB.setOnClickListener(this);
        btnCevapC.setOnClickListener(this);
        btnCevapD.setOnClickListener(this);
        btnGonder.setOnClickListener(this);


        SoruGetir();
        countDownTimer= new CountDownTimer(11000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                sayac.setText(""+millisUntilFinished/1000);
            }
            @Override
            public void onFinish() {
                Toast.makeText(level2.this, "Süreniz Doldu", Toast.LENGTH_SHORT).show();
                TestBitir();
            }
        }.start();
    }

    private void SoruGetir() {
        Reset();
        if(sorulacak==10){
            TestBitir();
            return;
        }
        Random rand = new Random();
        int n = rand.nextInt(100);
        txtSoru.setText(Sorucevap.soru[n]);
        btnCevapA.setText(Sorucevap.secenek[sorulacak][0]);
        btnCevapB.setText(Sorucevap.secenek[sorulacak][1]);
        btnCevapC.setText(Sorucevap.secenek[sorulacak][2]);
        btnCevapD.setText(Sorucevap.secenek[sorulacak][3]);
    }

    private void TestBitir() {

        new AlertDialog.Builder(this)
                .setMessage("10 sorudan "+puan+" adet doğru cevap verdiniz.")
                .setNegativeButton("Geri Dön",((dialog, which) -> Geridon()))
                .setPositiveButton("Tekrar",((dialog, which) -> Tekrarla()))
                .setCancelable(false)
                .show();


    }

    private void Tekrarla() {
        puan=0;
        sorulacak=0;
        SoruGetir();
    }
    private void Geridon() {
        Intent intent=new Intent(level2.this,MainActivity.class);
        startActivity(intent);
    }
    private void Reset() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
            countDownTimer.start();
        }
    }

    @Override
    public void onClick(View v) {

        btnCevapA.setBackgroundColor(Color.parseColor("#C9B9A1"));
        btnCevapB.setBackgroundColor(Color.parseColor("#B19981"));
        btnCevapC.setBackgroundColor(Color.parseColor("#98775E"));
        btnCevapD.setBackgroundColor(Color.parseColor("#7A5139"));

        Button btnTiklanan=(Button) v;
        if(btnTiklanan.getId()==R.id.gonder){

            if(secilenCevap.equals(Sorucevap.dogruCevap[sorulacak])){
                puan++;
            }
            sorulacak++;
            SoruGetir();

        }else{
            secilenCevap=btnTiklanan.getText().toString();
            btnTiklanan.setBackgroundColor(Color.GREEN);

        }
    }
}

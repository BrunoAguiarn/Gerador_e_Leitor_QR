package br.com.brunoaguiar.geradoreleitordeqr;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class geradorActivity extends Activity {

    ImageView ivQrCode;
    Handler handler;
    long tempoRestante = 20000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gerador_activity);

        inicializarComponentes();

        handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                array();
                tempoRestante = tempoRestante - 5000;
                if(tempoRestante > 0) {
                    handler.postDelayed(this, 5000);
                }
            }
        };
        handler.postDelayed(runnable, 0);


    }


    private void inicializarComponentes() {
        ivQrCode = (ImageView) findViewById(R.id.ivQrCode);
    }


    public void array() {
        final List objetos = new ArrayList();
        objetos.add("Bruno 2018 1234 310");
        objetos.add("Bruno 2018 310 2018");
        objetos.add("Bruno 1234 2018 310");
        objetos.add("Bruno 1234 310 2018");
        objetos.add("Bruno 310 1234 2018");
        objetos.add("Bruno 310 2018 1234");

        objetos.add("2018 310 1234 Bruno");
        objetos.add("2018 310 Bruno 1234");
        objetos.add("2018 1234 Bruno 310");
        objetos.add("2018 1234 310 Bruno");
        objetos.add("2018 Bruno 1234 310");
        objetos.add("2018 Bruno 310 1234");

        objetos.add("1234 2018 Bruno 310");
        objetos.add("1234 2018 310 Bruno");
        objetos.add("1234 Bruno 310 2018");
        objetos.add("1234 Bruno 2018 310");
        objetos.add("1234 310 Bruno 2018");
        objetos.add("1234 310 2018 Bruno");

        objetos.add("310 2018 Bruno 1234");
        objetos.add("310 2018 1234 Bruno");
        objetos.add("310 1234 Bruno 2018");
        objetos.add("310 1234 2018 Bruno");
        objetos.add("310 Bruno 2018 1234");
        objetos.add("310 Bruno 1234 2018");


        Random random = new Random();
        Object sorteada = objetos.get(random.nextInt(objetos.size()));
        System.out.println("Tamanho inicial lista: " + objetos.size());

        String texto = sorteada.toString();
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();

        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(texto, BarcodeFormat.QR_CODE, 2000, 2000);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            ivQrCode.setImageBitmap(bitmap);
        } catch (WriterException e){
            e.printStackTrace();}
    }



    private void alert(String mensagem){
        Toast.makeText(this, mensagem,Toast.LENGTH_SHORT).show();
    }
}







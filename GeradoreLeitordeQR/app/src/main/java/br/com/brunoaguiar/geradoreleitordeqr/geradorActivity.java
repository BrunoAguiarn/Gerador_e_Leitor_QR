package br.com.brunoaguiar.geradoreleitordeqr;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
    Button trocar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gerador_activity);

        inicializarComponentes();
        array();

           /*int delay = 1000;
            int interval = 5000;
            Timer timer = new Timer();

            timer.scheduleAtFixedRate(new TimerTask() {
                public void run() {
                    array();
                }
            }, delay, interval);
            */

        trocar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                array();
            }
        });
    }



    private void inicializarComponentes() {
        ivQrCode = (ImageView) findViewById(R.id.ivQrCode);
        trocar = findViewById(R.id.trocar);
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
                } catch (WriterException e) {
                    e.printStackTrace();
                }

            }




        }








package br.com.brunoaguiar.geradoreleitordeqr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class leitorActivity extends Activity {

    Button btnScan;
    TextView textoDoCodigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leitor_activity);
        btnScan = (Button) findViewById(R.id.btnScan);
        final Activity activity = this;



        btnScan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                IntentIntegrator integrator=new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Camera Scan");
                integrator.setCameraId(0);
                integrator.initiateScan();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null){
            if(result.getContents() != null){
                textoDoCodigo = (TextView) findViewById(R.id.textoDoCodigo);
                textoDoCodigo.setText(result.getContents());
            }else{
                alert("Scan Cancelado");
            }

        }else{
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


    private void alert (String msg){
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }

}

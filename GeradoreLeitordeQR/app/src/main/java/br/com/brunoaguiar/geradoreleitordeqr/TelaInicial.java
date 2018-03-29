package br.com.brunoaguiar.geradoreleitordeqr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaInicial extends AppCompatActivity {

    Button botaoGerador;
    Button botaoLeitor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);


    }
    public void gerador(View view){

        Intent intent = new Intent(getBaseContext(), geradorActivity.class);
        startActivity(intent);
    }
    public void leitor(View view){

        Intent intent = new Intent(getBaseContext(), leitorActivity.class);
        startActivity(intent);
    }
}

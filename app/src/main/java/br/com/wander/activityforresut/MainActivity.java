package br.com.wander.activityforresut;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Praticando - startActivityForResult");

    }

    public void somar(View v){

        Intent i = new Intent();
        i.setClass(MainActivity.this,ResultadoActivity.class);
        i.putExtra("operacao","somar");
        startActivityForResult(i,ResultConstants.REQUEST_RESULTADO);

    }

    public void subtrair(View v){
        Intent i = new Intent();
        i.setClass(MainActivity.this,ResultadoActivity.class);
        i.putExtra("operacao","subtrair");
        startActivityForResult(i,ResultConstants.REQUEST_RESULTADO);
    }

    public void multiplicar(View v){
        Intent i = new Intent();
        i.setClass(MainActivity.this,ResultadoActivity.class);
        i.putExtra("operacao","multiplicar");
        startActivityForResult(i,ResultConstants.REQUEST_RESULTADO);
    }

    public void dividir(View v){
        Intent i = new Intent();
        i.setClass(MainActivity.this,ResultadoActivity.class);
        i.putExtra("operacao","dividir");
        startActivityForResult(i,ResultConstants.REQUEST_RESULTADO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        //Se o requestCode for REQUEST_RESULTADO E O ResultCode for RESULT_OK
             if (requestCode == ResultConstants.REQUEST_RESULTADO && resultCode == RESULT_OK) {
                 TextView txtResultado = (TextView) findViewById(R.id.txtResultado);

                 txtResultado.setText(String.valueOf(data.getDoubleExtra("resultado", 0)));
             }

         }
}

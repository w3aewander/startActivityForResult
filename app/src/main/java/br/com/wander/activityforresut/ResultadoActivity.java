package br.com.wander.activityforresut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        setTitle(getIntent().getStringExtra("operacao"));


    }

    public void executarOperacao(View v){

        Intent i = getIntent();

        String operacao = i.getStringExtra("operacao");

        EditText txtNum1 = (EditText) findViewById(R.id.edtNum1);
        EditText txtNum2 = (EditText) findViewById(R.id.edtNum2);


        double num1 = Double.parseDouble( txtNum1.getText().toString() );
        double num2 = Double.parseDouble( txtNum2.getText().toString() );
        double resultado = 0;

        switch(operacao){

            case "somar":
                resultado = num1 + num2;
                break;

            case "multiplicar":
                resultado = num1 * num2;
                break;

            case "subtrair":
                resultado = num1 - num2;
                break;

            case "dividir":
                if ( num1 == 0 || num2 == 0 ) {
                    Toast.makeText(this,
                            "Operador e operando não pode ser zero (0)",
                            Toast.LENGTH_LONG).show();
                } else {
                    resultado = num1 / num2;
                }
                break;

            default:
                resultado = 0;
        }

        Intent r = new Intent();
        r.putExtra("resultado",resultado);

        setResult(RESULT_OK,r);
        //setResult(ResultConstants.REQUEST_RESULTADO,r);

        finish();

    }
}

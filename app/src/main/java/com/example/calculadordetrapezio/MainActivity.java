package com.example.calculadordetrapezio;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private EditText etBaseMaior;
    private EditText etBaseMenor;
    private EditText etAltura;
    private Button calcular;
    private TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etBaseMaior =  findViewById(R.id.etBaseMaior);
        etBaseMaior.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        etBaseMenor = findViewById(R.id.etBaseMenor);
        etBaseMenor.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        etAltura = findViewById(R.id.etAltura);
        etAltura.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvResult = findViewById(R.id.tvResult);
        tvResult.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        calcular = findViewById(R.id.btnCalc);
        calcular.setOnClickListener(op -> Calc());



    }

    public void Calc (){
        int maiorB = Integer.parseInt(etBaseMaior.getText().toString());
        int menorB = Integer.parseInt(etBaseMenor.getText().toString());
        int alt = Integer.parseInt(etAltura.getText().toString());
        int calculo = ((maiorB + menorB) * alt /2);
        String resp = getString(R.string.resultado) + calculo;
        tvResult.setText(resp);
        etBaseMenor.setText("");
        etBaseMaior.setText("");
        etAltura.setText("");

    }

}
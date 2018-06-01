package com.example.user1.puntowifi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class CalcularPuntosActivity extends AppCompatActivity {

    Button calcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_puntos);

        calcular=(Button)findViewById(R.id.btnCalcular);

        calcular.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                //

            }

        });


    }
}
package com.example.user1.puntowifi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class InfoPuntoActivity extends AppCompatActivity {
    Button ubicarPunto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_punto);

        ubicarPunto=(Button)findViewById(R.id.btnUbicarPunto);

        ubicarPunto.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent =new Intent(InfoPuntoActivity.this,MapsActivity.class);
                startActivity(intent);
            }

        });

    }
}

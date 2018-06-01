package com.example.user1.puntowifi;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button zonaWifi, conectate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zonaWifi=(Button)findViewById(R.id.btnZonaWifi);

        zonaWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);

            }


});
        conectate=(Button)findViewById(R.id.btnConectate);

        conectate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 =new Intent(MainActivity.this,ActivityInfo.class);
                startActivity(intent2);
            }

        });


    }
}

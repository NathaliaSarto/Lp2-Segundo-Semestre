package com.example.alunos.mapmarker;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn_ver;
    Button btn_mos;
    TextView text_dec1;
    TextView text_dec2;
    private static final int REQUEST_CODE_PERMISSION = 2;
    String mPermission = Manifest.permission.ACCESS_FINE_LOCATION;
    GPSTracker gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
            if (ActivityCompat.checkSelfPermission(this, mPermission)
                    != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, new String[]{mPermission},
                        REQUEST_CODE_PERMISSION);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        btn_ver = (Button) findViewById(R.id.btn_ver);
        text_dec1 = (TextView) findViewById(R.id.text_dec1);
        text_dec2 = (TextView) findViewById(R.id.text_dec2);

        btn_ver.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                gps = new GPSTracker(MainActivity.this);

                if(gps.canGetLocation()){
                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();

                    text_dec1.setText(String.valueOf(latitude));
                    text_dec2.setText (String.valueOf(longitude));
                }else{
                    text_dec1.setText("Não disponível...");
                    text_dec2.setText("Não disponível...");
                    gps.showSettingsAlert();
                }
            }
        });

        btn_mos = (Button) findViewById(R.id.btn_mos);
        btn_mos.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent it = new Intent (MainActivity.this, MapsActivity.class);
                startActivity(it);
            }
        });

    }
}

package com.tugas.shinthya.shinthya_1202154311_sc3;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //membuat toast message ketika splash jalan akan  muncul tulisan dibawah
        Toast.makeText(this,"SHINTHYA YODA PUTRI_1202154311",Toast.LENGTH_SHORT).show();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //ketika splash sudah muncul maka akan langsung ke class LoginActivity
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
        //menentukan berapa detik splash muncul ketika di ran hanya 6 detik
            }
        }, 6000L); //60000 L = 6 detik
    }
}

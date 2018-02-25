package com.tugas.shinthya.shinthya_1202154311_sc3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    //membuat pada saat aplikasi dijalankan akan menggunakan layout dari activity_login.xml
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    //membuat akun pada saat login agar hanya dapat User EAD dan password MOBILE yang bisa akses
    public void Login(View view) {
        EditText username = findViewById(R.id.Txt_Uname);
        EditText password = findViewById(R.id.Txt_Pass);
        String message;
        if (username.getText().toString().equals("EAD") && password.getText().toString().equals("MOBILE")) {
            //ketika berhasil login muncul message berhasil login
            message = "Berhasil login";
            //ketika sudah bisa login akan masuk ke class MainActivity
            startActivity(new Intent(this, MainActivity.class));

        //kondisi ketika gagal login akan muncul message gagal login
        } else {
            message = "Gagal login";
            finish();
            startActivity(getIntent());
        }

        //cara memunculkan message dengan menggunakan toast
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

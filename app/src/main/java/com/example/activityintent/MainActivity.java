package com.example.activityintent;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.annotation.Target;

public class MainActivity extends AppCompatActivity {
    private EditText noTelepon;
    private EditText alamat;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noTelepon=(EditText)findViewById(R.id.noTelepon);
        alamat=(EditText)findViewById(R.id.alamat);
        btnSubmit=(Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent submit = new Intent(getApplicationContext(), Submit.class);
                startActivity(submit);
            }
        });
    }

    public void kirimSMS(View view) {
        Uri uri = Uri.parse("sms:" + noTelepon.getText().toString());
        Intent sendSMS = new Intent(Intent.ACTION_VIEW, uri);
        sendSMS.putExtra("sms_body", "Tugas Pemrograman Mobile 2205551102");

        Intent chooser = Intent.createChooser(sendSMS, "Pilih Aplikasi Pesan");

        if (chooser.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }
    }

    public void cariAlamat(View view) {
        Uri uri = Uri.parse("geo:0,0?q=" + alamat.getText().toString());
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri);
        mapIntent.setPackage("com.google.android.apps.maps");

        Intent chooser = Intent.createChooser(mapIntent, "Pilih Aplikasi Peta");

        if (chooser.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }
    }
}
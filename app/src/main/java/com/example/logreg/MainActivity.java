package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
    private DBHelper adatbazis;
    private EditText editTextFelhasznalonev, editTextJelszo;
    private Button buttonRegisztracio, buttonBejelentkezes;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        buttonRegisztracio.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent masikActivityre = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(masikActivityre);
                finish();
            }
        });
    }

    private void init()
    {
        adatbazis = new DBHelper(MainActivity.this);
        editTextFelhasznalonev = findViewById(R.id.editTextFelhasznalonev);
        editTextJelszo = findViewById(R.id.editTextJelszo);
        buttonRegisztracio = findViewById(R.id.buttonRegisztracio);
        buttonBejelentkezes = findViewById(R.id.buttonBejelentkezes);
    }
}
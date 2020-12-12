package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity
{
    private DBHelper adatbazis;
    private EditText editTextEmail, editTextFelhasznalonev, editTextJelszo, editTextTeljesnev;
    private Button buttonRegisztracio, buttonVissza;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        init();
        onClickListeners();

    }

    private void init()
    {
        adatbazis = new DBHelper(RegisterActivity.this);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextFelhasznalonev = findViewById(R.id.editTextFelhasznalonev);
        editTextJelszo = findViewById(R.id.editTextJelszo);
        editTextTeljesnev = findViewById(R.id.editTextTeljesnev);
        buttonRegisztracio = findViewById(R.id.buttonRegisztracio);
        buttonVissza = findViewById(R.id.buttonVissza);
    }

    private void onClickListeners()
    {
        buttonVissza.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent masikActivityre = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(masikActivityre);
                finish();
            }
        });

        buttonRegisztracio.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                adatRogzites();
            }
        });
    }
    private void adatRogzites()
    {
        String email = editTextEmail.getText().toString().trim();
        String felhnev = editTextFelhasznalonev.getText().toString().trim();
        String jelszo = editTextJelszo.getText().toString().trim();
        String valodinev = editTextTeljesnev.getText().toString().trim();
        if (email.isEmpty())
        {
            Toast.makeText(this, "E-mail cím megadása kötelező!", Toast.LENGTH_SHORT).show();
        }
        else if (felhnev.isEmpty())
        {
            Toast.makeText(this, "Felhasználónév megadása kötelező!", Toast.LENGTH_SHORT).show();
        }
        else if (jelszo.isEmpty())
        {
            Toast.makeText(this, "Jelszó megadása kötelező!", Toast.LENGTH_SHORT).show();
        }
        else if (valodinev.isEmpty())
        {
            Toast.makeText(this, "Valódi név megadása kötelező!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            boolean sikeres = adatbazis.adatRogzites(email,felhnev,jelszo,valodinev);
            if (sikeres)
            {
                Toast.makeText(this, "Sikeres regisztráció.", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "Sikertelen regisztráció.", Toast.LENGTH_LONG).show();
            }
        }
    }
}
package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private DBHelper adatbazis;
    private EditText editTextFelhasznalonev, editTextJelszo;
    private Button buttonRegisztracio, buttonBejelentkezes;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        onClickListeners();
    }

    private void init()
    {
        adatbazis = new DBHelper(MainActivity.this);
        editTextFelhasznalonev = findViewById(R.id.editTextFelhasznalonev);
        editTextJelszo = findViewById(R.id.editTextJelszo);
        buttonRegisztracio = findViewById(R.id.buttonRegisztracio);
        buttonBejelentkezes = findViewById(R.id.buttonBejelentkezes);
    }

    private void onClickListeners()
    {
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

        buttonBejelentkezes.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                bejelentkezes();
            }
        });
    }

    private void bejelentkezes()
    {
        String felh = editTextFelhasznalonev.getText().toString().trim();
        String jelszo = editTextJelszo.getText().toString().trim();
        Cursor adatok = adatbazis.adatKereses(felh, jelszo);

        if (felh.isEmpty())
        {
            Toast.makeText(this, "Töltsd ki a felhaszánlónév mezőt!", Toast.LENGTH_SHORT).show();
        }
        else if (jelszo.isEmpty())
        {
            Toast.makeText(this, "Töltsd ki a jelszó mezőt!", Toast.LENGTH_SHORT).show();
        }
        else {
            if (adatok == null) {
                Toast.makeText(this, "Hiba történt a bejelentkezéskor.", Toast.LENGTH_SHORT).show();
                return;
            }
            else if (adatok.getCount() == 0)
            {
                Toast.makeText(this, "Sikertelen bejelentkezés.", Toast.LENGTH_SHORT).show();
                return;
            }
            else
            {
                Toast.makeText(this, "Sikeres bejeltkezés.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
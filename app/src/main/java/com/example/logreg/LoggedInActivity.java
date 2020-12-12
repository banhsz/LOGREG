package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoggedInActivity extends AppCompatActivity
{
    private TextView textViewTeljesnev;
    private Button buttonKijelentkezes;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);

        init();
        onClickListeners();
    }

    private void init()
    {
        textViewTeljesnev = findViewById(R.id.textViewTeljesnev);
        buttonKijelentkezes = findViewById(R.id.buttonKijelentkezes);
        textViewTeljesnev.setText(getIntent().getStringExtra("valodinev"));
    }

    private void onClickListeners()
    {
        buttonKijelentkezes.setOnClickListener(new View.OnClickListener() 
        {
            @Override
            public void onClick(View v)
            {
                Intent masikActivityre = new Intent(LoggedInActivity.this, MainActivity.class);
                startActivity(masikActivityre);
                finish();
            }
        });
    }
}
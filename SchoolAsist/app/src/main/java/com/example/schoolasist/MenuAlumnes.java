package com.example.schoolasist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MenuAlumnes extends AppCompatActivity {

    private LinearLayout btnAssistencies, btnHoraris;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_alumnes);

        btnAssistencies = findViewById(R.id.btnAssistencies);
        btnHoraris = findViewById(R.id.btnHoraris);

        btnAssistencies.setOnClickListener(view -> {
            Intent intent = new Intent(MenuAlumnes.this,AsistenciesActivity.class);
            startActivity(intent);
        });

        btnHoraris.setOnClickListener(view -> {
            Intent intent = new Intent(MenuAlumnes.this,HorarisActivity.class);
            startActivity(intent);
        });
    }
}

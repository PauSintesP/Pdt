package com.example.schoolasist;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MenuAdmins extends AppCompatActivity {

    LinearLayout ePassarLlista,eHistorial,eModificarHorari,eAssistencies,eHorari;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_admins);

        ePassarLlista =findViewById(R.id.btnPassarLlista);
        eHistorial =findViewById(R.id.btnHistorial);
        eModificarHorari = findViewById(R.id.btnModificar);
        eAssistencies = findViewById(R.id.btnAssistencies);
        eHorari = findViewById(R.id.btnHoraris);

        ePassarLlista.setOnClickListener(view ->{
            Intent intent = new Intent(MenuAdmins.this,PassarLlistaActivity.class);
            startActivity(intent);
        });
        eHistorial.setOnClickListener(view ->{
            Intent intent = new Intent(MenuAdmins.this,HistorialActivity.class);
            startActivity(intent);
        });
        eModificarHorari.setOnClickListener(view ->{
            Intent intent = new Intent(MenuAdmins.this,ModificarHorariActivity.class);
            startActivity(intent);
        });
        eAssistencies.setOnClickListener(view ->{
            Intent intent = new Intent(MenuAdmins.this,AsistenciesActivity.class);
            startActivity(intent);
        });
        eHorari.setOnClickListener(view ->{
            Intent intent = new Intent(MenuAdmins.this,HorarisActivity.class);
            startActivity(intent);
        });
    }
}
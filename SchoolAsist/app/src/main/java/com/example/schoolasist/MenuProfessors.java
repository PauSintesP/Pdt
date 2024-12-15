package com.example.schoolasist;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MenuProfessors extends AppCompatActivity {

    LinearLayout btnPasarLista;
    LinearLayout btnHistorial;
    LinearLayout btnModificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_professors);

        // Inicializar las vistas después de setContentView()
        btnPasarLista = findViewById(R.id.btnPassarLlista);
        btnHistorial = findViewById(R.id.btnHistorial);
        btnModificar = findViewById(R.id.btnModificar);

        // Configurar los clics de los botones
        btnPasarLista.setOnClickListener(view -> {
            Intent intent = new Intent(MenuProfessors.this, PassarLlistaActivity.class);
            startActivity(intent);
        });

        btnHistorial.setOnClickListener(view -> {
            Intent intent = new Intent(MenuProfessors.this, HistorialActivity.class);
            startActivity(intent);
        });

        btnModificar.setOnClickListener(view -> {
            Intent intent = new Intent(MenuProfessors.this, ModificarHorariActivity.class);
            startActivity(intent);
        });
    }
}

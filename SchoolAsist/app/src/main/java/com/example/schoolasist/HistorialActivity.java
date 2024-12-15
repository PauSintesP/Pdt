package com.example.schoolasist;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistorialActivity extends AppCompatActivity {

    // Mapa de datos: clave = día, valor = lista de registros (cada registro es un array de Strings)
    Map<String, List<String[]>> datosAsistencia = new HashMap<>();
    private int diaActual = 0; // Índice para el día actual
    private String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes"}; // Días de la semana

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_historial);

        inicializarDatos(); // Llenar la estructura de datos inicial

        ImageButton flechaIzquierda = findViewById(R.id.btnDiaAnterior);
        ImageButton flechaDerecha = findViewById(R.id.btnDiaSiguiente);
        TextView tituloDia = findViewById(R.id.tvDiaActual);

        tituloDia.setText(dias[diaActual]); // Mostrar día inicial
        actualizarTabla(dias[diaActual]); // Mostrar tabla del primer día

        flechaIzquierda.setOnClickListener(v -> {
            if (diaActual > 0) {
                diaActual--;
                tituloDia.setText(dias[diaActual]);
                actualizarTabla(dias[diaActual]); // Actualizar la tabla
            }
        });

        flechaDerecha.setOnClickListener(v -> {
            if (diaActual < dias.length - 1) {
                diaActual++;
                tituloDia.setText(dias[diaActual]);
                actualizarTabla(dias[diaActual]); // Actualizar la tabla
            }
        });

        ImageButton btnBack = findViewById(R.id.btnAtras);
        btnBack.setOnClickListener(v -> onBackPressed());
    }

    // Inicializar datos de asistencia
    private void inicializarDatos() {
        datosAsistencia.put("Lunes", Arrays.asList(
                new String[]{"Marc Enrich", "01/06/2024", "Sí"},
                new String[]{"Ana López", "01/06/2024", "No"}
        ));
        datosAsistencia.put("Martes", Arrays.asList(
                new String[]{"Marc Enrich", "02/06/2024", "No"},
                new String[]{"Ana López", "02/06/2024", "Sí"}
        ));
        datosAsistencia.put("Miércoles", Arrays.asList(
                new String[]{"Pedro Enrich", "03/06/2024", "Sí"},
                new String[]{"Ana López", "03/06/2024", "Sí"}
        ));
        datosAsistencia.put("Jueves", Arrays.asList(
                new String[]{"Marc Enrich", "04/06/2024", "Sí"},
                new String[]{"Ana López", "04/06/2024", "No"}
        ));
        datosAsistencia.put("Viernes", Arrays.asList(
                new String[]{"Maria Cardona", "05/06/2024", "No"},
                new String[]{"Alan López", "05/06/2024", "Sí"}
        ));
    }

    // Actualiza la tabla con los datos del día seleccionado
    private void actualizarTabla(String dia) {
        TableLayout tabla = findViewById(R.id.tablaAsistencia);
        tabla.removeAllViews();

        // Crear cabecera de la tabla
        TableRow cabecera = new TableRow(this);
        agregarCeldaCabecera(cabecera, "Alumne");
        agregarCeldaCabecera(cabecera, "Fecha");
        agregarCeldaCabecera(cabecera, "Presencia");
        tabla.addView(cabecera);

        // Obtener datos del día
        List<String[]> datos = datosAsistencia.get(dia);

        // Agregar filas de datos
        if (datos != null) {
            for (String[] registro : datos) {
                TableRow fila = new TableRow(this);

                // Crear inputs para cada celda
                agregarCeldaInput(fila, registro[0]); // Alumne
                agregarCeldaInput(fila, registro[1]); // Fecha
                agregarCeldaInput(fila, registro[2]); // Presencia

                tabla.addView(fila);
            }
        }
    }

    // Método para agregar celda de cabecera
    private void agregarCeldaCabecera(TableRow fila, String texto) {
        TextView celda = new TextView(this);
        celda.setText(texto);
        celda.setTextSize(20);
        celda.setGravity(1);
        celda.setBackground(null);
        celda.setTypeface(null, Typeface.BOLD);
        celda.setPadding(8, 8, 8, 8);
        fila.addView(celda);
    }

    // Método para agregar celda con EditText (input)
    private void agregarCeldaInput(TableRow fila, String textoInicial) {
        EditText celdaInput = new EditText(this);
        celdaInput.setText(textoInicial);
        celdaInput.setTextSize(20);
        celdaInput.setGravity(1);
        celdaInput.setBackground(null); // Quitar el subrayado
        celdaInput.setPadding(8, 8, 8, 8);
        celdaInput.setSingleLine(true);
        fila.addView(celdaInput);
    }
}

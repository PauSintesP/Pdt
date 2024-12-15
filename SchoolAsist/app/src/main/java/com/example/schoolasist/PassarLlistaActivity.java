package com.example.schoolasist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class PassarLlistaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_passar_llista);

        ImageButton btnBack = findViewById(R.id.btnAtras);
        btnBack.setOnClickListener(v -> onBackPressed());

        Button btnCancelar = findViewById(R.id.btnCancelar);
        Button btnSiguiente = findViewById(R.id.btnSiguiente);
        btnSiguiente.setOnClickListener(view -> {
            Intent intent = new Intent(PassarLlistaActivity.this,CompletatActivity.class);
            startActivity(intent);
            finish();
        });

        TableLayout tableLayout = findViewById(R.id.tabla); // Dale un ID al TableLayout en XML

        btnCancelar.setOnClickListener(v -> {

            for (int i = 0; i < tableLayout.getChildCount(); i++) {
                View row = tableLayout.getChildAt(i);
                if (row instanceof TableRow) {
                    TableRow tableRow = (TableRow) row;

                    for (int j = 0; j < tableRow.getChildCount(); j++) {
                        View child = tableRow.getChildAt(j);
                        if (child instanceof CheckBox) {
                            ((CheckBox) child).setChecked(false);
                        }
                    }
                }
            }
        });

    }
}
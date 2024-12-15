package com.example.schoolasist;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    private EditText etCorreo, etContrasena, etrepecontra;
    private Button btnRregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        // Vincular vistas
        etCorreo = findViewById(R.id.etCorreo);
        etContrasena = findViewById(R.id.etContrasena);
        etrepecontra = findViewById(R.id.etRepetirContrasena);
        btnRregister = findViewById(R.id.btnRegister);

        btnRregister.setOnClickListener(v -> {
            String correo = etCorreo.getText().toString().trim();
            String contrasena = etContrasena.getText().toString().trim();
            String repcontra = etrepecontra.getText().toString().trim();

            // Verificar que todos los campos estén completos
            if (correo.isEmpty() || contrasena.isEmpty() || repcontra.isEmpty()) {
                Toast.makeText(RegisterActivity.this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validar formato del correo
            if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
                Toast.makeText(RegisterActivity.this, "Por favor, ingresa un correo válido", Toast.LENGTH_SHORT).show();
                return;
            }

            // Verificar que las contraseñas coincidan
            if (!contrasena.equals(repcontra)) {
                Toast.makeText(RegisterActivity.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                return;
            }

            // Registro exitoso
            Toast.makeText(RegisterActivity.this, "PERFECTO, usuario registrado\n" + correo, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }
}

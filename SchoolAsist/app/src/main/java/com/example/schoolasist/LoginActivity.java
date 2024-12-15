package com.example.schoolasist;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.schoolasist.R;

public class LoginActivity extends AppCompatActivity {

    private EditText etCorreo, etContrasena;
    private Button btnGoogle, btnIniciarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Vincular vistas
        etCorreo = findViewById(R.id.etCorreo);
        etContrasena = findViewById(R.id.etContrasena);
        btnGoogle = findViewById(R.id.btnGoogle);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);

        // Listener para el botón de Google
        btnGoogle.setOnClickListener(view -> {
            Toast.makeText(LoginActivity.this, "Inicio de sesión con Google no implementado", Toast.LENGTH_SHORT).show();
        });

        // Listener para el botón de iniciar sesión
        btnIniciarSesion.setOnClickListener(view -> {
            String correo = etCorreo.getText().toString();
            String contrasena = etContrasena.getText().toString();

            if (!correo.isEmpty() && !contrasena.isEmpty()) {
                if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
                    Toast.makeText(LoginActivity.this, "Por favor, ingresa un correo válido", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (Character.isDigit(correo.charAt(0))){
                    Toast.makeText(LoginActivity.this, "Entrando como USUARIO\n"+correo, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent (LoginActivity.this,MenuAlumnes.class);
                    startActivity(intent);
                    finish();

                }else if (correo.charAt(0)=='a'|| correo.charAt(0)=='A'){
                    Toast.makeText(LoginActivity.this, "Entrando como ADMIN\n"+correo, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this,MenuAdmins.class);
                    startActivity(intent);
                    finish();
                }
                else if (Character.isAlphabetic(correo.charAt(0)) && (correo.charAt(0)!='a' || correo.charAt(0)!='A')) {
                    Toast.makeText(LoginActivity.this, "Entrando como PROFESOR\n"+correo, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MenuProfessors.class);
                    startActivity(intent);
                    finish();
                }



            } else {
                Toast.makeText(LoginActivity.this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

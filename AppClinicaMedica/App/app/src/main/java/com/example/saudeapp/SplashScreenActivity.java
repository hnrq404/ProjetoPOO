package com.example.saudeapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDateTime;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);
        inicializarDadosExemplo();
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }, 3000);
    }

    private void inicializarDadosExemplo() {
        // Cadastrar médicos
        Medico medico1 = new Medico("Dr. João Silva", 45, "CRM12345", "Cardiologia");
        Medico.adicionarMedico(medico1);

        Medico medico2 = new Medico("Dra. Maria Oliveira", 38, "CRM67890", "Pediatria");
        Medico.adicionarMedico(medico2);

        // Marcar consultas
        Paciente paciente1 = new Paciente("Carlos Almeida", 30, "", "");
        LocalDateTime dataConsulta1 = LocalDateTime.parse("2024-11-10T10:30");
        Consulta consulta1 = new Consulta(paciente1, medico1, dataConsulta1);
        Consulta.adicionarConsulta(consulta1);

        Paciente paciente2 = new Paciente("Ana Santos", 25, "", "");
        LocalDateTime dataConsulta2 = LocalDateTime.parse("2024-11-15T14:00");
        Consulta consulta2 = new Consulta(paciente2, medico2, dataConsulta2);
        Consulta.adicionarConsulta(consulta2);
    }
}

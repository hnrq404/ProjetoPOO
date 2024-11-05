package com.example.saudeapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class VerificarConsultasActivity extends AppCompatActivity {

    private ListView listViewConsultas;
    private ArrayAdapter<String> consultasAdapter;
    private List<String> consultasList;
    private SearchView searchViewEspecialidade;
    private TextView consultaCountTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificar_consultas);

        listViewConsultas = findViewById(R.id.listViewConsultas);
        searchViewEspecialidade = findViewById(R.id.searchEspecialidade);
        consultaCountTextView = findViewById(R.id.consultaCountTextView);

        // Voltar à tela principal
        findViewById(R.id.back_btn).setOnClickListener(view -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });

        // Carregar todas as consultas inicialmente
        consultasList = carregarConsultas();
        consultasAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, consultasList);
        listViewConsultas.setAdapter(consultasAdapter);

        // Configurar o SearchView para filtrar por especialidade
        searchViewEspecialidade.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filtrarConsultasPorEspecialidade(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filtrarConsultasPorEspecialidade(newText);
                return true;
            }
        });

        // Exibir contagem total de consultas inicialmente
        atualizarContagemDeConsultas(Consulta.obterConsultas().size());
    }

    // Método para carregar as consultas na lista
    private List<String> carregarConsultas() {
        List<String> listaConsultas = new ArrayList<>();
        List<Consulta> consultas = Consulta.obterConsultas();

        for (Consulta consulta : consultas) {
            String detalhesConsulta = "Paciente: " + consulta.getPaciente().getNome() +
                    ", Médico: " + consulta.getMedico().getNome() +
                    ", Especialidade: " + consulta.getMedico().getEspecialidade() +
                    ", Data: " + consulta.getData().toString();
            listaConsultas.add(detalhesConsulta);
        }

        return listaConsultas;
    }

    // Método para filtrar as consultas por especialidade
    private void filtrarConsultasPorEspecialidade(String especialidade) {
        List<Consulta> consultas = Consulta.obterConsultas();
        List<String> consultasFiltradas = new ArrayList<>();
        int totalConsultasEspecialidade = 0;

        for (Consulta consulta : consultas) {
            if (consulta.getMedico().getEspecialidade().equalsIgnoreCase(especialidade)) {
                String detalhesConsulta = "Paciente: " + consulta.getPaciente().getNome() +
                        ", Médico: " + consulta.getMedico().getNome() +
                        ", Data: " + consulta.getData().toString();
                consultasFiltradas.add(detalhesConsulta);
                totalConsultasEspecialidade++;
            }
        }

        // Atualizar o adapter com as consultas filtradas
        consultasAdapter.clear();
        consultasAdapter.addAll(consultasFiltradas);
        consultasAdapter.notifyDataSetChanged();

        // Atualizar a contagem de consultas para a especialidade filtrada
        atualizarContagemDeConsultas(totalConsultasEspecialidade);
    }

    // Método para atualizar a contagem de consultas no TextView
    private void atualizarContagemDeConsultas(int totalConsultas) {
        consultaCountTextView.setText("Total de consultas da especialidade: " + totalConsultas);
    }
}

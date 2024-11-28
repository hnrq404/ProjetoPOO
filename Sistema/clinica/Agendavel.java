package clinica;

// Interface: Agendável
public interface Agendavel {
    void agendarConsulta(String paciente, String data, String hora);

    boolean cancelarConsulta(String paciente, String data);
}

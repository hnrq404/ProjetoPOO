package eventos;

public interface Reservavel {
    void definirCronograma(String horario, String atividade);

    void adicionarPalestrante(String nome);

    void adicionarPalestrante(String nome, String areaDeEspecialidade);
}

package eventos;

public class Seminario extends Evento {

    private String tema;

    public Seminario(String nome,String descricao,Local local, String tema) {
        super(nome, descricao, local);
        this.tema = tema;
    }

    public String getTema() {
        return tema;
    }

    // Sobrecarga adicional: Convidados
    public void adicionarConvidado(String nome) {
        System.out.println("Convidado '" + nome + "' adicionado ao Seminário '" + getNome() + "'.");
    }

    public void adicionarConvidado(String nome, String areaDeEspecialidade) {
        System.out.println("Convidado '" + nome + "' (Especialidade: " + areaDeEspecialidade + ") adicionado ao Seminário '" + getNome() + "'.");
    }

    @Override
    public void organizarEvento() {
        System.out.println("Organizando o Seminário '" + getNome() + "' sobre o tema '" + tema + "'.");
    }
}
